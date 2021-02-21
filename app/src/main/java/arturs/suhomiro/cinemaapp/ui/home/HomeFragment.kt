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


    private val adapterNowPlay = RecycleAdapterHome(object : OnViewOnClickListener {
        override fun onItemViewClick(movieData: MovieDTO) {
            //val manager = activity?.supportFragmentManager

            /*if (manager != null) {
                val bundle = Bundle()
                bundle.putParcelable(DescriptionFragment.BUNDLE_EXTRA, movieData)
                manager.beginTransaction()
                    .add(R.id.conteinerDiscription, DescriptionFragment.newInstance(bundle))
                    .addToBackStack("")
                    .commitAllowingStateLoss()*/
            }
        //}

    })

    private val adapterComingSoon = RecycleAdapterHome(object : OnViewOnClickListener {
        override fun onItemViewClick(movieData: MovieDTO) {
            /*val manager = activity?.supportFragmentManager

            if (manager != null) {
                val bundle = Bundle()
                bundle.putParcelable(DescriptionFragment.BUNDLE_EXTRA, movieData)
                manager.beginTransaction()
                    .add(R.id.conteinerDiscription, DescriptionFragment.newInstance(bundle))
                    .addToBackStack("")
                    .commitAllowingStateLoss()*/
            }
        //}


    })

    private val adapterSport = RecycleAdapterHome(object : OnViewOnClickListener {
        override fun onItemViewClick(movieData: MovieDTO) {
          /*  val manager = activity?.supportFragmentManager

            if (manager != null) {
                val bundle = Bundle()
                bundle.putParcelable(DescriptionFragment.BUNDLE_EXTRA, movieData)
                manager.beginTransaction()
                    .replace(R.id.conteinerDiscription, DescriptionFragment.newInstance(bundle))
                        .addToBackStack("")
                    .commitAllowingStateLoss()*/
            }
        //}
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
        viewModel.getWeatherFromRemoteSource()
        viewModel.getLiveData().observe(viewLifecycleOwner, Observer { renderData(it) })





        viewModel.getLiveData().observe(viewLifecycleOwner, Observer { renderData(it) })
        comingSoonRecycleView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        comingSoonRecycleView.adapter = adapterComingSoon

        viewModel.getLiveData().observe(viewLifecycleOwner, Observer { renderData(it) })
        sportRecycleView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        sportRecycleView.adapter = adapterSport

    }

    private fun renderData(movieDTO: MovieDTO) {
                adapterNowPlay.setMovie(movieDTO)
            }
            //adapterComingSoon.setMovie(getComingSoon())
            //adapterSport.setMovie(getSportMovie())

    companion object {
        fun newInstance() = HomeFragment()
    }
    }


