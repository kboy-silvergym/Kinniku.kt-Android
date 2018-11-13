package net.kboy.kinniku_kt.ui.sponsor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_sponsor.*
import net.kboy.kinniku_kt.R
import net.kboy.kinniku_kt.data.PersonalSponsor
import net.kboy.kinniku_kt.data.Sponsor
import net.kboy.kinniku_kt.ui.MainActivity
import net.kboy.kinniku_kt.ui.WebViewFragment
import net.kboy.kinniku_kt.viewmodel.SponsorViewModel

class SponsorFragment : Fragment() {
    private val viewModel by lazy {
        ViewModelProviders.of(activity!!).get(SponsorViewModel::class.java)
    }

    private val sponsorAdapter by lazy {
        SponsorAdapter({
            // webに飛ばす
            showSponsorDetail(it)
        }, {
            // twitterに飛ばす
            showTwitter(it)
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sponsor, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list.layoutManager = LinearLayoutManager(context)
        list.adapter = sponsorAdapter

        viewModel.sponsors.observe(this, Observer {
            it?.let {
                sponsorAdapter.addSponsor(it)
            }
        })
        viewModel.personalSponsors.observe(this, Observer {
            it?.let {
                sponsorAdapter.addPersonalSponsor(it)
            }
        })
    }

    private fun showSponsorDetail(sponsor: Sponsor) {
        val url = sponsor.url
        val fragment =
            WebViewFragment.create(url)
        showFragment(fragment)
    }

    private fun showTwitter(personalSponsor: PersonalSponsor) {
        val url = "https://twitter.com/" + personalSponsor.screenName
        val fragment =
            WebViewFragment.create(url)
        showFragment(fragment)
    }

    private fun showFragment(fragment: Fragment) {
        (activity as MainActivity).showFragment(fragment)
    }

}
