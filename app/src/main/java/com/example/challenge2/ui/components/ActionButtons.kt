package com.example.challenge2.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.challenge2.ui.theme.Challenge2Theme

// --- Componente para el botón "Add to favourite" ---
@Composable
fun AddToFavouriteButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(50), // Forma de píldora
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = Color(0xFFC67C4E) // Color del texto
        ),
        border = ButtonDefaults.outlinedButtonBorder.copy(
            brush = androidx.compose.ui.graphics.SolidColor(Color(0xFFC67C4E)) // Color del borde
        )
    ) {
        Text("Add to favourite")
    }
}

// --- Componente para el botón "Buy" ---
@Composable
fun BuyButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(50), // Forma de píldora
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFC67C4E), // Color de fondo
            contentColor = Color.White // Color del texto
        )
    ) {
        Text(
            text = "Buy",
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun BuyWithIconButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(50), // Forma de píldora
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFC67C4E), // Color de fondo
            contentColor = Color.White // Color del contenido
        ),
        contentPadding = PaddingValues(horizontal = 24.dp, vertical = 12.dp)
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = null, // el texto del botón lo describe
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text("Buy")
    }
}


// --- Preview para ver ambos botones juntos ---
@Preview(showBackground = true, widthDp = 320)
@Composable
fun ActionButtonsPreview() {
    Challenge2Theme {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            AddToFavouriteButton(modifier = Modifier.weight(1f))
            BuyButton(modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp))
            BuyWithIconButton(modifier = Modifier.weight(1f))
        }
    }
}