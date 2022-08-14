package com.roger.assignment_2.view.adapter

import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.roger.assignment_2.view.SongFragment

private val number_of_tab = 3

class SongGenreAdapter(fm: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fm, lifecycle) {
    override fun createFragment(position: Int): Fragment {
        return SongFragment(position)

    }

    override fun getItemCount(): Int {
        return number_of_tab
    }
}
