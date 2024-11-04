package com.example.yina.view.onboarding

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import com.example.yina.routing.Screen

@Composable
fun OnboardingScreen(navController: NavHostController) {
    val gradient = Brush.radialGradient(
        colors = listOf(
            Color(0xFF5A04EF),
            Color(0xFF2A00FE),
            Color(0xFF311B92)
        ),

        )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                gradient
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        AsyncImage(
            model = "https://static.tildacdn.com/tild3035-6334-4433-b337-303034376266/stilisti_v_moskve.jpg",
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(
                    0.5f
                ),
            contentScale = ContentScale.FillBounds
        )
        Column(

            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.weight(0.3f))
            Text(
                text = "FLASH.CO",
                style = TextStyle(
                    fontSize = 60.sp,
                    fontWeight = FontWeight.W500,
                    color = Color.White,
                ),
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.weight(0.3f))
            Text(
                text = "SUPERCHARGE \nYOUR \nSHOPPING",
                style = TextStyle(
                    fontSize = 30.sp,
                    fontWeight = FontWeight.W500,
                    color = Color.White,
                    lineHeight = 50.sp
                ),
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = {
                    navController.navigate(Screen.Home.route)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFFFFFF),
                    contentColor = Color.Blue
                ),
                border = BorderStroke(
                    1.5.dp,
                    Color.Gray
                )
            ) {
                Text(
                    text = "Next",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W400,
                        color = Color.Black,
                    ),
                    modifier = Modifier.padding(
                        vertical = 16.dp
                    )
                )
            }
            Spacer(modifier = Modifier.weight(0.05f))
        }
    }
}