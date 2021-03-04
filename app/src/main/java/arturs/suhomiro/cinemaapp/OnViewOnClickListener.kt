package arturs.suhomiro.cinemaapp

import arturs.suhomiro.cinemaapp.repository.MovieInfo

interface OnViewOnClickListener {
    fun onItemViewClick(movieInfo: MovieInfo)
}