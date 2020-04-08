package pavankreddytadi.blogspot.com.intents

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import pavankreddytadi.blogspot.com.intents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
lateinit var databinding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*setContentView(R.layout.activity_main)*/
        databinding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        /*Set OnClick Listener on the button*/
        databinding.takebtn.setOnClickListener {
            val intent = Intent(this,SecondActivity::class.java)
            val m = databinding.msg.text.toString()
            intent.putExtra("KEY", m)
            /*startActivity(intent)*/
            startActivityForResult(intent,200)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 200){
            if(resultCode == Activity.RESULT_OK && data != null){
                val r = data.getStringExtra("KEY2")
                val toast = Toast.makeText(this,r,Toast.LENGTH_LONG)
                toast.show()
            }
        }
    }
}
