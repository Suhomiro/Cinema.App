package arturs.suhomiro.cinemaapp.repository

import retrofit2.Callback

interface RepositoryInterface {
    fun getMovieFromNowPlaying(
            callback: Callback<MovieDTO>
    )
    fun getMovieFromComingSoon(
            callback: Callback<MovieDTO>
    )
    fun getMovieFromTopRated(
            callback: Callback<MovieDTO>
    )
    fun getMovieFromPopular(
            callback: Callback<MovieDTO>
    )
}