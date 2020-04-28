package youtube.com.vidhvan.githubrepos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import youtube.com.vidhvan.githubrepos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Callback<List<Repo>> {

    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        //Create a retrofit object with a converter.
        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()

        val gitHubService : GitHubService = retrofit.create(GitHubService::class.java)
        gitHubService.listRepos("pavankumart46").enqueue(this)
    }

    override fun onFailure(call: Call<List<Repo>>, t: Throwable) {
        Toast.makeText(this,"Data Fetching Failed",Toast.LENGTH_SHORT).show()
    }

    override fun onResponse(call: Call<List<Repo>>, response: Response<List<Repo>>) {
        binding.response.text = ""
        if(response.isSuccessful){
            val list = response.body()
            for(i in list!!){
                binding.response.append(i.name+"\n")
            }
        }
    }

}
