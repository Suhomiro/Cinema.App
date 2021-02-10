package arturs.suhomiro.cinemaapp.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import arturs.suhomiro.cinemaapp.MovieData
import arturs.suhomiro.cinemaapp.Repository
import arturs.suhomiro.cinemaapp.ui.AppState

class HomeViewModel  : ViewModel() {

    private val liveDataToObserveNowPlay:MutableLiveData<List<MovieData>> = MutableLiveData()
    private val liveDataToObserveComingSoon:MutableLiveData<List<MovieData>> = MutableLiveData()
    private val liveDataToObserveSport:MutableLiveData<List<MovieData>> = MutableLiveData()
    private val repository: Repository = Repository()

    fun getMovieDataNowPlay() = liveDataToObserveNowPlay
    fun getMovieDataComingSoon() = liveDataToObserveComingSoon
    fun getMovieDataSport() = liveDataToObserveSport


    fun getDataFromLocalSource(){
        Thread{
            Thread.sleep(1000)
            liveDataToObserveNowPlay.postValue(repository.getMovieFromNowPlay())
            liveDataToObserveComingSoon.postValue(repository.getMovieFromComingSoon())
            liveDataToObserveSport.postValue(repository.getMovieFromSport())
        }.start()
    }

    override fun onCleared() {
        super.onCleared()
    }
}



