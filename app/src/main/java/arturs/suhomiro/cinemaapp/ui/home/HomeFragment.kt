package arturs.suhomiro.cinemaapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import arturs.suhomiro.cinemaapp.*
import arturs.suhomiro.cinemaapp.repository.MovieDTO
import arturs.suhomiro.cinemaapp.repository.MovieInfo
import arturs.suhomiro.cinemaapp.ui.discription.DescriptionFragment
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {
    private lateinit var viewModel: HomeViewModel


    private val adapterNowPlay = RecycleAdapterHome(object : OnViewOnClickListener {
        override fun onItemViewClick(movieData: MovieInfo) {
            val manager = activity?.supportFragmentManager

            if (manager != null) {
                val bundle = Bundle()
                bundle.putParcelable(DescriptionFragment.BUNDLE_EXTRA, movieData)
                manager.beginTransaction()
                    .add(R.id.conteinerDiscription, DescriptionFragment.newInstance(bundle))
                    .addToBackStack("")
                    .commitAllowingStateLoss()
            }
        }

    })

    private val adapterComingSoon = RecycleAdapterHome(object : OnViewOnClickListener {
        override fun onItemViewClick(movieData: MovieInfo) {
            val manager = activity?.supportFragmentManager

            if (manager != null) {
                val bundle = Bundle()
                bundle.putParcelable(DescriptionFragment.BUNDLE_EXTRA, movieData)
                manager.beginTransaction()
                    .add(R.id.conteinerDiscription, DescriptionFragment.newInstance(bundle))
                    .addToBackStack("")
                    .commitAllowingStateLoss()
            }
        }


    })

    private val adapterTopRated = RecycleAdapterHome(object : OnViewOnClickListener {
        override fun onItemViewClick(movieData: MovieInfo) {
           val manager = activity?.supportFragmentManager

            if (manager != null) {
                val bundle = Bundle()
                bundle.putParcelable(DescriptionFragment.BUNDLE_EXTRA, movieData)
                manager.beginTransaction()
                    .replace(R.id.conteinerDiscription, DescriptionFragment.newInstance(bundle))
                        .addToBackStack("")
                    .commitAllowingStateLoss()
            }
        }
    })

    private val adapterPopular = RecycleAdapterHome(object : OnViewOnClickListener {
        override fun onItemViewClick(movieData: MovieInfo) {
              val manager = activity?.supportFragmentManager

              if (manager != null) {
                  val bundle = Bundle()
                  bundle.putParcelable(DescriptionFragment.BUNDLE_EXTRA, movieData)
                  manager.beginTransaction()
                      .replace(R.id.conteinerDiscription, DescriptionFragment.newInstance(bundle))
                          .addToBackStack("")
                      .commitAllowingStateLoss()
        }
        }
    })


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_home, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        nowPlayRecycleView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        nowPlayRecycleView.adapter = adapterNowPlay
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        viewModel.getNowPlayingMovie()
        viewModel.getLiveDataNowPlaying().observe(viewLifecycleOwner, Observer { renderDataNowPlaying(it) })

        comingSoonRecycleView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        comingSoonRecycleView.adapter = adapterComingSoon
        viewModel.getComingSoonMovie()
        viewModel.getLiveDataComingSoon().observe(viewLifecycleOwner, Observer { renderDataComingSoon(it) })

        topRatedRecycleView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        topRatedRecycleView.adapter = adapterTopRated
        viewModel.getTopRatedMovie()
        viewModel.getLiveDataTopRated().observe(viewLifecycleOwner, Observer { renderDataTopRated(it) })

        popularRecycleView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        popularRecycleView.adapter = adapterPopular
        viewModel.getPopularMovie()
        viewModel.getLiveDataPopular().observe(viewLifecycleOwner, Observer { renderDataPopular(it) })


    }

    private fun renderDataNowPlaying(movieInfo: MovieDTO) {
        adapterNowPlay.setMovie(movieInfo.movieInfo)
    }
    private fun renderDataComingSoon(movieInfo: MovieDTO) {
        adapterComingSoon.setMovie(movieInfo.movieInfo)
    }
    private fun renderDataTopRated(movieInfo: MovieDTO) {
        adapterTopRated.setMovie(movieInfo.movieInfo)
    }
    private fun renderDataPopular(movieInfo: MovieDTO) {
        adapterPopular.setMovie(movieInfo.movieInfo)
    }


    companion object {
        fun newInstance() = HomeFragment()
    }
    }


