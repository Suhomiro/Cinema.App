package arturs.suhomiro.cinemaapp.ui.discription

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import arturs.suhomiro.cinemaapp.MovieData
import arturs.suhomiro.cinemaapp.R
import kotlinx.android.synthetic.main.description_fragment.*

@Suppress("NAME_SHADOWING")
class DescriptionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.description_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val cinema = arguments?.getParcelable<MovieData>(BUNDLE_EXTRA)
        cinema?.let { cinema ->
            val movieData = cinema
            movieDiscriptionTextView.text = cinema.movie
            movieItalicDicriptionTextView.text = cinema.movie
            yearDiscriptionTextView.text = cinema.year.toString()
            dicriptionImageView.setImageResource(cinema.img)
            rateDiscriptionTextView.text = cinema.rate.toString()
        }
    }
    companion object {
        const val BUNDLE_EXTRA = "weather"

        fun newInstance(bundle: Bundle): DescriptionFragment {
            val fragment = DescriptionFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

}





