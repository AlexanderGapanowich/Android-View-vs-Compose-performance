package com.example.xml

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.window.layout.WindowMetricsCalculator
import com.example.xml.databinding.FragmentSecondBinding
import kotlin.random.Random

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addMovingCircles()

    }

    private fun addMovingCircles() {
        val windowMetrics = WindowMetricsCalculator.getOrCreate().computeCurrentWindowMetrics(activity!!)
        val width = windowMetrics.bounds.width()
        val height = windowMetrics.bounds.height()
        repeat(1000) {
            val newImage = ImageView(context)
            newImage.apply {
                layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT)
                setImageResource(R.drawable.blue_circle)
            }
            binding.root.addView(newImage)
            val coordintes = getRandomCoordinates(width, height)
            newImage
                .animate()
                .x(coordintes.first.toFloat())
                .y(coordintes.second.toFloat())
                .setDuration(2000)
                .start()
        }
    }

    fun getRandomCoordinates(width:Int, height: Int): Pair<Int, Int> {
        return Pair(Random.nextInt(width), Random.nextInt(height))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}