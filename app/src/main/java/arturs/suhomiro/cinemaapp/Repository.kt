package arturs.suhomiro.cinemaapp

class Repository: RepositoryInterface {
    override fun getMovieFromNowPlay(): List<MovieData> {
        return getNowPlayMovie()
    }

    override fun getMovieFromComingSoon(): List<MovieData> {
        return getComingSoon()
    }

    override fun getMovieFromSport(): List<MovieData> {
        return getSportMovie()
    }
}