package arturs.suhomiro.cinemaapp.ui.discription

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import arturs.suhomiro.cinemaapp.interactors.InteractorsImpl

class DiscriptionViewModel : ViewModel() {
    private val backGroundChange: MutableLiveData<Int> = MutableLiveData()
    private var interactorsImpl = InteractorsImpl()

    fun getBackgroundColor() = backGroundChange

    fun getImageChange(boolean: Boolean){
        if(boolean) {
           backGroundChange.postValue(interactorsImpl.backGroundColor)
        }
    }

    override fun onCleared() {
        super.onCleared()
    }
}