package arturs.suhomiro.cinemaapp.ui.note

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import arturs.suhomiro.cinemaapp.interactors.InteractorsImpl

class NoteViewModel: ViewModel() {
    private val designChange: MutableLiveData<Int> = MutableLiveData()
    private var interactorsImpl = InteractorsImpl()

    fun getNoteDesign() = designChange

    fun getNoteDesignChange(boolean: Boolean){
        if(boolean) {
           designChange.postValue(interactorsImpl.noteDesign)
        }
    }

    override fun onCleared() {
        super.onCleared()
    }
}