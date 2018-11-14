package net.kboy.kinniku_kt.ui

import android.os.Bundle
import android.view.Menu
import androidx.fragment.app.Fragment
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import net.kboy.kinniku_kt.R
import net.kboy.kinniku_kt.ui.aboutApp.AboutAppFragment
import net.kboy.kinniku_kt.ui.schedule.ScheduleFragment
import net.kboy.kinniku_kt.ui.speaker.SpeakerFragment
import net.kboy.kinniku_kt.ui.sponsor.SponsorFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener {
            lateinit var fragment: Fragment

            when (it.itemId) {
                R.id.nav_about -> {
                    fragment =
                            WebViewFragment.create("https://kinniku-swift.connpass.com/event/99895/")
                }
                R.id.nav_schedule -> {
                    fragment = ScheduleFragment()
                }
                R.id.nav_speaker -> {
                    fragment = SpeakerFragment()
                }
                R.id.nav_sponsor -> {
                    fragment = SponsorFragment()
                }
                R.id.nav_aboutApp -> {
                    fragment = AboutAppFragment()
                }
            }
            showFragment(fragment)

            drawer_layout.closeDrawer(GravityCompat.START)
            return@setNavigationItemSelectedListener true
        }

        // 初回のフラグメント
        showFragment(ScheduleFragment())
    }

    fun showFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.flContent, fragment)
        transaction.commit()
    }
}
