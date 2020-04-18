package pavankreddytadi.blogspot.com.roomdatabase.Databases

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student_details")
data class StudentDetails(

    @PrimaryKey(autoGenerate = true)
    var student_id : Int = 0,

    var student_name : String = "",

    var student_age : Int = 0

)
