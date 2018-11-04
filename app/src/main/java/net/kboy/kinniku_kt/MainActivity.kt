package net.kboy.kinniku_kt

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val strings = resources.getStringArray(R.array.menu_string_array)
        val adapter = ArrayAdapter<String>(this, R.layout.list_row, strings)
        navigation_menu_list.adapter = adapter

        navigation_menu_list.setOnItemClickListener { _, _, position, _ ->
            drawer_layout.closeDrawers()
        }
    }
}
