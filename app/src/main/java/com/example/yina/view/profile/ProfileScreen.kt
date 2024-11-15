package com.example.yina.view.profile

import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable

fun ProfileScreen(
    navController: NavController
) {
    val launcher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.RequestPermission()) { isGranted ->
            println(isGranted)
        }
    Column(
        modifier = Modifier.background(
            Color.Gray.copy(0.4f)
        )
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            IconButton(
                onClick = {
//                    navController.navigate(Screen.Home.route)
                    launcher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
                }, modifier = Modifier.background(
                    Color.White, CircleShape
                )
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                )
            }
            Spacer(modifier = Modifier.weight(0.5f))
            Text(
                text = "Profile", style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W400,
                )
            )
            Spacer(modifier = Modifier.weight(0.5f))

        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Color.Gray.copy(0.01f)
                )
        ) {
            item {
                Box(modifier = Modifier.height(16.dp))
                PhoneCard()
                Box(
                    modifier = Modifier.padding(
                        start = 8.dp, end = 8.dp
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .clip(
                                RoundedCornerShape(16.dp)
                            )
                            .fillMaxWidth()
                            .background(
                                Color.White,
                            )
                            .padding(
                                16.dp
                            )


                    ) {
                        for (item in 1..3) {
                            ProfilePersonalInfoCard()
                        }
                    }
                }

            }
        }
    }
}


@Composable
@Preview
fun ProfilePersonalInfoCard() {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(Icons.Default.Person, contentDescription = null)
            Box(
                modifier = Modifier.width(8.dp)
            ) {

            }
            Text(text = "Personal information")
            Spacer(
                modifier = Modifier.weight(1f)
            )
            Icon(Icons.Default.ArrowForward, contentDescription = null)
        }
    }
}

@Composable
fun PhoneCard() {
    Column(
        modifier = Modifier.padding(
            start = 8.dp, end = 8.dp, bottom = 16.dp
        )
    ) {
        Box(
            modifier = Modifier
                .clip(
                    RoundedCornerShape(16.dp)
                )
                .fillMaxWidth()
                .background(
                    Color.White,
                )
                .padding(
                    16.dp
                )

        ) {
            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start
            ) {
                CircularAvtar()
                Column(
                    modifier = Modifier.padding(
                        start = 8.dp
                    )
                ) {
                    Text(
                        text = "sabir@flash.co", style = TextStyle(
                            fontSize = 22.sp, fontWeight = FontWeight.W700
                        ), modifier = Modifier.padding(
                            bottom = 8.dp
                        )
                    )
                    Text(
                        text = "+91 8631247589", style = TextStyle(
                            fontSize = 16.sp, fontWeight = FontWeight.W400
                        )
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Icon(Icons.Default.Create, contentDescription = "Copy")
            }
        }
    }
}

@Composable
fun CircularAvtar() {
    Card(
        modifier = Modifier.size(64.dp),
        shape = CircleShape,
    ) {
        Box(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = "A", textAlign = TextAlign.Center
            )
        }
    }
}