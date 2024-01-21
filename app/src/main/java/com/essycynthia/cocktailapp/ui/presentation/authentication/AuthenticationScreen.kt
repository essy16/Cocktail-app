package com.essycynthia.cocktailapp.ui.presentation.authentication

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.essycynthia.cocktailapp.R
import com.essycynthia.cocktailapp.ui.presentation.Screen
import com.essycynthia.cocktailapp.ui.theme.categoriesText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import java.nio.file.WatchEvent

@Composable
//@Preview
fun AuthenticationScreen(navController: NavController) {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy((-5).dp),
    ) {
        MyCanvas()
        LoginRegistrationScreen(navController)


    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginRegistrationScreen(navController: NavController) {
    val auth: FirebaseAuth = FirebaseAuth.getInstance()
    var signUpUsername by remember { mutableStateOf(("")) }
    var signUpPassword by remember { mutableStateOf(("")) }
    var logInUsername by remember { mutableStateOf(("")) }
    var logInPassword by remember { mutableStateOf(("")) }
    var confirmPassword by remember { mutableStateOf(("")) }
    var passwordVisible by remember { mutableStateOf(false) }
    val context = LocalContext.current
    var isLoading by remember { mutableStateOf(false) }

    var isSignUpClicked by remember {
        mutableStateOf(false)
    }
    var isLogInClicked by remember {
        mutableStateOf(true)
    }

    Card(
        modifier = Modifier
            .width(380.dp)
            .height(460.dp)
            .padding(start = 40.dp, top = 60.dp, end = 40.dp),
        colors = CardDefaults.cardColors(Color(0xFFFCEFFD)),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ) {

        Spacer(modifier = Modifier.height(20.dp))

        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .clip(RoundedCornerShape(10.dp)),
            colors = CardDefaults.cardColors(Color.White),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 20.dp
            )
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                AuthenticationButton(
                    modifier = Modifier.width(50.dp),
                    defaultColor = Color.White,
                    selectedColor = Color(0xFFA369C6),
                    symbol = stringResource(id = R.string.log_in),
                    onClick = {
                        isLogInClicked = true
                        isSignUpClicked = false
                    },
                    isSelected = isLogInClicked,
                    shape = RoundedCornerShape(40.dp)
                )

                AuthenticationButton(
                    modifier = Modifier.width(50.dp),
                    defaultColor = Color.White,
                    selectedColor = Color(0xFFA369C6),
                    symbol = stringResource(id = R.string.sign_up),
                    onClick = {
                        isSignUpClicked = true
                        isLogInClicked = false
                    },
                    isSelected = isSignUpClicked,
                    shape = RoundedCornerShape(40.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Column(
            Modifier.fillMaxHeight()
        ) {
            if (isLogInClicked) {
                OutlinedTextField(
                    value = logInUsername,
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = "emailIcon"
                        )
                    },
                    onValueChange = {
                        logInUsername = it
                    },
                    label = {
                        Text(
                            text = "Email address", fontFamily = FontFamily(Font(R.font.carme)),
                            fontSize = 15.sp
                        )
                    },
                    placeholder = {
                        Text(
                            text = "Enter your e-mail", fontFamily = FontFamily(Font(R.font.carme)),
                            fontSize = 15.sp
                        )
                    },
                )
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    value = logInPassword,
                    trailingIcon = {
                        Box(
                            modifier = Modifier.clickable {
                                passwordVisible = !passwordVisible

                            }
                        ) {
                            if (passwordVisible) {
                                Icon(
                                    imageVector = Icons.Outlined.VisibilityOff,
                                    contentDescription = "visibilityIcon"
                                )
                            } else {
                                Icon(
                                    imageVector = Icons.Outlined.Visibility,
                                    contentDescription = "visibilityIcon"
                                )
                            }
                        }
                    },
                    onValueChange = {
                        logInPassword = it
                    },
                    label = {
                        Text(
                            text = "Password", fontFamily = FontFamily(Font(R.font.carme)),
                            fontSize = 15.sp
                        )
                    },
                    placeholder = {
                        Text(
                            text = "Enter your password",
                            fontFamily = FontFamily(Font(R.font.carme)),
                            fontSize = 15.sp
                        )
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done
                    ),
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation()
                )
                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = stringResource(id = R.string.forgot_password),
                    fontFamily = FontFamily(Font(R.font.carme)),
                    fontSize = 13.sp,
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 8.dp)
                )

                Spacer(modifier = Modifier.height(30.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.CenterHorizontally)
                ) {
                    Button(
                        onClick = {
                            if (logInUsername.isEmpty()) {
                                Toast.makeText(
                                    context,
                                    "Please enter your email",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else if (
                                logInPassword.isEmpty()) {
                                Toast.makeText(
                                    context,
                                    "Please enter your password",
                                    Toast.LENGTH_SHORT
                                ).show()

                            } else {
                                isLoading = true
                                auth.signInWithEmailAndPassword(logInUsername, logInPassword)
                                    .addOnCompleteListener { task ->
                                        if (task.isSuccessful) {
                                            // Login successful
                                            navController.navigate(Screen.HomeScreen.route)
                                            isLoading = false


                                        } else {
                                            try {
                                                throw task.getException()!!
                                            } catch (e: FirebaseAuthUserCollisionException) {
                                                Toast.makeText(
                                                    context,
                                                    "Email already taken!",
                                                    Toast.LENGTH_SHORT
                                                ).show()
                                            } catch (e: FirebaseAuthWeakPasswordException) {
                                                Toast.makeText(
                                                    context,
                                                    "Your password is not strong enough!",
                                                    Toast.LENGTH_SHORT
                                                ).show()
                                            } catch (e: FirebaseAuthInvalidCredentialsException) {
                                                Toast.makeText(
                                                    context,
                                                    "Your email address or password is incorrect",
                                                    Toast.LENGTH_SHORT
                                                ).show()
                                            }

                                            isLoading = false
                                        }
                                    }
                            }

                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFA369C6)),
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        Text(text = stringResource(id = R.string.log_in), color = Color.White)
                    }
                }
                // Loading indicator
                if (isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .padding(horizontal = 70.dp, vertical = 10.dp),
                        color = Color(0xFFA369C6)


                    )
                }
            } else {
                OutlinedTextField(
                    value = signUpUsername,
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = "emailIcon"
                        )
                    },
                    onValueChange = {
                        signUpUsername = it
                    },
                    label = {
                        Text(
                            text = "Email address", fontFamily = FontFamily(Font(R.font.carme)),
                            fontSize = 15.sp
                        )
                    },
                    placeholder = {
                        Text(
                            text = "Enter your e-mail", fontFamily = FontFamily(Font(R.font.carme)),
                            fontSize = 15.sp
                        )
                    },
                )
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    value = signUpPassword,
                    trailingIcon = {
                        Box(
                            modifier = Modifier.clickable {
                                passwordVisible = !passwordVisible

                            }
                        ) {
                            if (passwordVisible) {
                                Icon(
                                    imageVector = Icons.Outlined.VisibilityOff,
                                    contentDescription = "visibilityIcon"
                                )
                            } else {
                                Icon(
                                    imageVector = Icons.Outlined.Visibility,
                                    contentDescription = "visibilityIcon"
                                )
                            }
                        }
                    },
                    onValueChange = {
                        signUpPassword = it
                    },
                    label = {
                        Text(
                            text = "Password", fontFamily = FontFamily(Font(R.font.carme)),
                            fontSize = 15.sp,
                            textAlign = TextAlign.End
                        )
                    },
                    placeholder = {
                        Text(
                            text = "Enter your password",
                            fontFamily = FontFamily(Font(R.font.carme)),
                            fontSize = 15.sp
                        )
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done
                    ),
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation()
                )
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    value = confirmPassword,
                    trailingIcon = {
                        Box(
                            modifier = Modifier.clickable {
                                passwordVisible = !passwordVisible

                            }
                        ) {
                            if (passwordVisible) {
                                Icon(
                                    imageVector = Icons.Outlined.VisibilityOff,
                                    contentDescription = "visibilityIcon"
                                )
                            } else {
                                Icon(
                                    imageVector = Icons.Outlined.Visibility,
                                    contentDescription = "visibilityIcon"
                                )
                            }
                        }
                    },
                    onValueChange = {
                        confirmPassword = it
                    },
                    label = {
                        Text(
                            text = "Confirm Password", fontFamily = FontFamily(Font(R.font.carme)),
                            fontSize = 15.sp
                        )
                    },
                    placeholder = {
                        Text(
                            text = "Confirm your password",
                            fontFamily = FontFamily(Font(R.font.carme)),
                            fontSize = 15.sp
                        )
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done
                    ),
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation()
                )
                Spacer(modifier = Modifier.height(20.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.CenterHorizontally)
                ) {
                    Button(
                        onClick = {
                            if (signUpPassword.isEmpty()) {
                                Toast.makeText(
                                    context,
                                    "Please enter your password",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else if (signUpUsername.isEmpty()) {
                                Toast.makeText(
                                    context,
                                    "Please enter your email",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else if (confirmPassword.isEmpty()) {
                                Toast.makeText(
                                    context,
                                    "Please confirm your password",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else if (signUpPassword != confirmPassword) {
                                Toast.makeText(
                                    context,
                                    "The passwords do not match",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else {
                                isLoading = true

                                auth.createUserWithEmailAndPassword(signUpUsername, signUpPassword)
                                    .addOnCompleteListener { task ->
                                        if (task.isSuccessful) {
                                            // Registration successful
                                            isLoading = false
                                            val user = auth.currentUser
                                            navController.navigate(Screen.HomeScreen.route)
                                        } else {
                                            try {
                                                throw task.getException()!!
                                            } catch (e: FirebaseAuthUserCollisionException) {
                                                Toast.makeText(
                                                    context,
                                                    "Email already taken!",
                                                    Toast.LENGTH_SHORT
                                                ).show()
                                            } catch (e: FirebaseAuthWeakPasswordException) {
                                                Toast.makeText(
                                                    context,
                                                    "Your password is not strong enough!",
                                                    Toast.LENGTH_SHORT
                                                ).show()
                                            } catch (e: FirebaseAuthInvalidCredentialsException) {
                                                Toast.makeText(
                                                    context,
                                                    "Your email address or password is incorrect",
                                                    Toast.LENGTH_SHORT
                                                ).show()
                                            }


                                        }
                                        isLoading = false
                                    }


                            }
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFA369C6)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = stringResource(id = R.string.sign_up), color = Color.White)
                    }
                }

            }
        }
        if (isLoading) {
            CircularProgressIndicator()
        } else {
            // Hide loading indicator
            // Dismiss the Dialog or update UI accordingly
        }
    }

}


@Composable
fun AuthenticationButton(
    modifier: Modifier,
    defaultColor: Color,
    selectedColor: Color,
    symbol: String,
    onClick: () -> Unit,
    isSelected: Boolean,
    shape: Shape

) {
    val backgroundColor = if (isSelected) selectedColor else defaultColor
    val textColor = if (isSelected) Color.White else categoriesText

    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .width(140.dp)
            .height(40.dp)
            .clickable { onClick() }
            .background(color = backgroundColor, shape = shape)
            .then(modifier)) {


        Text(
            text = symbol,
            fontFamily = FontFamily(Font(R.font.carme)),
            fontSize = 25.sp,
            color = textColor,
        )
    }


}


@Composable
fun MyCanvas() {
    val cocktail = ImageBitmap.imageResource(id = R.drawable.octopus_shaped_cocktail_glasses)
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {

        drawCircle(
            brush = Brush.horizontalGradient(
                colors = listOf(
                    Color(0xFF591781), Color(0xFFF9D6FF)
                )
            ), radius = 250.dp.toPx(), style = Fill, alpha = 0.9f
        )

        // Draw the inner circle
        drawCircle(
            Color(0xFFF9D6FF),
            radius = 150.dp.toPx(),
            center = center,
            style = Fill,
            alpha = 0.5f

        )
        drawCircle(
            Color.Black, radius = 100.dp.toPx(), center = center, style = Fill
        )
        drawImage(
            image = cocktail,
            alpha = 1f,
            dstSize = IntSize(width = 340, height = 360),
            dstOffset = IntOffset(x = 370, y = 120)
        )

    }
}

@Composable
fun ShowToast(message: String) {
    val context = LocalContext.current
    DisposableEffect(context) {
        val toast = Toast.makeText(context, message, Toast.LENGTH_SHORT)
        toast.show()

        // Dispose of the Toast when the Composable is disposed
        onDispose {
            toast.cancel()
        }
    }
}




