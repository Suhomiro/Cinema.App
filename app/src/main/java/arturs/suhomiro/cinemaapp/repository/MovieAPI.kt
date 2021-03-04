package arturs.suhomiro.cinemaapp.repository

import arturs.suhomiro.cinemaapp.repository.MovieDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {
    @GET("now_playing")
    fun getNowPlayMovie(
            @Query("api_key") apiKey: String,
            @Query("language") language: String,
            @Query("page") page: Int

    ): Call<MovieDTO>

    @GET("upcoming")
    fun getComingSoon(
            @Query("api_key") apiKey: String,
            @Query("language") language: String,
            @Query("page") page: Int
    ): Call<MovieDTO>

    @GET("top_rated")
    fun getTopRated(
            @Query("api_key") apiKey: String,
            @Query("language") language: String,
            @Query("page") page: Int
    ): Call<MovieDTO>

    @GET("popular")
    fun getPopular(
            @Query("api_key") apiKey: String,
            @Query("language") language: String,
            @Query("page") page: Int
    ): Call<MovieDTO>

}