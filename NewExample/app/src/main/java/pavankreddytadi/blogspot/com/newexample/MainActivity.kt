package pavankreddytadi.blogspot.com.newexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import pavankreddytadi.blogspot.com.newexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        /*Initializing the variable created on the xml file with mainViewModel Object*/
        binding.mvmVar = mainViewModel

        binding.setLifecycleOwner(this)

        /* LiveData objects will only update the ACTIVE OBSERVERS on the activity/Fragments */
        /*mainViewModel.count.observe(this, Observer {
            binding.textView.text = mainViewModel.count.value.toString()
        })*/

       /* //Button is for decrementing the count by one
        binding.button.setOnClickListener {
            mainViewModel.decrement()
        }

        //Button is for Incrementing the count by one
        binding.button2.setOnClickListener {
            mainViewModel.increment()
        }*/
    }
}
