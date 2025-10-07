package com.example.challenge2.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.challenge2.ui.components.BuyButton
import com.example.challenge2.ui.theme.Challenge2Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemDetailScreen() {
    // Estados para guardar la selección del usuario
    var selectedSize by remember { mutableStateOf("") }
    var quantity by remember { mutableStateOf("") }
    var isSizeMenuExpanded by remember { mutableStateOf(false) }
    val sizes = listOf("7", "7.5", "8", "8.5", "9")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // --- Selector de Talla ---
        Text(
            text = "Select size",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.fillMaxWidth()
        )

        // Dropdown Menu para las tallas
        ExposedDropdownMenuBox(
            expanded = isSizeMenuExpanded,
            onExpandedChange = { isSizeMenuExpanded = it },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            OutlinedTextField(
                value = selectedSize,
                onValueChange = {},
                readOnly = true,
                label = { Text("Label") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isSizeMenuExpanded) },
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth()
            )
            ExposedDropdownMenu(
                expanded = isSizeMenuExpanded,
                onDismissRequest = { isSizeMenuExpanded = false }
            ) {
                sizes.forEach { size ->
                    DropdownMenuItem(
                        text = { Text(size) },
                        onClick = {
                            selectedSize = size
                            isSizeMenuExpanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // --- Selector de Cantidad ---
        Text(
            text = "Count of product", // Corregí el typo "producy"
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = quantity,
            onValueChange = { quantity = it },
            label = { Text("Label") },
            placeholder = { Text("Input") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        )

        // Espacio para empujar los botones hacia abajo
        Spacer(modifier = Modifier.weight(1f))

        // --- Botones de Acción ---
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedButton(
                onClick = { /* TODO: Acción para volver atrás */ },
                modifier = Modifier.weight(1f)
            ) {
                Text("Back")
            }
            BuyButton(modifier = Modifier.weight(1f))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ItemDetailScreenPreview() {
    Challenge2Theme {
        ItemDetailScreen()
    }
}