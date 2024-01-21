package com.essycynthia.cocktailapp.ui.presentation.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.essycynthia.cocktailapp.R
import com.essycynthia.cocktailapp.ui.presentation.Screen
import com.essycynthia.cocktailapp.ui.theme.categoriesText

@Composable
fun SplashScreen(navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF722F82)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .padding(horizontal = 97.dp)
            ) {
                Text(
                    text = "CoTail",
                    fontFamily = FontFamily(Font(R.font.lalezar)),
                    color = Color.Black,
                    fontSize = 40.sp
                )
                Image(
                    painter = painterResource(id = R.drawable.outline_wine_bar_24),
                    contentDescription = "Cotail",
                    modifier = Modifier.size(50.dp)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                // .wrapContentSize(Alignment.Center)
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color(0xFFA369C6))
                )
                Divider(
                    modifier = Modifier
                        .padding(vertical = 0.dp, horizontal = 97.dp)
                        .height(10.dp)
                        .width(180.dp)
                        .clip(RoundedCornerShape(10.dp)),
                    color = Color(0xFFA369C6)
                )
            }

            Spacer(modifier = Modifier.height(40.dp))
            Card(
                Modifier
                    .clickable {
                        navController.navigate(Screen.AuthenticationScreen.route)
                    }
                    .height(35.dp)
                    .padding(horizontal = 140.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                ),
                colors = CardDefaults.cardColors(Color(0xFFA369C6)))
            {
                Row(
                    modifier = Modifier
                        .padding(start = 4.dp)
                ) {
                    Text(
                        text = "Let's go",
                        color = Color.White,
                        fontSize = 15.sp
                    )
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = "icon",
//                        modifier = Modifier
//                            .size(40.dp),
                        tint = Color.White

                    )
                }

            }
        }

    }
//        Box(contentAlignment = Alignment.TopEnd){
//            Image(
//                painter = painterResource(id = R.drawable.candy_cane_infused_vodka),
//                contentDescription = "Cotail",
//                modifier = Modifier.size(40.dp)
//            )
//        }
}
