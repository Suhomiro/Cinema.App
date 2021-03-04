package arturs.suhomiro.cinemaapp.repository

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

 class MovieDTO {

    @SerializedName("page")
    @Expose
    var page: Int? = null

    @SerializedName("results")
    @Expose
    var movieInfo: List<MovieInfo>? = null

    @SerializedName("total_pages")
    @Expose
    var totalPages: Int? = null

    @SerializedName("total_results")
    @Expose
    var totalResults: Int? = null

}

