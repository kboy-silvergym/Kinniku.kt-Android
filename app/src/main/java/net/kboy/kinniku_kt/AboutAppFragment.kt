package net.kboy.kinniku_kt

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class AboutAppFragment : Fragment() {
    private val menuString: Array<String> = arrayOf("バージョン", "github")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_aboutappfragment_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = LinearLayoutManager(context)
                adapter = AboutAppRecyclerViewAdapter(menuString) {
                    when (it) {
                        1 -> {
                            // github
                            val fragment = WebViewFragment
                                .create("https://github.com/kboy-silvergym/Kinniku.kt-Android")
                            showFragment(fragment)
                        }
                    }
                }
            }
        }
        return view
    }

    fun showFragment(fragment: Fragment){
        (activity as MainActivity).showFragment(fragment)
    }
}
