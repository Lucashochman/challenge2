package com.example.challenge2.ui.components

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.challenge2.R // Asegúrate que tu R es importado correctamente

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Header(
    title: String,
    onMenuClick: () -> Unit = {}
) {
    CenterAlignedTopAppBar(
        // 1. Título dinámico en el centro
        title = {
            Text(text = title)
        },
        // 2. Icono de navegación a la izquierda (menú)
        navigationIcon = {
            IconButton(onClick = onMenuClick) {
                Icon(
                    painter = painterResource(id = R.drawable.hamburguesa),
                    contentDescription = "Menú de navegación"
                )
            }
        },
        // 3. Iconos de acciones a la derecha (perfil)
        actions = {
            IconButton(onClick = { /* TODO: Acción para el perfil */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.persona),
                    contentDescription = "Perfil de usuario"
                )
            }
        },
        // Fondo transparente para que tome el color de la pantalla
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.Transparent
        )
    )
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun HeaderPreview() {
    // Le pasamos un título de ejemplo para la previsualización
    Header(title = "Shop list")
}