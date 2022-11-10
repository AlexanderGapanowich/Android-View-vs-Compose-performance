package com.example.xml

import android.graphics.Color
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import com.example.xml.databinding.FragmentFourthElementBinding
import com.example.xml.databinding.FragmentThirdElementBinding
import com.xwray.groupie.viewbinding.BindableItem

class GridRecyclerElement: BindableItem<FragmentFourthElementBinding>() {
    override fun bind(viewBinding: FragmentFourthElementBinding, position: Int) {
        viewBinding.star.setColorFilter(Color.parseColor(getRandomHexColor()))
        val alphaAnimation = AlphaAnimation(0f,1f)
        alphaAnimation.duration = 1000
        alphaAnimation.repeatCount = Animation.INFINITE
        alphaAnimation.repeatMode = Animation.REVERSE
        viewBinding.star.animation = alphaAnimation
        alphaAnimation.start()
    }

    override fun getLayout(): Int  = R.layout.fragment_fourth_element

    override fun initializeViewBinding(view: View): FragmentFourthElementBinding = FragmentFourthElementBinding.bind(view)

    private fun getRandomHexColor(): String {
        val colors = listOf<String>("#FF0000","#0000FF", "#FFFF00", "#00FF00")
        return colors.random()
    }
}