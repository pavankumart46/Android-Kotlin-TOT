package pavankreddytadi.blogspot.com.roomdatabase.Databases

import android.app.Application
import androidx.lifecycle.LiveData

class StudentRepository(application: Application){

    private val studentDao : StudentDao
    private val studentlist : LiveData<List<StudentDetails>>

    init {
        val studentDatabase:StudentDatabase = StudentDatabase.getInstance(application)
        studentDao = studentDatabase.studentDao
        studentlist = studentDao.getAll()
    }

    fun getAll():LiveData<List<StudentDetails>>{
        return studentlist
    }

    fun insert(studentDetails: StudentDetails){
        studentDao.insert(studentDetails)
    }

}