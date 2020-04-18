package pavankreddytadi.blogspot.com.roomdatabase

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import pavankreddytadi.blogspot.com.roomdatabase.Databases.StudentDetails
import pavankreddytadi.blogspot.com.roomdatabase.Databases.StudentRepository
import java.lang.Appendable

class MainViewModel(application:Application):AndroidViewModel(application)
{
    val studentRepository : StudentRepository
    val allStudents : LiveData<List<StudentDetails>>

    init {
        studentRepository = StudentRepository(application)
        allStudents = studentRepository.getAll()

    }

    fun insert(studentDetails: StudentDetails){
        studentRepository.insert(studentDetails)
    }
}