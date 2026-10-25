package com.example.automationfocusactivities.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun NotificationScreen(
    onBack: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Button(
            onClick = onBack
        ) {
            Text("← Back")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Notifications",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        NotificationCard(
            title = "Coding Competition",
            message = "Registration is now open.",
            date = "05-07-2026"
        )

        Spacer(modifier = Modifier.height(10.dp))

        NotificationCard(
            title = "AI Workshop",
            message = "Workshop starts on 15-07-2026.",
            date = "10-07-2026"
        )

        Spacer(modifier = Modifier.height(10.dp))

        NotificationCard(
            title = "Technical Seminar",
            message = "Venue changed to Auditorium.",
            date = "18-07-2026"
        )

        Spacer(modifier = Modifier.height(10.dp))

        NotificationCard(
            title = "Project Expo",
            message = "Registration closes tomorrow.",
            date = "25-07-2026"
        )
    }
}

@Composable
fun NotificationCard(
    title: String,
    message: String,
    date: String
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp)
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = message,
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "📅 $date",
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}