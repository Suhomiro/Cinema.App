package arturs.suhomiro.cinemaapp.repository

import arturs.suhomiro.cinemaapp.MOVIE_API_KEY
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class RemoteDataSource {
    private val language = "en-US"
   // private val language = "ru-RU"
    private val pageOne = 1

    private val movieApi = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/movie/")
        .addConverterFactory(
            GsonConverterFactory.create(
                GsonBuilder().setLenient().create()
            )
        )
        .client(createOkHttpClient(MovieApiInterceptor()))
        .build().create(MovieAPI::class.java)

    fun getMovieDetailsNowPlay(callback: Callback<MovieDTO>) {
        movieApi.getNowPlayMovie(MOVIE_API_KEY,language,pageOne).enqueue(callback)
    }
    fun getMovieDetailsComingSoon(callback: Callback<MovieDTO>){
        movieApi.getComingSoon(MOVIE_API_KEY,language,pageOne).enqueue(callback)
    }
    fun getMovieDetailTopRated(callback: Callback<MovieDTO>){
        movieApi.getTopRated(MOVIE_API_KEY,language,pageOne).enqueue(callback)
    }
    fun getMovieDetailPopular(callback: Callback<MovieDTO>){
        movieApi.getPopular(MOVIE_API_KEY,language,pageOne).enqueue(callback)
    }

    private fun createOkHttpClient(interceptor: Interceptor): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(interceptor)
        httpClient.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        return httpClient.build()
    }

    inner class MovieApiInterceptor : Interceptor {

        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
            return chain.proceed(chain.request())
        }
    }
}

