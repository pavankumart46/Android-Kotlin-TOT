package pavankreddytadi.blogspot.com.myapplication

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.work.Worker
import androidx.work.WorkerParameters
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyWorker(val context:Context,workerParameters: WorkerParameters) : Worker(context,workerParameters){

    override fun doWork(): Result {
        CoroutineScope(Dispatchers.Main).launch {
            WaitFor5Seconds(context)
        }

        return Result.success()
    }

    suspend fun WaitFor5Seconds(context: Context){
        Thread.sleep(5000)
        showNotification(context)
    }

    private fun showNotification(context: Context) {

        val notificationManager : NotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val notificationChannel: NotificationChannel
                    = NotificationChannel("NOTIFY","MYNEWCHANNEL", NotificationManager.IMPORTANCE_HIGH)
            notificationChannel.lightColor = Color.WHITE
            notificationChannel.enableVibration(true)
            notificationChannel.description = "MY NOTIFICATION CHANNEL"

            notificationManager.createNotificationChannel(notificationChannel)
        }

        val notification  = NotificationCompat.Builder(context,"NOTIFY")
            .setSmallIcon(R.drawable.ic_insert_emoticon_black_24dp)
            .setContentTitle("WORK FINISHED")
            .setContentText("Yahoo Work Finished!")
            .build()

        notificationManager.notify(23,notification)
    }
}