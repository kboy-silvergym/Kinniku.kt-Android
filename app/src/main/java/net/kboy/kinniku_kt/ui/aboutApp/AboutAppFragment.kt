package net.kboy.kinniku_kt.ui.aboutApp

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import net.kboy.kinniku_kt.ui.MainActivity
import net.kboy.kinniku_kt.R
import net.kboy.kinniku_kt.ui.WebViewFragment

class AboutAppFragment : Fragment() {
    private val menuString: Array<String> = arrayOf("バージョン", "github")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_aboutappfragment, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = LinearLayoutManager(context)
                adapter = AboutAppAdapter(menuString) {
                    when (it) {
                        1 -> {
                            // github
                            val fragment =
                                WebViewFragment.create("https://github.com/kboy-silvergym/Kinniku.kt-Android")
                            showFragment(fragment)
                        }
                    }
                }
            }
        }
        return view
    }

    private fun showFragment(fragment: Fragment){
        (activity as MainActivity).showFragment(fragment)
    }
}
