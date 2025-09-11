package com.formatoweb.taxiformatoweb.presentation.screens.profile.info.components

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import com.formatoweb.taxiformatoweb.MainActivity
import com.formatoweb.taxiformatoweb.R
import com.formatoweb.taxiformatoweb.presentation.components.DefaultIconButton
import com.formatoweb.taxiformatoweb.presentation.screens.auth.register.RegisterScreen
import com.formatoweb.taxiformatoweb.presentation.screens.profile.info.ProfileInfoViewModel
import com.formatoweb.taxiformatoweb.ui.theme.TaxiFormatowebTheme

@Composable
fun ProfileInfoContent(navHostController: NavHostController,
                       paddingValues: PaddingValues,
                       vm: ProfileInfoViewModel = hiltViewModel()
) {
    val activity = LocalContext.current as? Activity
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(paddingValues)
    ){
        Column(modifier = Modifier.padding(10.dp)) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xFFFF0000), Color(0xFF5B0707))
                    )
                ),
                contentAlignment = Alignment.TopCenter
            ){
                Text(text = "PERFIL DE USUARIO",
                    modifier = Modifier.padding(top = 40.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 19.sp
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            DefaultIconButton(
                modifier = Modifier,
                title = "EDITAR PERFIL",
                imageVector = Icons.Default.Edit,
                onClick = {}
            )
            DefaultIconButton(
                modifier = Modifier,
                title = "CERRAR SESION",
                imageVector = Icons.Default.ExitToApp,
                onClick = {
                    vm.logout()
                    activity?.finish()
                    activity?.startActivity(Intent(activity, MainActivity::class.java))
                }
            )
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.8f)
                .padding(horizontal = 35.dp, vertical = 100.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)

        ) {
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(25.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(115.dp)
                        .clip(CircleShape)
                ){
                    if (!vm.user?.image.isNullOrBlank()){
                        AsyncImage(
                            model = vm.user?.image,
                            contentDescription = "",
                            contentScale = ContentScale.Crop
                        )
                    }else{
                        Image(
                            painter = painterResource(id = R.drawable.user_image),
                            contentDescription = null
                        )
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "${vm.user?.name} ${vm.user?.lastname}",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = vm.user?.email ?: "",
                    fontSize = 16.sp
                )
                Text(
                    text = vm.user?.phone ?: "",
                    fontSize = 16.sp
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Preview(){
    TaxiFormatowebTheme{
        ProfileInfoContent(rememberNavController(), PaddingValues())
    }
}