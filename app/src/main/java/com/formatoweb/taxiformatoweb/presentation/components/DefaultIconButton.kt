package com.formatoweb.taxiformatoweb.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DefaultIconButton(modifier: Modifier, title: String, imageVector: ImageVector, onClick: () -> Unit) {
    Row (modifier = Modifier
        .fillMaxWidth()
        .clickable { onClick() }
        .padding(top = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Box(modifier = Modifier
            .size(50.dp)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xFFFF0000), Color(0xFF5B0707))
                ),
                shape = CircleShape
            ),
            contentAlignment = Alignment.Center
        ){
            Icon(
                imageVector = imageVector,
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.width(15.dp))
        Text(
            text = title,
            fontSize = 19.sp,
            fontWeight = FontWeight.Bold)
    }
}