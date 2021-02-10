package arturs.suhomiro.cinemaapp

interface RepositoryInterface {
    fun getMovieFromNowPlay(): List<MovieData>
    fun getMovieFromComingSoon(): List<MovieData>
    fun getMovieFromSport(): List<MovieData>
}