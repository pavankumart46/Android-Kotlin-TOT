package pavankreddytadi.blogspot.com.newexample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MainViewModel : ViewModel() {

    var count = MutableLiveData<Int>()

    init {
        count.value = 0
    }

    fun increment(){
        count.value = count.value?.plus(1)
    }

    fun decrement(){
        count.value = count.value?.minus(1)
    }

}