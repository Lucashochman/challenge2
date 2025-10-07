package com.example.challenge2.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.challenge2.R
import com.example.challenge2.ui.components.BuyWithIconButton
import com.example.challenge2.ui.components.FavouriteItem
import com.example.challenge2.ui.theme.Challenge2Theme

@Composable
fun FavouritesScreen() {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Generamos 3 items de ejemplo
        items(3) { index ->
            FavouriteItem(
                number = index + 1,
                title = "Leather boots",
                price = "27,5 $",
                imageRes = R.drawable.media_botas
            )
        }

        // Añadimos el botón al final de la lista
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                BuyWithIconButton()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FavouritesScreenPreview() {
    Challenge2Theme {
        FavouritesScreen()
    }
}