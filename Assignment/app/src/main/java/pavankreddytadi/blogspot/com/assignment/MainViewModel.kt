package pavankreddytadi.blogspot.com.assignment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){

    val list = MutableLiveData<MutableList<String>>()
    var index = MutableLiveData<Int>()
    var word = MutableLiveData<String>()
    var word_list = MutableLiveData<String>()

    init {
        val items = mutableListOf("Apple","Banana")
        list.value = items
        index.value = 0
        displayWord(index.value!!)
        createWordString(list.value!!)
    }

    private fun createWordString(value: MutableList<String>) {
        var w : String = ""
        for(i in value){
            w = w + i + " "
        }
        word_list.value = w
    }

    fun updateList(){
        val items = list.value
        for(i in 0..9){
            items?.add("Grapes ${i+1}")
        }
        createWordString(list.value!!)
    }

    fun nextWord(){
        if(index.value?.plus(1)!! < list.value?.size!!){
            index.value = index.value?.plus(1)
            displayWord(index.value!!)
        }
    }

    fun prevWord(){
        if(index.value?.minus(1)!! >= 0){
            index.value = index.value?.minus(1)
            displayWord(index.value!!)
        }
    }

    private fun displayWord(value: Int) {
        val items = list.value
        word.value = items?.get(value)
    }

}