package arturs.suhomiro.cinemaapp.ui.note

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import arturs.suhomiro.cinemaapp.R
import kotlinx.android.synthetic.main.note_fragment.*

class NoteFragment: Fragment() {
    private lateinit var viewModel: NoteViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.note_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(NoteViewModel::class.java)
        viewModel.getNoteDesignChange(isDarkThemeOn())
        viewModel.getNoteDesign().observe(viewLifecycleOwner, Observer { renderDesignNote(it)})
    }
    private fun isDarkThemeOn(): Boolean {
        return resources.configuration.uiMode and
                Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES
    }

    private fun renderDesignNote(drawable: Int){
        noteConstaint.setBackgroundResource(drawable)
    }
}