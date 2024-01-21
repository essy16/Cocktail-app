package com.essycynthia.cocktailapp.ui.presentation.splash

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.essycynthia.cocktailapp.MainActivity
import com.essycynthia.cocktailapp.R
import com.essycynthia.cocktailapp.ui.theme.CocktailAppTheme
import kotlinx.coroutines.delay

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContent {
            CocktailAppTheme {
                installSplashScreen()
//                Splash()
            }
        }
    }

    @Composable
    @Preview
    private fun Splash() {

        LaunchedEffect(key1 = true) {
            delay(5000)
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))

        }
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(R.drawable.shaker_neon_logo_cocktail_party_sign_vector_image_on_vectorstock),
                contentDescription = "Splash",
                contentScale = ContentScale.FillBounds,

                )
        }
    }
}
