package pavankreddytadi.blogspot.com.myapplication

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.app.NotificationCompat
import androidx.lifecycle.Observer
import androidx.work.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    lateinit var btn : Button

    lateinit var constraints: Constraints

    lateinit var workRequest: WorkRequest

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn = findViewById(R.id.button)

        //These constraints are set for the work that i have to carry out.
        constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build()

        workRequest = PeriodicWorkRequestBuilder<MyWorker>(1,TimeUnit.MINUTES)
            .setConstraints(constraints)
            .build()


        btn.setOnClickListener {
            WorkManager.getInstance(this).enqueue(workRequest)
        }

        WorkManager.getInstance(this)
            .getWorkInfoByIdLiveData(workRequest.id)
            .observe(this, Observer {workInfo ->
                val tv : TextView = findViewById(R.id.textView)
                if(workInfo!=null)
                {
                    if(workInfo.state == WorkInfo.State.SUCCEEDED){
                        tv.text = "WORK FINISHED"
                    }

                    if(workInfo.state == WorkInfo.State.BLOCKED){
                        tv.text = "WORK Blocked"
                    }

                    if(workInfo.state == WorkInfo.State.CANCELLED){
                        tv.text = "WORK CANCELLED"
                    }

                    if(workInfo.state == WorkInfo.State.ENQUEUED){
                        tv.text = "WORK ENQUEUED"
                    }

                    if(workInfo.state == WorkInfo.State.RUNNING){
                        tv.text = "WORK RUNNING"
                    }
                }
        })
    }

}
