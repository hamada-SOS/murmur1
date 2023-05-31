package com.example.murmur1.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.murmur1.R
import com.example.murmur1.adapter.ViewPagerAdapter
import com.example.murmur1.databinding.FragmentCalenderviewerBinding

class calenderviewer : Fragment() {

    private lateinit var binding: FragmentCalenderviewerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCalenderviewerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val images = listOf<Int>(
            R.drawable.imogen_poots,
            R.drawable.kim_min_hee,
            R.drawable.imogen_poots,
            R.drawable.kim_min_hee,
        )
        val adapter = ViewPagerAdapter(images)
        binding.viewPager2.adapter = adapter
        binding.viewPager2.orientation = ViewPager2.ORIENTATION_VERTICAL



    }
}
