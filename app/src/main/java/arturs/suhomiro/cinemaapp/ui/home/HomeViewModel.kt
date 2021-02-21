package arturs.suhomiro.cinemaapp.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import arturs.suhomiro.cinemaapp.*

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val SERVER_ERROR = "Ошибка сервера"
private const val REQUEST_ERROR = "Ошибка запроса на сервер"
private const val CORRUPTED_DATA = "Неполные данные"

class HomeViewModel (
    private val detailsLiveData: MutableLiveData<MovieDTO> = MutableLiveData(),
    private val detailsRepositoryImpl: Repository = Repository(RemoteDataSource())
) : ViewModel() {
    private val callBack = object :
            Callback<MovieDTO> {

        override fun onResponse(call: Call<MovieDTO>, response: Response<MovieDTO>) {
            val serverResponse: MovieDTO? = response.body()
            detailsLiveData.postValue(
                    serverResponse
            )
        }

        override fun onFailure(call: Call<MovieDTO>, t: Throwable) {
            TODO("Not yet implemented")
        }
    }


        fun getLiveData() = detailsLiveData

        fun getWeatherFromRemoteSource() {

            detailsRepositoryImpl.getMovieDetailsFromNowPlaying(callBack)
        }


     //   @Suppress("NullChecksToSafeCall")
       // private fun getCheckedResponse(serverResponse: MovieInfo?): ErrorCheck {

           // return if (serverResponse?.posterPath == null || serverResponse.releaseDate == null || serverResponse.voteAverage == null || serverResponse.title == null) {
               // ErrorCheck.Error(Throwable(CORRUPTED_DATA))
           // } else {
            //}
        //}
    }
