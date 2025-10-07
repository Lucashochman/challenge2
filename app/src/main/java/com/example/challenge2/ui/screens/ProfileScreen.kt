package com.example.challenge2.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.challenge2.R
import com.example.challenge2.ui.theme.Challenge2Theme

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()) // Permite hacer scroll si el contenido no cabe
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // --- Sección del Avatar ---
        Box(
            modifier = Modifier.size(120.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile_img), // Necesitarás una imagen de avatar
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape)
            )
            SmallFloatingActionButton(
                onClick = { /* TODO: Lógica para editar imagen */ },
                modifier = Modifier.align(Alignment.BottomEnd),
                containerColor = MaterialTheme.colorScheme.secondary
            ) {
                Icon(Icons.Filled.Edit, contentDescription = "Edit Picture", tint = Color.White)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // --- Nombre y Rol ---
        Text(
            text = "Martin",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "UI UX DESIGN",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(32.dp))

        // --- Campos de Información ---
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            ProfileInfoField(
                label = "E-Mail Address",
                value = "xxx@gmail.com",
                icon = Icons.Default.Email
            )
            ProfileInfoField(
                label = "Phone Number",
                value = "+5493123135",
                icon = Icons.Default.Call
            )
            ProfileInfoField(
                label = "Web Site",
                value = "www.google.com",
                icon = Icons.Default.Settings
            )
            ProfileInfoField(
                label = "Password",
                value = "xxxxxxxxxxxxxx",
                icon = Icons.Default.Lock
            )
        }
    }
}

// Componente reutilizable para cada campo de información
@Composable
private fun ProfileInfoField(label: String, value: String, icon: ImageVector) {
    OutlinedTextField(
        value = value,
        onValueChange = {},
        label = { Text(label) },
        readOnly = true, // El campo no es editable
        modifier = Modifier.fillMaxWidth(),
        trailingIcon = {
            Icon(imageVector = icon, contentDescription = null)
        }
    )
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    Challenge2Theme {
        ProfileScreen()
    }
}