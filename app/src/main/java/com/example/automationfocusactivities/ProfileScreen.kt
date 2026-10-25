package com.example.automationfocusactivities.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ProfileScreen(
    onBack: () -> Unit
) {

    var isEditing by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(20.dp))

        Surface(
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape),
            color = Color(0xFF1565C0)
        ) {}

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Vaishnavi Pujar",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text("USN : 01CS22001")

                Spacer(modifier = Modifier.height(10.dp))

                Text("Department : Computer Science")

                Spacer(modifier = Modifier.height(10.dp))

                Text("Email : vaishnavi@gmail.com")

                Spacer(modifier = Modifier.height(10.dp))

                Text("Phone : 9876543210")
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {
                isEditing = !isEditing
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                if (isEditing) {
                    "Save Profile"
                } else {
                    "Edit Profile"
                }
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedButton(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Back")
        }

        if (isEditing) {

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "Profile editing mode enabled",
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}