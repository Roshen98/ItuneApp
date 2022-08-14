package com.roger.assignment_2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.roger.assignment_2.view.adapter.SongGenreAdapter
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        song_view.adapter = SongGenreAdapter(supportFragmentManager, lifecycle)

        TabLayoutMediator(genre_tab, song_view) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Rock"
                    tab.setIcon(R.drawable.rock)

                }
                1 -> {
                    tab.text = "Classic"
                    tab.setIcon(R.drawable.classic)
                }
                2 -> {
                    tab.text = "Pop"
                    tab.setIcon(R.drawable.pop)
                }
            }
        }.attach()


    }


}