package arturs.suhomiro.cinemaapp

import retrofit2.Callback

interface RepositoryInterface {
    fun getMovieDetailsFromNowPlaying(
            callback: Callback<MovieDTO>
    )
    //fun getMovieFromComingSoon(): List<MovieDTO>
   // fun getMovieFromSport(): List<MovieDTO>
}