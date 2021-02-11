package arturs.suhomiro.cinemaapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieData(
        val movie: String,
        val year: Int,
        val rate: Double,
        val img: Int
    ): Parcelable

fun getNowPlayMovie(): List<MovieData> {
    return listOf(
    MovieData("Batman Begins", 2005, 10.0, R.drawable.dark_knight),
    MovieData("Rush", 2012, 10.0,R.drawable.dark_knight),
    MovieData("Ford", 2019, 10.0,R.drawable.dark_knight),
    MovieData("Need for Speed", 2020, 9.0, R.drawable.dark_knight),
    MovieData("Avatar", 2010, 8.0,R.drawable.dark_knight),
    MovieData("S.W.A.T", 2005, 7.0, R.drawable.dark_knight)
    )
}

fun getComingSoon(): List<MovieData>{
    return listOf(
    MovieData("The DarkKnight", 2021, 0.0, R.drawable.spider_man),
    MovieData("Taxi5", 2021, 0.0, R.drawable.spider_man),
    MovieData("Need for speed: Go", 2021, 0.0,  R.drawable.spider_man),
    MovieData("SpiderMan", 2021, 0.0,  R.drawable.spider_man),
    MovieData("Rush: Senna vs Prost", 2021, 0.0,  R.drawable.spider_man),
    MovieData("War", 2021, 0.0,  R.drawable.spider_man)
    )
}

fun getSportMovie(): List<MovieData>{
    return listOf(
    MovieData("LeMans 24h", 2020, 10.0, R.drawable.le_mans),
    MovieData("Formula 1", 2020, 10.0, R.drawable.le_mans),
    MovieData("World GT", 2020, 10.0,  R.drawable.le_mans),
    MovieData("WEC", 2020, 9.0,  R.drawable.le_mans),
    MovieData("Formula 2", 2020, 8.5,  R.drawable.le_mans),
    MovieData("WRC", 2020, 9.8,  R.drawable.le_mans)
    )
}



