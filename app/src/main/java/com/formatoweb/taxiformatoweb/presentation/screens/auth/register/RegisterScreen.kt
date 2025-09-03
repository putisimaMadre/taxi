package com.formatoweb.taxiformatoweb.presentation.screens.auth.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.formatoweb.taxiformatoweb.R
import com.formatoweb.taxiformatoweb.presentation.components.DefaultButton
import com.formatoweb.taxiformatoweb.presentation.components.DefaultOutlinedTextField
import com.formatoweb.taxiformatoweb.presentation.screens.auth.register.components.Register

import com.formatoweb.taxiformatoweb.presentation.screens.auth.register.components.RegisterComponent
import com.formatoweb.taxiformatoweb.ui.theme.TaxiFormatowebTheme

@Composable
fun RegisterScreen (navHostController: NavHostController){

    Scaffold { paddingValues ->
        RegisterComponent(navHostController = navHostController, paddingValues = paddingValues)
    }
    Register()
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegisterPreview(){
    TaxiFormatowebTheme{
        RegisterScreen(rememberNavController())
    }
}