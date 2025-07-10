package com.example.constraintlayout.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.layout
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.example.constraintlayout.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Sample4(){
    Scaffold (
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBackIosNew,
                            contentDescription = null
                        )
                    }
                }
            )
        }
    ){innerPadding->
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 20.dp, vertical = 10.dp)

        ) {
             val (
                 title,subtitle,name,email,password,checkbox,checkboxText,button,
                 divider1,dividerText,divider2,apple,google,facebook,bottomText
             )=createRefs()
            Text(
                text = "Create an account",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .constrainAs(title){
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    }
            )
            Text(
                text = "Welcome! Please enter your details.",
                fontSize = 17.sp,
                modifier = Modifier
                    .constrainAs(subtitle){
                        top.linkTo(title.bottom,10.dp)

                    }
            )
            CustomTextField(
                title="Name",
                label = "Enter your name",
                leadingIcon = Icons.Outlined.Person,
                modifier = Modifier.constrainAs(name){
                    top.linkTo(subtitle.bottom,20.dp)
                }
            )
            CustomTextField(
                title="Email",
                label = "Enter your email",
                leadingIcon = Icons.Outlined.Email,
                modifier = Modifier.constrainAs(email){
                    top.linkTo(name.bottom,20.dp)
                }
            )
            CustomTextField(
                title="Password",
                label = "Enter your password",
                leadingIcon = Icons.Outlined.Lock,
                modifier = Modifier.constrainAs(password){
                    top.linkTo(email.bottom,20.dp)
                }
            )
            var checked by remember { mutableStateOf(true) }
            Checkbox(
               checked =checked,
                onCheckedChange = {
                    checked=it
                },
                modifier = Modifier.constrainAs(checkbox){
                    top.linkTo(password.bottom)
                }
            )
            Text(
                text = "Must be at least 8 characters",
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(top = 13.dp)
                    .constrainAs(checkboxText){
                    start.linkTo(checkbox.end)
                    top.linkTo(password.bottom)

                }
            )
            Button(
                onClick = {},
                modifier = Modifier
                    .height(55.dp)
                    .fillMaxWidth()
                    .constrainAs(button){
                        top.linkTo(checkbox.bottom,25.dp)
                    },
                shape = RoundedCornerShape(16.dp)

            ) {
                 Text(
                     text = "Sign Up",
                     color = Color.White,
                     fontSize = 18.sp,
                     fontWeight = FontWeight.SemiBold
                 )
            }
            HorizontalDivider(
                modifier = Modifier
                    .width(120.dp)
                    .constrainAs(divider1){
                        top.linkTo(button.bottom,20.dp)
                    },
                color = Color.Gray,
                thickness = 2.dp
            )
            Text(
                text = "Or sign up with",
                modifier = Modifier.constrainAs(dividerText){
                    start.linkTo(divider1.end,10.dp)
                    top.linkTo(button.bottom,10.dp)
                }
            )
            HorizontalDivider(
                modifier = Modifier
                    .width(120.dp)
                    .constrainAs(divider2){
                        top.linkTo(button.bottom,20.dp)
                        start.linkTo(dividerText.end,10.dp)
                    },
                color = Color.Gray,
                thickness = 2.dp
            )
            CustomCard(
                modifier = Modifier.constrainAs(apple){
                    top.linkTo(divider1.bottom,30.dp)
                    start.linkTo(parent.start,90.dp)
                },
                imageId = R.drawable.apple
            )
            CustomCard(
                modifier = Modifier.constrainAs(google){
                    top.linkTo(divider1.bottom,30.dp)
                    start.linkTo(apple.end,10.dp)
                },
                imageId = R.drawable.search
            )
            CustomCard(
                modifier = Modifier.constrainAs(facebook){
                    top.linkTo(divider1.bottom,30.dp)
                    start.linkTo(google.end,10.dp)
                },
                imageId = R.drawable.facebook
            )
            Text(
                text = buildAnnotatedString {
                   withStyle(style = SpanStyle()){
                       append("already have an account? ")
                   }
                    withStyle(style = SpanStyle(color = Color.Blue, fontWeight = FontWeight.SemiBold)){
                        append("Log in")
                    }
                },
                modifier = Modifier
                    .constrainAs(bottomText){
                    top.linkTo(apple.bottom,140.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            )








        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSample4(){
   Sample4()
}

@Composable
fun CustomTextField(title: String,label: String,leadingIcon: ImageVector,modifier: Modifier= Modifier){
     Column (
         modifier = modifier
     ){
         Text(
             text = title,
             fontWeight = FontWeight.SemiBold,
             fontSize = 16.sp,
             color = Color.Black
         )
         var value by remember { mutableStateOf("") }
         OutlinedTextField(
             value =value,
             onValueChange = {
                 value=it
             },
             label = {
                 Text(
                     text = label
                 )
             },
             modifier = Modifier
                 .fillMaxWidth()
             ,
             leadingIcon = {
                 Icon(
                     imageVector = leadingIcon,
                     contentDescription = null
                 )
             },
             trailingIcon = {
                 if(title=="Password"){
                     Icon(
                         painter = painterResource(R.drawable.eye_crossed),
                         contentDescription = null,
                         modifier = Modifier.size(24.dp)
                     )
                 }
             },
             shape = RoundedCornerShape(12.dp),
         )
     }
}

@Composable
fun CustomCard(modifier: Modifier= Modifier,imageId:Int){
    Card (
        modifier=modifier
            .size(50.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 16.dp
        )
    ){
        Image(
            painter = painterResource(imageId),
            contentDescription = null,
            modifier= Modifier
                .padding(top = 12.dp)
                .size(24.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
}