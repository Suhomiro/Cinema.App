package arturs.suhomiro.cinemaapp.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import arturs.suhomiro.cinemaapp.repository.MovieDTO
import arturs.suhomiro.cinemaapp.repository.RemoteDataSource
import arturs.suhomiro.cinemaapp.repository.Repository

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel (
        private val detailsLiveDataNowPlaying: MutableLiveData<MovieDTO> = MutableLiveData(),
        private val detailsLiveDataComingSoon: MutableLiveData<MovieDTO> = MutableLiveData(),
        private val detailsLiveDataTopRated: MutableLiveData<MovieDTO> = MutableLiveData(),
        private val detailsLiveDataPopular: MutableLiveData<MovieDTO> = MutableLiveData(),
        private val nowPlaying: Repository = Repository(RemoteDataSource()),
        private val topRated: Repository = Repository(RemoteDataSource()),
        private val popular: Repository = Repository(RemoteDataSource()),
        private val comingSoon: Repository = Repository(RemoteDataSource())
) : ViewModel() {

    private val callBackNowPlaying = object :
            Callback<MovieDTO> {

        override fun onResponse(call: Call<MovieDTO>, response: Response<MovieDTO>) {
            val serverResponse: MovieDTO? = response.body()
            detailsLiveDataNowPlaying.postValue(
                    serverResponse
            )
        }

        override fun onFailure(call: Call<MovieDTO>, t: Throwable) {
            TODO("Not yet implemented")
        }
    }

    private val callBackComingSoon = object :
            Callback<MovieDTO> {

        override fun onResponse(call: Call<MovieDTO>, response: Response<MovieDTO>) {
            val serverResponse: MovieDTO? = response.body()
            detailsLiveDataComingSoon.postValue(
                    serverResponse
            )
        }

        override fun onFailure(call: Call<MovieDTO>, t: Throwable) {
            TODO("Not yet implemented")
        }
    }

    private val callBackTopRated = object :
            Callback<MovieDTO> {

        override fun onResponse(call: Call<MovieDTO>, response: Response<MovieDTO>) {
            val serverResponse: MovieDTO? = response.body()
            detailsLiveDataTopRated.postValue(
                    serverResponse
            )
        }

        override fun onFailure(call: Call<MovieDTO>, t: Throwable) {
            TODO("Not yet implemented")
        }
    }

    private val callBackPopular = object :
            Callback<MovieDTO> {

        override fun onResponse(call: Call<MovieDTO>, response: Response<MovieDTO>) {
            val serverResponse: MovieDTO? = response.body()
            detailsLiveDataPopular.postValue(
                    serverResponse
            )
        }

        override fun onFailure(call: Call<MovieDTO>, t: Throwable) {
            TODO("Not yet implemented")
        }
    }


        fun getLiveDataNowPlaying() = detailsLiveDataNowPlaying
        fun getLiveDataComingSoon() = detailsLiveDataComingSoon
        fun getLiveDataTopRated() = detailsLiveDataTopRated
        fun getLiveDataPopular() = detailsLiveDataPopular

        fun getNowPlayingMovie() {
            nowPlaying.getMovieFromNowPlaying(callBackNowPlaying)
        }
        fun getComingSoonMovie(){
            comingSoon.getMovieFromComingSoon(callBackComingSoon)
        }
        fun getTopRatedMovie(){
            topRated.getMovieFromTopRated(callBackTopRated)
        }
        fun getPopularMovie(){
            popular.getMovieFromPopular(callBackPopular)
        }
    }
