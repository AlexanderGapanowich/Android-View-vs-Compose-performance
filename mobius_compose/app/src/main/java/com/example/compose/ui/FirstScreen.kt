package com.example.compose.ui

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.compose.R

@Composable
fun FirstScreen() {
    ConstraintLayout {
        val (text, image, button) = createRefs()
        Text(text = "Performance test", modifier = Modifier.constrainAs(text) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(image.top)
        }
        )
        Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = null, modifier = Modifier.constrainAs(image){
            top.linkTo(text.bottom)
            bottom.linkTo(button.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })
        
        TextButton(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(backgroundColor = Color.Yellow), modifier = Modifier.constrainAs(button){
            top.linkTo(image.bottom)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }) {
            Text(text = "Next")
        }
    }
}