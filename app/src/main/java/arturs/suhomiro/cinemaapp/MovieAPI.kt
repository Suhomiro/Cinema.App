package arturs.suhomiro.cinemaapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.HeaderMap
import retrofit2.http.Query

interface MovieAPI {
    @GET("top_rated")
    fun getNowPlayMovie(
            @Query("api_key") apiKey: String,
            @Query("language") language: String,
            @Query("page") page: Int

    ): Call<MovieDTO>
}