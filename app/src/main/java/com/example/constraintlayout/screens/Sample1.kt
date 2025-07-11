package com.example.constraintlayout.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun Sample1(){
    ConstraintLayout {
        val (box,text) = createRefs()
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(color = Color.Red)
                .constrainAs(box){
                    top.linkTo(parent.top)
                }
        )
        Text(
            text="This is text",
            modifier = Modifier.constrainAs(text){
                start.linkTo(box.end, margin = 30.dp)
                top.linkTo(parent.top, margin = 20.dp)
            }
        )

    }
}

@Preview
@Composable
fun PreviewSample1(){
    Sample1()
}