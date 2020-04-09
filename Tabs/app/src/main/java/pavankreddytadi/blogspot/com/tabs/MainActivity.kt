package pavankreddytadi.blogspot.com.tabs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
lateinit var vp : ViewPager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vp = findViewById(R.id.viewpager)
        val vpa : ViewPagerAdapter = ViewPagerAdapter(supportFragmentManager,3)
        val tl : TabLayout = findViewById(R.id.tablayout)
        vp.adapter = vpa
        tl.setupWithViewPager(vp)
    }

    class ViewPagerAdapter(fm : FragmentManager, v : Int) : FragmentStatePagerAdapter(fm,v){

        override fun getCount(): Int {
            return 3
        }

        override fun getPageTitle(position: Int): CharSequence? {
            when(position){
                0 -> return "Blue"
                1 -> return "Green"
                2 -> return "Red"
            }
            return super.getPageTitle(position)
        }

        override fun getItem(position: Int): Fragment {
            when(position){
                0 -> return First()
                1 -> return Second()
                2 -> return Third()
            }
            return null!!
        }

    }
}
