package net.kboy.kinniku_kt.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_webview.*
import net.kboy.kinniku_kt.R

class WebViewFragment : Fragment() {

    private val url by lazy {
        arguments?.getSerializable(URL) as String?
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_webview, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (url != null) {
            webView.loadUrl(url)
        }
    }

    companion object {
        private const val URL = "url"

        fun create(url: String) = WebViewFragment().apply {
            arguments = Bundle().apply {
                putSerializable(URL, url)
            }
        }
    }
}
