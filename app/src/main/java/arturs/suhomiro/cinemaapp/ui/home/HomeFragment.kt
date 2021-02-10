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
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {


    private lateinit var viewModel: HomeViewModel
    private val adapterNowPlay = RecycleAdapterHome()
    private val adapterComingSoon = RecycleAdapterHome()
    private val adapterSport = RecycleAdapterHome()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_home, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        viewModel.getDataFromLocalSource()

        viewModel.getMovieDataNowPlay().observe(viewLifecycleOwner, Observer { renderData(it) })
        nowPlayRecycleView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        nowPlayRecycleView.adapter = adapterNowPlay

        viewModel.getMovieDataComingSoon().observe(viewLifecycleOwner, Observer { renderData(it) })
        comingSoonRecycleView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        comingSoonRecycleView.adapter = adapterComingSoon

        viewModel.getMovieDataSport().observe(viewLifecycleOwner, Observer { renderData(it) })
        sportRecycleView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        sportRecycleView.adapter = adapterSport

    }

    private fun renderData(movieList: List<MovieData>) {
            adapterNowPlay.setMovie(getNowPlayMovie())
            adapterComingSoon.setMovie(getComingSoon())
            adapterSport.setMovie(getSportMovie())
        }

    }
