package net.kboy.kinniku_kt.ui.sponsor

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_sponsor.*
import net.kboy.kinniku_kt.R
import net.kboy.kinniku_kt.viewmodel.SponsorViewModel

class SponsorFragment : Fragment() {
    private val viewModel by lazy {
        ViewModelProviders.of(activity!!).get(SponsorViewModel::class.java)
    }

    private val sponsorAdapter by lazy {
        SponsorAdapter()
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
}
