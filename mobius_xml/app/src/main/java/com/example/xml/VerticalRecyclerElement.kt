package com.example.xml

import android.graphics.Color
import android.view.View
import com.example.xml.databinding.FragmentThirdElementBinding
import com.xwray.groupie.viewbinding.BindableItem

class VerticalRecyclerElement: BindableItem<FragmentThirdElementBinding>() {
    override fun bind(viewBinding: FragmentThirdElementBinding, position: Int) {
        viewBinding.apply {
            val color = getRandomHexColor()
            backgroundLayout.setBackgroundColor(Color.parseColor(color))
            text.text = color
        }
    }

    override fun getLayout(): Int = R.layout.fragment_third_element

    override fun initializeViewBinding(view: View): FragmentThirdElementBinding = FragmentThirdElementBinding.bind(view)

    private fun getRandomHexColor(): String {
        val colors = listOf<String>("#FF0000","#0000FF", "#FFFF00", "#00FF00")
        return colors.random()
    }
}