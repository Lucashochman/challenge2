package com.example.challenge2.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.challenge2.R
import com.example.challenge2.ui.theme.Challenge2Theme

data class BottomNavItem(
    val label: String,
    val icon: Int
)

@Composable
fun Navbar() {
    val navItems = listOf(
        BottomNavItem("Product", R.drawable.home),
        BottomNavItem("Search", R.drawable.lupa),
        BottomNavItem("Shop", R.drawable.shop),
        BottomNavItem("Cart", R.drawable.carrito),
        BottomNavItem("Profile", R.drawable.user)
    )

    var selectedItemIndex by remember { mutableIntStateOf(2) } // Shop seleccionado por defecto

    BottomAppBar(
        containerColor = Color.White,
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            navItems.forEachIndexed { index, item ->
                val isSelected = selectedItemIndex == index

                NavigationBarItem(
                    selected = isSelected,
                    onClick = { selectedItemIndex = index },
                    icon = {
                        if (isSelected) {
                            // Icono seleccionado con fondo circular
                            Box(
                                modifier = Modifier
                                    .size(48.dp)
                                    .clip(CircleShape)
                                    .background(Color(0xFF8B4513)), // Color marrón
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    painter = painterResource(id = item.icon),
                                    contentDescription = item.label,
                                    tint = Color.White,
                                    modifier = Modifier.size(24.dp)
                                )
                            }
                        } else {
                            // Icono no seleccionado
                            Icon(
                                painter = painterResource(id = item.icon),
                                contentDescription = item.label,
                                tint = Color.Gray,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    },
                    label = {
                        Text(
                            text = item.label,
                            fontSize = 12.sp,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                            color = if (isSelected) Color(0xFF8B4513) else Color.Gray
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = Color.Transparent,
                        selectedIconColor = Color.White,
                        unselectedIconColor = Color.Gray,
                        selectedTextColor = Color(0xFF8B4513),
                        unselectedTextColor = Color.Gray
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NavbarPreview() {
    Challenge2Theme {
        Navbar()
    }
}