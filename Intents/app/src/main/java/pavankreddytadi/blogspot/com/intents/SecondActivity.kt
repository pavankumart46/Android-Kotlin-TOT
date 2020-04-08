package pavankreddytadi.blogspot.com.intents

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import pavankreddytadi.blogspot.com.intents.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
lateinit var bind : ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = DataBindingUtil.setContentView(this,R.layout.activity_second)
        bind.result.text = intent.getStringExtra("KEY")
    }

    fun giveReply(view: View) {
        val r = bind.reply.text.toString()
        val i = Intent()
        i.putExtra("KEY2",r)
        setResult(Activity.RESULT_OK,i)
        finish()
    }
}
