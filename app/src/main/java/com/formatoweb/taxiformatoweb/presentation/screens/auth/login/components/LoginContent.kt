package com.formatoweb.taxiformatoweb.presentation.screens.auth.login.components

import android.R.attr.tag
import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.formatoweb.taxiformatoweb.R
import com.formatoweb.taxiformatoweb.presentation.components.DefaultButton
import com.formatoweb.taxiformatoweb.presentation.components.DefaultTextField
import com.formatoweb.taxiformatoweb.presentation.navigation.graph.screen.auth.AuthScreen
import com.formatoweb.taxiformatoweb.presentation.screens.auth.login.LoginViewModel


@Composable
fun LoginContent (navHostController: NavHostController, paddingValues: PaddingValues, viewModel: LoginViewModel = hiltViewModel()){

    val state = viewModel.state
    val context = LocalContext.current

    LaunchedEffect(key1 = viewModel.errorMessage) {
        if (viewModel.errorMessage.isNotEmpty()){
            Toast.makeText(context, viewModel.errorMessage, Toast.LENGTH_LONG).show()
        }
    }

    var email by remember {
        mutableStateOf(value = "")
    }
    var password by remember {
        mutableStateOf(value = "")
    }
    Box(modifier = Modifier
        .fillMaxSize()
        .background(brush = Brush.linearGradient(
            colors = listOf(Color(0xFFFF0000), Color(0xFF5B0707))
        )
        )
        .padding(paddingValues)
    ){
        Column (
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ){
            Text(text = "Login",
                color = Color.White,
                fontSize = 27.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.rotate(90f).padding(top = 10.dp)
            )
            Spacer(modifier = Modifier.height(100.dp))
            Text(text = "Register",
                color = Color.White,
                fontSize = 27.sp,
                modifier = Modifier
                    .clickable{navHostController.navigate(route = AuthScreen.Register.route)}
                    .rotate(90f)
                    .padding(top = 50.dp)
            )
            Spacer(modifier = Modifier.height(250.dp))
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 60.dp, bottom = 35.dp)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xFFE1C0C0), Color(0xFFE16565))
                    ),
                    shape = RoundedCornerShape(
                        topStart = 35.dp,
                        bottomStart = 35.dp
                    )
                )
        ){
            Column (modifier = Modifier
                .statusBarsPadding()
                .padding(start = 25.dp)){
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Bienvenido",
                    color = Color.White,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,

                    )
                Text(
                    text = "de nuevo...",
                    color = Color.White,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
                Box(modifier = Modifier.fillMaxWidth().padding(end = 25.dp)){
                    Image(
                        modifier = Modifier
                            .size(180.dp)
                            .align(Alignment.CenterEnd),
                        painter = painterResource(id = R.drawable.car_white),
                        contentDescription = ""
                    )
                }
                Text(
                    text = "Regresar...",
                    color = Color.White,
                    fontSize = 27.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(50.dp))
                DefaultTextField(
                    modifier = Modifier,
                    value = state.email,
                    label = "E-mail",
                    icon = Icons.Outlined.Email,
                    onValueChange = { it ->
                        viewModel.onEmailInput(it)
                    },
                    keyboardType = KeyboardType.Email
                )
                Spacer(modifier = Modifier.height(20.dp))
                DefaultTextField(
                    modifier = Modifier,
                    value = state.password,
                    label = "Contraseña",
                    icon = Icons.Outlined.Lock,
                    onValueChange = { it
                        viewModel.onPasswordInput(it)
                    },
                    hideText = true
                )
                Spacer(modifier = Modifier.weight(1f))
                DefaultButton(
                    modifier = Modifier,
                    text = "LOGIN",
                    onClick = {
                        viewModel.login()
                    }
                )
                Spacer(modifier = Modifier.height(25.dp))
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically

                ){
                    Spacer(
                        modifier = Modifier
                            .width(30.dp)
                            .height(1.dp)
                            .background(Color.Black)
                    )
                    Text(
                        modifier = Modifier.padding(horizontal = 7.dp),
                        text = "O",
                        color = Color.Black,
                        fontSize = 20.sp
                    )
                    Spacer(
                        modifier = Modifier
                            .width(30.dp)
                            .height(1.dp)
                            .background(Color.Black)
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ){
                    Text(
                        text = "No tienes cuenta",
                        color = Color.White,
                        fontSize = 17.sp
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        modifier = Modifier.clickable(){
                            navHostController.navigate(route = AuthScreen.Register.route)
                        },
                        text = "Registrate",
                        color = Color.White,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.height(60.dp))
            }
        }
    }
}