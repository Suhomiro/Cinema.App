package arturs.suhomiro.cinemaapp.ui

import arturs.suhomiro.cinemaapp.MovieData

sealed class AppState{
    data class Success(val movieData: List<MovieData>) : AppState()
}
