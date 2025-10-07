package com.example.challenge2.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.challenge2.ui.components.*
import com.example.challenge2.ui.theme.Challenge2Theme

@Composable
fun SettingsScreen() {
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        // Sección de Cuenta
        SectionHeader("Account Settings")
        SettingsClickableItem("Edit profile") { /* TODO: Navigate */ }
        SettingsClickableItem("Change password") { /* TODO: Navigate */ }
        SettingsSwitchItem("Push notifications", initialChecked = true)
        SettingsSwitchItem("Dark mode", initialChecked = false)

        Divider()

        // Sección "Más"
        SectionHeader("More")
        SettingsClickableItem("About us") { /* TODO: Navigate */ }
        SettingsClickableItem("Privacy policy") { /* TODO: Navigate */ }
        SettingsClickableItem("Terms and conditions") { /* TODO: Navigate */ }
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    Challenge2Theme {
        SettingsScreen()
    }
}