package pavankreddytadi.blogspot.com.diffutilex2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var list : MutableList<Employee>
    lateinit var adapter : EmployeeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerview)
        populateData()

    }

    private fun populateData() {
        list = mutableListOf(Employee(1,"PAVAN"), Employee(2,"Tandra"))
        adapter = EmployeeAdapter(this)
        adapter.submitList(list)
        recyclerView.adapter = adapter
    }

    fun updateList(view: View) {
        list.set(0,Employee(1,"Mastan"))
        //adapter.submitList(list)
        recyclerView.adapter = adapter
    }

}
