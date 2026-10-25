package com.example.automationfocusactivities.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun CalendarScreen(
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
            text = "📅 Event Calendar",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        EventCard(
            date = "10 July 2026",
            title = "Coding Competition",
            venue = "Seminar Hall"
        )

        Spacer(modifier = Modifier.height(10.dp))

        EventCard(
            date = "15 July 2026",
            title = "AI Workshop",
            venue = "Computer Lab"
        )

        Spacer(modifier = Modifier.height(10.dp))

        EventCard(
            date = "20 July 2026",
            title = "Technical Seminar",
            venue = "Auditorium"
        )

        Spacer(modifier = Modifier.height(10.dp))

        EventCard(
            date = "25 July 2026",
            title = "Project Expo",
            venue = "Conference Hall"
        )
    }
}

@Composable
fun EventCard(
    date: String,
    title: String,
    venue: String
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

            Text("📅 $date")

            Text("📍 $venue")
        }
    }
}