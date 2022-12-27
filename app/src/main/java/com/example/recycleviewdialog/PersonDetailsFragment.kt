package com.example.recycleviewdialog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.recycleviewdialog.databinding.FragmentPersonDetailsBinding


class PersonDetailsFragment() : Fragment() {
    lateinit var binding: FragmentPersonDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPersonDetailsBinding.inflate(inflater, container, false)
        init()
        return binding.root
    }

    private fun init() {

    }
}