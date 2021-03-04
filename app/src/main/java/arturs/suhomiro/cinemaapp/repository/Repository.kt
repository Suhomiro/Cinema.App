package arturs.suhomiro.cinemaapp.repository

import retrofit2.Callback

class Repository(private val remoteDataSource: RemoteDataSource): RepositoryInterface {
    override fun getMovieFromNowPlaying(callback: Callback<MovieDTO>) {
        remoteDataSource.getMovieDetailsNowPlay(callback)
    }

    override fun getMovieFromComingSoon(callback: Callback<MovieDTO>) {
        remoteDataSource.getMovieDetailsComingSoon(callback)
    }

    override fun getMovieFromTopRated(callback: Callback<MovieDTO>) {
        remoteDataSource.getMovieDetailTopRated(callback)
    }

    override fun getMovieFromPopular(callback: Callback<MovieDTO>) {
        remoteDataSource.getMovieDetailPopular(callback)
    }

}

