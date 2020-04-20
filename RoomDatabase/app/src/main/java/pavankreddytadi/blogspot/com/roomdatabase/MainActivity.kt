package pavankreddytadi.blogspot.com.roomdatabase

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import pavankreddytadi.blogspot.com.roomdatabase.Databases.StudentDatabase
import pavankreddytadi.blogspot.com.roomdatabase.Databases.StudentDetails

class MainActivity : AppCompatActivity() {

    lateinit var student_name : EditText
    lateinit var student_age : EditText
    lateinit var mainViewModel: MainViewModel
    lateinit var recyclerview : RecyclerView

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
        recyclerview = findViewById(R.id.recyclerview)
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
        val ra = RecyclerAdapter(this)
        recyclerview.adapter = ra
        ra.submitList(list)
    }

    //We need an Adapter to handle data
    // We need a viewHolder to hold the views

    class RecyclerAdapter(val context:Context) :
        ListAdapter<StudentDetails,RecyclerViewHolder>(StudentDiffUtil())
    {

        class StudentDiffUtil : DiffUtil.ItemCallback<StudentDetails>(){
            override fun areItemsTheSame(
                oldItem: StudentDetails,
                newItem: StudentDetails
            ): Boolean {
                return oldItem.student_id == newItem.student_id
            }

            override fun areContentsTheSame(
                oldItem: StudentDetails,
                newItem: StudentDetails
            ): Boolean {
                return oldItem == newItem
            }

        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder
        {
            val v : View = LayoutInflater.from(context).inflate(R.layout.one_row,parent,false)
            return RecyclerViewHolder(v)
        }


        override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int)
        {
            val l = getItem(position)
            holder.student_id.text = (l.student_id).toString()
            holder.student_age.text = (l.student_age).toString()
            holder.student_name.text = l.student_name
        }

    }

    class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val student_id = itemView.findViewById<TextView>(R.id.student_id)
        val student_name = itemView.findViewById<TextView>(R.id.student_name)
        val student_age = itemView.findViewById<TextView>(R.id.student_age)
    }

}
