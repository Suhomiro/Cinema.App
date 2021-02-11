package arturs.suhomiro.cinemaapp.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import arturs.suhomiro.cinemaapp.MovieData
import arturs.suhomiro.cinemaapp.OnViewOnClickListener
import arturs.suhomiro.cinemaapp.R
import kotlinx.android.synthetic.main.item_recycle_view.view.*


class RecycleAdapterHome(var onViewOnClickListener: OnViewOnClickListener?): RecyclerView.Adapter<RecycleAdapterHome.MainViewHolder>() {



    private var movieData: List<MovieData> = listOf()

    fun setMovie(data: List<MovieData>) {
        movieData = data
        notifyDataSetChanged()
    }

    fun removeListener() {
        onViewOnClickListener = null
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleAdapterHome.MainViewHolder {
        return MainViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_recycle_view, parent, false) as View)
    }

    override fun onBindViewHolder(holder: RecycleAdapterHome.MainViewHolder, position: Int) {
        holder.bind(movieData[position])
    }

    override fun getItemCount(): Int {
        return movieData.size
    }

    inner class MainViewHolder(view: View): RecyclerView.ViewHolder(view){
        fun bind(movieData: MovieData) {
            itemView.cinemaTextView.text = movieData.movie
            itemView.rateTextView.text = movieData.rate.toString()
            itemView.yearTextView.text = movieData.year.toString()
            itemView.cinemaImageView.setImageResource(movieData.img)
            itemView.setOnClickListener {
                onViewOnClickListener?.onItemViewClick(movieData) }
        }

    }

    }


