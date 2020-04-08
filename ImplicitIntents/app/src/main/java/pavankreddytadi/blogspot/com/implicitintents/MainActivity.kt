package pavankreddytadi.blogspot.com.implicitintents

import android.app.Activity
import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openProfile(view: View) {
        val i = Intent()
        i.setAction(ACTION_VIEW)
        i.setData(Uri.parse("https://tpkreddy.github.io/"))
        startActivity(i)
    }

    fun openCamera(view: View) {
        val i = Intent()
        i.setAction(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(i,200)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 200){
            if(resultCode == Activity.RESULT_OK && data != null){
                val img = data.getParcelableExtra<Bitmap>("data")
                val iv = findViewById<ImageView>(R.id.imageView)
                iv.setImageBitmap(img)
            }
        }
    }

}
