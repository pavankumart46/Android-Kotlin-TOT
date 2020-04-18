package pavankreddytadi.blogspot.com.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import pavankreddytadi.blogspot.com.roomdatabase.Databases.StudentDatabase
import pavankreddytadi.blogspot.com.roomdatabase.Databases.StudentDetails

class MainActivity : AppCompatActivity() {

    lateinit var student_name : EditText
    lateinit var student_age : EditText
    lateinit var result_tv : TextView
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        mainViewModel =  ViewModelProvider(this,MainViewModelFactory(application))
                .get(MainViewModel::class.java)

        mainViewModel.allStudents.observe(this, Observer { list ->
            displayData(list)
        })

    }

    private fun initViews() {
        student_name = findViewById(R.id.sname)
        student_age = findViewById(R.id.sage)
        result_tv = findViewById(R.id.result)
    }

    fun saveData(view: View) {
        val n = student_name.text.toString()
        val a : Int = (student_age.text.toString()).toInt()
        val studentDetails : StudentDetails = StudentDetails(student_name = n,student_age = a)

        mainViewModel.insert(studentDetails)

        Toast.makeText(this,"DATA INSERTION SUCCESSFUL",Toast.LENGTH_SHORT).show()
        student_name.setText("")
        student_age.setText("")
        student_name.clearFocus()
        student_age.clearFocus()

    }

    private fun displayData(list: List<StudentDetails>) {
        result_tv.text = ""
        for(i in list){
            result_tv.append(""+i.student_id+" "+i.student_name+" "+i.student_age+"\n\n\n")
        }
    }
}
