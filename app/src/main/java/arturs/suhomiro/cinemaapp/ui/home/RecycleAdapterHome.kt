package arturs.suhomiro.cinemaapp.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import androidx.recyclerview.widget.RecyclerView
import arturs.suhomiro.cinemaapp.MovieDTO
import arturs.suhomiro.cinemaapp.MovieInfo
import arturs.suhomiro.cinemaapp.OnViewOnClickListener
import arturs.suhomiro.cinemaapp.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_recycle_view.view.*


class RecycleAdapterHome(var onViewOnClickListener: OnViewOnClickListener?): RecyclerView.Adapter<RecycleAdapterHome.MainViewHolder>() {


    private var movieInfoData : List<MovieDTO> = listOf()

    fun setMovie(movieDTO: MovieDTO) {
        movieInfoData = listOf(movieDTO)
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
        val anim = ScaleAnimation(
            0.0f, 1.0f, 0.0f, 1.0f,
            Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f
        )
        anim.duration = 100
        view.startAnimation(anim)

    }


    override fun getItemCount(): Int {
        return movieInfoData.size
    }

    inner class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun renderBind(movieInfo: MovieDTO){
            itemView.yearTextView.text = MovieInfo().releaseDate
            itemView.rateTextView.text = MovieInfo().voteAverage.toString()
            itemView.cinemaTextView.text = MovieInfo().title.toString()
            Picasso.get().load(MovieInfo().posterPath).fit().centerInside().into(itemView.cinemaImageView)
            itemView.setOnClickListener { onViewOnClickListener?.onItemViewClick(movieInfo) }
        }

    }
}





