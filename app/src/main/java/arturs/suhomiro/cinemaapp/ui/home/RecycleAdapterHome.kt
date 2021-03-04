package arturs.suhomiro.cinemaapp.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import androidx.recyclerview.widget.RecyclerView
import arturs.suhomiro.cinemaapp.IMAGE_REQUEST
import arturs.suhomiro.cinemaapp.repository.MovieInfo
import arturs.suhomiro.cinemaapp.OnViewOnClickListener
import arturs.suhomiro.cinemaapp.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_recycle_view.view.*


class RecycleAdapterHome(var onViewOnClickListener: OnViewOnClickListener?): RecyclerView.Adapter<RecycleAdapterHome.MainViewHolder>() {


    private var movieInfoData : List<MovieInfo> = listOf()

    fun setMovie(movieInfo: List<MovieInfo>?) {
        if (movieInfo != null) {
            movieInfoData = movieInfo
        }
        notifyDataSetChanged()
    }

    fun removeListener() {
        onViewOnClickListener = null
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecycleAdapterHome.MainViewHolder {
        return MainViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_recycle_view, parent, false) as View
        )
    }

    override fun onBindViewHolder(holder: RecycleAdapterHome.MainViewHolder, position: Int) {
        setFadeAnimation(holder.itemView)
        holder.renderBind(movieInfoData[position])

    }

    private fun setFadeAnimation(view: View) {
        val anim = AlphaAnimation(0.0f, 1.0f)
        anim.duration = 100
        view.startAnimation(anim)

    }


    override fun getItemCount(): Int {
        return movieInfoData.size
    }

    inner class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun renderBind(movieInfo: MovieInfo){
            itemView.yearTextView.text = movieInfo.releaseDate
            itemView.rateTextView.text = movieInfo.voteAverage.toString()
            itemView.cinemaTextView.text = movieInfo.title
            Picasso.get().load(IMAGE_REQUEST + movieInfo.posterPath).fit().centerInside().into(itemView.cinemaImageView)
            itemView.setOnClickListener { onViewOnClickListener?.onItemViewClick(movieInfo) }
        }

    }
}





