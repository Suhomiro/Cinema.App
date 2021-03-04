package arturs.suhomiro.cinemaapp.ui.discription

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import arturs.suhomiro.cinemaapp.repository.MovieInfo
import arturs.suhomiro.cinemaapp.R
import arturs.suhomiro.cinemaapp.ui.note.NoteFragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.description_fragment.*

@Suppress("NAME_SHADOWING")
class DescriptionFragment : Fragment() {
    private lateinit var viewModel: DiscriptionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.description_fragment, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val cinema = arguments?.getParcelable<MovieInfo>(BUNDLE_EXTRA)
        cinema.let {
            aboutDisriptionTextView.text = cinema?.overview
            genreDisriptionTextView.text = cinema?.genreIds.toString()
            movieDiscriptionTextView.text = cinema?.title
            movieItalicDicriptionTextView.text = cinema?.title
            yearDiscriptionTextView.text = cinema?.releaseDate
            dataReleaseTextView.text = cinema?.releaseDate
            popularityDiscriptionTextView.text = cinema?.popularity.toString()
            rateCountDiscription.text = cinema?.voteCount.toString()
            rateDiscriptionTextView.text = cinema?.voteAverage.toString()
            origTitleDiscriptionTextView.text = cinema?.originalTitle
            languageDiscriptionTextView.text = cinema?.originalLanguage
            Picasso.get().load("https://image.tmdb.org/t/p/w500" + cinema?.posterPath).fit().centerInside().into(dicriptionImageView)
        }
        noteAddImageButton.setOnClickListener {
            val fragment = NoteFragment()
            val manager = activity?.supportFragmentManager
            manager?.commit {
                setCustomAnimations(
                        R.anim.right_to_left,
                        R.anim.right_to_left
                )
                replace(R.id.noteConteiner, fragment)
                addToBackStack(null)
            }
        }
        viewModel = ViewModelProvider(this).get(DiscriptionViewModel::class.java)
        viewModel.getImageChange(isDarkThemeOn())
        viewModel.getBackgroundColor().observe(viewLifecycleOwner, Observer { renderBackgroundColor(it)})
    }

    private fun isDarkThemeOn(): Boolean {
        return resources.configuration.uiMode and
                Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES
    }

    private fun renderBackgroundColor(color: Int){
        descriptionConstraint.setBackgroundResource(color)
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





