package com.formatoweb.taxiformatoweb.presentation.screens.auth.register.components

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
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Phone
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
import androidx.navigation.NavHostController
import com.formatoweb.taxiformatoweb.R
import com.formatoweb.taxiformatoweb.presentation.components.DefaultButton
import com.formatoweb.taxiformatoweb.presentation.components.DefaultOutlinedTextField
import com.formatoweb.taxiformatoweb.presentation.screens.auth.register.RegisterViewModel

@Composable
fun RegisterComponent(navHostController: NavHostController, paddingValues: PaddingValues, viewModel: RegisterViewModel = hiltViewModel()) {
    val state = viewModel.state
    val context = LocalContext.current

    LaunchedEffect(key1 = viewModel.errorMessage) {
        if (viewModel.errorMessage.isNotEmpty()){
            Toast.makeText(context, viewModel.errorMessage, Toast.LENGTH_SHORT).show()
        }
    }

    Box(modifier = Modifier
        .fillMaxWidth()
        .background(
            brush = Brush.linearGradient(
                colors = listOf(Color(0xFFE1C0C0), Color(0xFFE16565))
            )
        )
        .padding(paddingValues)
    ){
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ){
            Text(
                text = "Login",
                color = Color.Black,
                fontSize = 27.sp,
                modifier = Modifier
                    .rotate(90f)
                    .padding(top = 15.dp)
                    .clickable { navHostController.popBackStack() }
            )
            Spacer(modifier = Modifier.height(150.dp))
            Text(
                text = "Registro",
                color = Color.Black,
                fontSize = 33.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .rotate(90f)
                    .padding(top = 70.dp)
            )
            Spacer(modifier = Modifier.height(250.dp))
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 70.dp, bottom = 35.dp)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xFFE1C0C0), Color(0xFFD99898))
                    ),
                    shape = RoundedCornerShape(
                        topStart = 35.dp,
                        bottomStart = 35.dp
                    )
                )
        ){
            Column (modifier = Modifier
                .statusBarsPadding(),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Box (modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp)
                ){
                    Image(
                        modifier = Modifier
                            .size(170.dp)
                            .align(Alignment.Center),
                        painter = painterResource(id = R.drawable.car_white),
                        contentDescription =null
                    )
                }
                DefaultOutlinedTextField(
                    modifier = Modifier,
                    value = state.name,
                    label = "Nombre",
                    icon = Icons.Outlined.Person,
                    onValueChange = { text ->
                        viewModel.onNameInput(text)
                    }
                )
                Spacer(modifier = Modifier.height(10.dp))
                DefaultOutlinedTextField(
                    modifier = Modifier,
                    value = state.lastName,
                    label = "Apellido",
                    icon = Icons.Outlined.Person,
                    onValueChange = {
                        viewModel.onLastnameInput(it)
                    }
                )
                Spacer(modifier = Modifier.height(10.dp))
                DefaultOutlinedTextField(
                    modifier = Modifier,
                    value = state.email,
                    label = "E-mail",
                    icon = Icons.Outlined.Email,
                    keyboardType = KeyboardType.Email,
                    onValueChange = {
                        viewModel.onEmailInput(it)
                    }
                )
                Spacer(modifier = Modifier.height(10.dp))
                DefaultOutlinedTextField(
                    modifier = Modifier,
                    value = state.phone,
                    label = "Telefono",
                    icon = Icons.Outlined.Phone,
                    keyboardType = KeyboardType.Number,
                    onValueChange = {
                        viewModel.onPhoneInput(it)
                    }
                )
                Spacer(modifier = Modifier.height(10.dp))
                DefaultOutlinedTextField(
                    modifier = Modifier,
                    value = state.password,
                    label = "Contraseña",
                    icon = Icons.Outlined.Lock,
                    hideText = true,
                    onValueChange = {
                        viewModel.onPasswordInput(it)
                    }
                )
                Spacer(modifier = Modifier.height(10.dp))
                DefaultOutlinedTextField(
                    modifier = Modifier,
                    value = state.confirmPassword,
                    label = "Confirmar Contraseña",
                    icon = Icons.Outlined.Lock,
                    hideText = true,
                    onValueChange = {
                        viewModel.onConfirmPasswordInput(it)
                    }
                )
                Spacer(modifier = Modifier.weight(1f))
                DefaultButton(
                    modifier = Modifier,
                    text = "Crear Usuario",
                    onClick = {viewModel.register()}
                )
                Spacer(modifier = Modifier.height(15.dp))
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Spacer(modifier = Modifier
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
                    Spacer(modifier = Modifier
                        .width(30.dp)
                        .height(1.dp)
                        .background(Color.Black)
                    )
                }
                Spacer(modifier = Modifier.width(30.dp))
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ){
                    Text(
                        text = "Ya tienes cuenta?",
                        color = Color.Black,
                        fontSize = 17.sp
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        modifier = Modifier.clickable(){
                            navHostController.popBackStack()
                        },
                        text = "Iniciar sesion",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 17.sp
                    )
                }
                Spacer(modifier = Modifier.height(15.dp))
            }
        }
    }
}