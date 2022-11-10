package com.example.xml

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.xml.databinding.FragmentFourthBinding
import com.example.xml.databinding.FragmentThirdBinding
import com.xwray.groupie.GroupieAdapter
import com.xwray.groupie.viewbinding.BindableItem

class FourthFragment: Fragment() {

    private var _binding: FragmentFourthBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    val groupieAdapter = GroupieAdapter().apply {
        spanCount = 8
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFourthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        renderScreen()
    }

    private fun renderScreen() {
        binding.recycler.apply {
            adapter = groupieAdapter
            layoutManager = GridLayoutManager(activity, 8)
        }
        groupieAdapter.update(getScreenContent())
    }

    private fun getScreenContent(): List<BindableItem<*>> {
        val itemsList = mutableListOf<BindableItem<*>>()
        repeat(1000) {
            itemsList.add(GridRecyclerElement())
        }
        return itemsList
    }

}