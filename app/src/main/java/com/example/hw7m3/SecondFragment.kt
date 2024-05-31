package com.example.hw7m3

import AdapterMusic
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hw7m3.databinding.FragmentFirstBinding
import com.example.hw7m3.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    private fun initAdapter() {
        val adapter = AdapterMusic(
            arrayListOf(
                ItemMusic("In Da Club", "James Jackson", "1", "3:56"),
                ItemMusic("Candy Shop", "James Jackson", "2", "5:55"),
                ItemMusic("21 Questions", " James Jackson", "3", "4:54"),
                ItemMusic("Just A Lil Bit", "James Jackson", "4", "6:30"),
                ItemMusic("Many Men", "James Jackson", "5", "5:01"),
                ItemMusic("P.I.M.P", "James Jackson", "6", "8:02"),
                ItemMusic("Ayo Technology", "James Jackson", "7", "3:04"),
                ItemMusic("Window Shopper", "James Jackson", "8", "7:11"),
                ItemMusic("Hustler's Ambition", "James Jackson", "9", "6:13"),
                ItemMusic("Best Friend", "James Jackson", "10", "5:57"),
            ), this::onClick
        )
        binding.rvMusic.adapter = adapter
    }

    private fun onClick(position: Int?) {
        val intent = Intent(activity, SecondActivity::class.java)
        intent.putExtra("key", position)
        startActivity(intent)


        }

    }
