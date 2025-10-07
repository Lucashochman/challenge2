package com.example.challenge2.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.challenge2.R
import com.example.challenge2.ui.theme.Challenge2Theme

// Data class para representar cada ítem del menú
data class NavDrawerItem(
    val title: String,
    val icon: Int,
    val route: String,
    val badgeCount: Int? = null
)

@Composable
fun AppDrawerContent(
    currentRoute: String,
    onItemClick: (String) -> Unit
) {
    val navItems = listOf(
        NavDrawerItem("Shop list", R.drawable.icon, "shop_list"),
        NavDrawerItem("Favourites", R.drawable.icon_1, "favourites", 3),
        NavDrawerItem("Profile", R.drawable.icon_2, "profile"),
        NavDrawerItem("Settings", R.drawable.icon_4, "settings")
    )

    // Contenedor principal del contenido del drawer
    ModalDrawerSheet(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Títulos y cabeceras
            Text("Title", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(16.dp))
            Text("Section Header", style = MaterialTheme.typography.titleSmall)
            Spacer(modifier = Modifier.height(16.dp))

            // Lista de ítems de navegación
            navItems.forEach { item ->
                NavigationDrawerItem(
                    label = { Text(item.title) },
                    icon = { Icon(painter = painterResource(id = item.icon), contentDescription = item.title) },
                    selected = item.route == currentRoute,
                    onClick = { onItemClick(item.route) },
                    modifier = Modifier.padding(vertical = 4.dp),
                    // Badge para mostrar notificaciones o contadores
                    badge = {
                        item.badgeCount?.let {
                            Text(text = it.toString())
                        }
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun AppDrawerPreview() {
    Challenge2Theme {
        AppDrawerContent(
            currentRoute = "shop_list",
            onItemClick = { }
        )
    }
}