package com.roger.assignment_2.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.roger.assignment_2.R
import com.roger.assignment_2.databinding.SongListFragmentLayoutBinding
import com.roger.assignment_2.view.adapter.SongAdapter
import com.roger.assignment_2.view.model.SongItem
import com.roger.assignment_2.view.viewmodel.SongViewModel


class SongFragment(private val position: Int): Fragment() {

    private lateinit var binding: SongListFragmentLayoutBinding


    private lateinit var _swipeRefreshLayout: SwipeRefreshLayout
    private val swipeRefreshLayout get() = _swipeRefreshLayout



    private val viewModel: SongViewModel by lazy {
        ViewModelProvider(this)[SongViewModel::class.java]
    }

    private lateinit var adapter: SongAdapter

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SongListFragmentLayoutBinding.inflate(inflater, container, false)

        when(position){
            0 -> {
                viewModel.detailsRock()
                binding.root.setBackgroundResource(R.color.red)

            }

            1 -> {
                viewModel.detailsClassic()
                binding.root.setBackgroundResource(R.color.blue)
            }
            2 -> {
                viewModel.detailsPop()
                binding.root.setBackgroundResource(R.color.pink)
            }
        }

        binding.swipeRefreshLayout.setOnRefreshListener {

            Toast.makeText(binding.root.context, "Refreshing! Chill out!", Toast.LENGTH_SHORT).show()
            binding.swipeRefreshLayout.isRefreshing = false

        }




        initObservable()

        adapter = SongAdapter()

        binding.songList.adapter = adapter

        binding.songList.layoutManager = LinearLayoutManager(context)




        return binding.root
    }


    private fun initObservable() {

        viewModel.songDetail.observe(viewLifecycleOwner) {
            updateAdapter(it)
            Toast.makeText(context, "Found ${viewModel.resultCount} Result", Toast.LENGTH_SHORT)
                .show()
        }

    }

    private fun updateAdapter(dataSet: List<SongItem>) {
        adapter.submitList(dataSet)
    }
}



