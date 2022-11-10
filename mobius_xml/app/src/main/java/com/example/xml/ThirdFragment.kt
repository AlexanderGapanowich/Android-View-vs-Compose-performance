package com.example.xml

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.xml.databinding.FragmentSecondBinding
import com.example.xml.databinding.FragmentThirdBinding
import com.xwray.groupie.GroupieAdapter
import com.xwray.groupie.viewbinding.BindableItem

class ThirdFragment: Fragment() {

    private var _binding: FragmentThirdBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    val groupieAdapter = GroupieAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        renderScreen()
    }

    private fun renderScreen() {
        binding.recycler.apply {
            adapter = groupieAdapter
        }
        groupieAdapter.update(getScreenContent())
    }

    private fun getScreenContent(): List<BindableItem<*>> {
        val itemsList = mutableListOf<BindableItem<*>>()
        repeat(500) {
            itemsList.add(VerticalRecyclerElement())
        }
        return itemsList
    }

}