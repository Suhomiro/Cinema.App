package arturs.suhomiro.cinemaapp

import retrofit2.Callback

class Repository(private val remoteDataSource: RemoteDataSource): RepositoryInterface {
    override fun getMovieDetailsFromNowPlaying(callback: Callback<MovieDTO>) {
        remoteDataSource.getMovieDetailsNowPlay(callback)
    }

}

   /* override fun getMovieFromComingSoon(): List<MovieDTO> {
        return getComingSoon()
    }

    override fun getMovieFromSport(): List<MovieDTO> {
        return getSportMovie()
    }*/
