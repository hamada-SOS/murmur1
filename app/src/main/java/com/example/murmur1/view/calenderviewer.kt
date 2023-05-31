package com.example.murmur1.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.murmur1.R
import com.example.murmur1.adapter.ViewPagerAdapter
import com.example.murmur1.databinding.FragmentCalenderviewerBinding
import com.kizitonwose.calendar.core.CalendarDay
import com.kizitonwose.calendar.core.firstDayOfWeekFromLocale
import com.kizitonwose.calendar.view.MonthDayBinder
import com.kizitonwose.calendar.view.ViewContainer
import java.time.YearMonth

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
//        val images = listOf<Int>(
//            R.drawable.imogen_poots,
//            R.drawable.kim_min_hee,
//            R.drawable.imogen_poots,
//            R.drawable.kim_min_hee,
//        )
//        val adapter = ViewPagerAdapter(images)
//        binding.viewPager2.adapter = adapter
//        binding.viewPager2.orientation = ViewPager2.ORIENTATION_VERTICAL

        // With ViewBinding
        // val textView = CalendarDayLayoutBinding.bind(view).calendarDayText


        val currentMonth = YearMonth.now()
        val startMonth = currentMonth.minusMonths(100)  // Adjust as needed
        val endMonth = currentMonth.plusMonths(100)  // Adjust as needed
        val firstDayOfWeek = firstDayOfWeekFromLocale() // Available from the library
        binding.calenderviewer.setup(startMonth, endMonth, firstDayOfWeek)
        binding.calenderviewer.scrollToMonth(currentMonth)
        binding.calenderviewer.dayBinder = object : MonthDayBinder<DayViewContainer> {
            // Called only when a new container is needed.
            override fun create(view: View) = DayViewContainer(view)

            // Called every time we need to reuse a container.
            override fun bind(container: DayViewContainer, data: CalendarDay) {
                container.textView.text = data.date.dayOfMonth.toString()
            }
        }

    }


    class DayViewContainer(view: View) : ViewContainer(view) {
        val textView = view.findViewById<TextView>(R.id.calendarDayText)
    }
}