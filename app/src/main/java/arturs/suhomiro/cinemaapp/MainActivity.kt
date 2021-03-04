package arturs.suhomiro.cinemaapp

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.switch_item.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)

            val navView: BottomNavigationView = findViewById(R.id.nav_view)
            val navController = findNavController(R.id.nav_host_fragment)
            setupActionBarWithNavController(navController)
            navView.setupWithNavController(navController)

        themeChangeBtn.isChecked = isDarkThemeOn()
        switchButtonClickListener()
        //saveSwitchButton()
        //getSwitchButtonState()
    }

    override fun onStop() {
        saveSwitchButton()
        getSwitchButtonState()
        super.onStop()
    }

    private fun changeTheme() {
        if (themeChangeBtn.isChecked) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
        saveSwitchButton()
    }


    private fun getSwitchButtonState(){
             this.getPreferences(Context.MODE_PRIVATE).getBoolean(SWITCH_BTN_KEY, false)
                changeTheme()
    }

    private fun saveSwitchButton(){
            with(this.getPreferences(Context.MODE_PRIVATE).edit()) {
                    putBoolean(SWITCH_BTN_KEY, themeChangeBtn.isChecked)
                    apply()
                }

    }

    private fun switchButtonClickListener(){
        themeChangeBtn.setOnClickListener {
            if (themeChangeBtn.isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }

    private fun isDarkThemeOn(): Boolean {
        return resources.configuration.uiMode and
                Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES
         }

    }
