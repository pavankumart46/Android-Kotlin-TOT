package pavankreddytadi.blogspot.com.charadesgame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

/**
 * A simple [Fragment] subclass.
 */
class GameFragment : Fragment() {

    lateinit var score_tv : TextView
    lateinit var word_tv : TextView
    var score = 0
    var words = ""
    var wordslist : MutableList<String> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_game, container, false)
        score_tv = v.findViewById(R.id.tv_score)
        word_tv = v.findViewById(R.id.tv_word)
        val gotit = v.findViewById<Button>(R.id.btn_gotit)
        val skip = v.findViewById<Button>(R.id.btn_skip)
        val endgame = v.findViewById<Button>(R.id.btn_endgame)
        resetWords()
        initViews()
        gotit.setOnClickListener {
            if(score<10){
                score++
            }
            score_tv.text = score.toString()
            initViews()
        }

        skip.setOnClickListener {
            if(score>-10){
                score--
            }
            score_tv.text = score.toString()
            initViews()
        }

        return v
    }

    private fun initViews() {
        if(wordslist.isEmpty()){
            words = "ALL WORDS ARE COMPLETE"
        }
        else{
            words = wordslist.removeAt(0)
        }
        word_tv.text = words
    }

    fun resetWords(){
        wordslist = mutableListOf("Duck","Dog","fox","chocolate","table","chair","Mouse","Cat","Elephant","Coat")
        wordslist.shuffle()
    }

}
