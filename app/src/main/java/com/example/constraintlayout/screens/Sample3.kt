package com.example.constraintlayout.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension

@Composable
fun Sample3(){
    val constraints= ConstraintSet {
        val greenBox=createRefFor("greenbox")
        val redBox=createRefFor("redbox")
        val guideline =createGuidelineFromTop(fraction = 0.9f)
        val startGuideLine=createGuidelineFromStart(0.7f)
        constrain(greenBox){
            width= Dimension.value(100.dp)
            height= Dimension.value(100.dp)
            top.linkTo(guideline)
            start.linkTo(parent.start)
        }
        constrain(redBox){
            width= Dimension.value(100.dp)
            height= Dimension.value(100.dp)
            start.linkTo(startGuideLine)
            top.linkTo(parent.top)
        }
//        createHorizontalChain(greenBox,redBox, chainStyle = ChainStyle.Packed)

    }

    ConstraintLayout(constraintSet = constraints, modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .background(Color.Green)
                .layoutId(layoutId = "greenbox")
        )
        Box(
            modifier = Modifier
                .background(Color.Red)
                .layoutId(layoutId = "redbox")
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview(){
    Sample3()
}