package com.example.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Button
import androidx.compose.material3.Text


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test.ui.theme.TestTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.layout.size
import androidx.compose.ui.draw.clip

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.test.screens.NewPage
import com.example.test.screens.Page3
import androidx.navigation.NavHostController
import screens.LoginPage


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "profile"
                ) {
                    composable("profile") {
                        ProfileCard(
                            name = "Aryasuta Baswara",
                            navController = navController,
                            modifier = Modifier.fillMaxSize().padding(top = 80.dp),
                        )
                    }
                    composable("newPage") {
                        NewPage(navController)
                    }
                    composable("page3") { Page3(navController) }
                    composable("loginPage") { LoginPage(navController) }
                }
            }
        }
    }
}

@Composable
fun ProfileCard(name: String, modifier: Modifier = Modifier, navController: NavHostController) {
    Card (
        modifier = modifier.padding(24.dp).fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ){
        Column (
            modifier = Modifier.padding(24.dp).fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(150.dp) // ukuran foto
                    .clip(CircleShape) // bikin lingkaran
                    .border(
                        width = 4.dp, // tebal border
                        color = Color.Black, // warna border
                        shape = CircleShape
                    )
            )

            Text(
                text = name,
                fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(24.dp)
            )

            Card(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {

                Text(
                    text = "NIM: 2702263680",
                    fontSize = 16.sp,
//                    fontWeight = FontWeight.Bold,
                    color = Color.DarkGray,
                    modifier = Modifier.padding(12.dp) // padding dalam card kecil
                )
            }

            Card(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {

                Text(
                    text = "Jurusan: Computer Science",
                    fontSize = 16.sp,
//                    fontWeight = FontWeight.Bold,
                    color = Color.DarkGray,
                    modifier = Modifier.padding(12.dp) // padding dalam card kecil
                )
            }
            Card(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Text(
                    text = "Tentang Saya",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.DarkGray,
                    modifier = Modifier.padding(start = 12.dp,
                        end = 12.dp,
                        top = 12.dp,
                        bottom = 4.dp) // padding dalam card kecil
                )

                Text(
                    text = "Mahasiswa semester 5 Binus Malang Computer Science dengan role FullStack Developer",
                    fontSize = 16.sp,
                    color = Color.DarkGray,
                    modifier = Modifier.padding(12.dp) // padding dalam card kecil
                )
            }

            Button(
                modifier = Modifier.padding(top = 24.dp),
                onClick = { navController.navigate("newPage") }
            ) {
                Text("Page 2")
            }

            Button(
                modifier = Modifier.padding(top = 12.dp),
                onClick = { navController.navigate("page3") }
            ) {
                Text("Page 3")
            }

            Button(
                modifier = Modifier.padding(top = 12.dp),
                onClick = { navController.navigate("loginPage") }
            ) {
                Text("Login")
            }
        }
    }
}