package com.example.challenge2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.challenge2.R
import com.example.challenge2.ui.components.Header
import com.example.challenge2.ui.components.Navbar
import com.example.challenge2.ui.components.AppDrawerContent
import com.example.challenge2.ui.components.NavDrawerItem
import com.example.challenge2.ui.screens.ShopListScreen
import com.example.challenge2.ui.screens.FavouritesScreen
import com.example.challenge2.ui.screens.ProfileScreen
import com.example.challenge2.ui.screens.SettingsScreen
import com.example.challenge2.ui.screens.ItemDetailScreen
import com.example.challenge2.ui.theme.Challenge2Theme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Challenge2Theme {
                // 1. Controlador de Navegación y Estado del Menú
                val navController = rememberNavController()
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                val scope = rememberCoroutineScope()

                // Obtiene la ruta actual para saber qué pantalla está activa
                val currentBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = currentBackStackEntry?.destination?.route ?: "shop_list"

                ModalNavigationDrawer(
                    drawerState = drawerState,
                    drawerContent = {
                        // El contenido del menú
                        AppDrawerContent(
                            currentRoute = currentRoute,
                            onItemClick = { route ->
                                navController.navigate(route) {
                                    popUpTo(navController.graph.startDestinationId)
                                    launchSingleTop = true
                                }
                                scope.launch { drawerState.close() }
                            }
                        )
                    }
                ) {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        topBar = {
                            Header(
                                title = getTitleForRoute(currentRoute),
                                onMenuClick = {
                                    scope.launch { drawerState.open() }
                                }
                            )
                        },
                        bottomBar = {
                            Navbar()
                        },
                    ) { innerPadding ->
                        Box(modifier = Modifier.padding(innerPadding)) {
                            // 3. NavHost: El corazón de la navegación
                            // Aquí se define qué pantalla (composable) corresponde a cada ruta.
                            NavHost(navController = navController, startDestination = "shop_list") {
                                composable("shop_list") {
                                    ShopListScreen(
                                        onProductBuy = {
                                            navController.navigate("product_detail")
                                        }
                                    )
                                }
                                composable("favourites") { FavouritesScreen() }
                                composable("profile") { ProfileScreen() }
                                composable("settings") { SettingsScreen() }
                                composable("product_detail") { ItemDetailScreen() }
                            }
                        }
                    }
                }
            }
        }
    }
}

// Función auxiliar para obtener el título correcto para cada pantalla
private fun getTitleForRoute(route: String): String {
    return when (route) {
        "shop_list" -> "Shop list"
        "favourites" -> "Favourites"
        "profile" -> "Profile"
        "settings" -> "Settings"
        "product_detail" -> "Leather boot"
        else -> "Shop"
    }
}