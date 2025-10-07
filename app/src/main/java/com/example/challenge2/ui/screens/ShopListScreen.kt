package com.example.challenge2.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.challenge2.ui.components.ProductCard
import com.example.challenge2.ui.theme.Challenge2Theme

@Composable
fun ShopListScreen(onProductBuy: () -> Unit = {}) {
    // LazyColumn es el equivalente a RecyclerView.
    // Es muy eficiente para mostrar listas largas porque solo compone
    // los elementos que son visibles en la pantalla.
    LazyColumn(
        // Añade un padding general a la lista
        contentPadding = PaddingValues(vertical = 8.dp),
        // Añade espacio vertical entre cada tarjeta
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // En una app real, aquí iterarías sobre una lista de datos de productos.
        // Para este ejemplo, simplemente repetimos el ProductCard 10 veces.
        items(10) {
            ProductCard(onBuyClick = onProductBuy)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShopListScreenPreview() {
    Challenge2Theme {
        ShopListScreen()
    }
}