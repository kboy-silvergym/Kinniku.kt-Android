package net.kboy.kinniku_kt

import android.app.Fragment
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import net.kboy.kinniku_kt.dummy.DummyContent

class MainActivity : AppCompatActivity(), AboutAppFragment.OnListFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener {
            lateinit var fragment: android.support.v4.app.Fragment

            when (it.itemId) {
                R.id.nav_timeline -> {
                    fragment = AboutFragment()
                }
                R.id.nav_schedule -> {
                    fragment = AboutFragment()
                }
                R.id.nav_speaker -> {
                    fragment = AboutFragment()
                }
                R.id.nav_sponsor -> {
                    fragment = AboutFragment()
                }
                R.id.nav_aboutApp -> {
                    fragment = AboutAppFragment()
                }
            }
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.flContent, fragment)
            transaction.commit()

            drawer_layout.closeDrawer(GravityCompat.START)
            return@setNavigationItemSelectedListener true
        }
    }

    override fun onListFragmentInteraction(item: DummyContent.DummyItem?) {

    }
}
