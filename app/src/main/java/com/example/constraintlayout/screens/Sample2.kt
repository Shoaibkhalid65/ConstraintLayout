package com.example.constraintlayout.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.constraintlayout.R

@Composable
fun Sample2(){
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (image,username,password,login,cancel)=createRefs()
        Image(
            painter = painterResource(R.drawable.compose),
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)
                .constrainAs(ref = image){
                    top.linkTo(parent.top, margin = 100.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)

                }
                .drawBehind {
                    drawIntoCanvas {
                        val paint = Paint().asFrameworkPaint().apply {
                            isAntiAlias = true
                            color = android.graphics.Color.WHITE
                            setShadowLayer(90f, 0f, 0f, android.graphics.Color.YELLOW) // Colored shadow
                        }
                        it.nativeCanvas.drawRoundRect(0f, 0f, size.width, size.height, 20f, 20f, paint)
                    }
                }


        )
        var userName by remember { mutableStateOf("") }
        var passWord by remember { mutableStateOf("") }
        TextField(
            value = userName,
            onValueChange = {userName=it},
            label = {
                Text(
                    text = "Enter the username"
                )
            },
            modifier = Modifier
                .constrainAs(ref = username){
                top.linkTo(image.bottom, margin = 50.dp)
                start.linkTo(image.start)
                end.linkTo(image.end)
                }
                .drawBehind{
                    drawIntoCanvas {canvas ->
                        val paint= Paint().asFrameworkPaint()
                        paint.isAntiAlias=true
                        paint.color= android.graphics.Color.RED
                        paint.setShadowLayer(30f,0f,0f,android.graphics.Color.GREEN)
                        canvas.nativeCanvas.drawRoundRect(0f,0f,size.width,size.height,20f,20f,paint)
                    }
                }

        )
        TextField(
            value = passWord,
            onValueChange = {passWord=it},
            label = {
                Text(
                    text = "Enter the password"
                )
            },
            visualTransformation = PasswordVisualTransformation(mask = '\u2191'),
            modifier = Modifier.constrainAs(ref = password){
                top.linkTo(username.bottom, margin = 20.dp)
                start.linkTo(username.start)
                end.linkTo(username.end)
            },
        )
        Button(
            onClick = {},
            modifier = Modifier
                .constrainAs(ref = cancel){
                top.linkTo(password.bottom, margin = 40.dp)
                start.linkTo(password.start)
                end.linkTo(login.start)
                }

        ) {
            Text(
                text = "Cancel"
            )
        }
        Button(
            onClick = {},
            modifier = Modifier.constrainAs(ref = login){
                top.linkTo(password.bottom, margin = 40.dp)
                start.linkTo(cancel.end)
                end.linkTo(password.end)
            }
        ) {
            Text(
                text = "Login"
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun Sample2Preview(){
    Sample2()
}