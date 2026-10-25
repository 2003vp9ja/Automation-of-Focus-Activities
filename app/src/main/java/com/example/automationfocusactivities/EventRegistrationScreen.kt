package com.example.automationfocusactivities.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun EventRegistrationScreen(
    onBack: () -> Unit
) {

    var studentName by remember { mutableStateOf("") }
    var usn by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var department by remember { mutableStateOf("") }
    var eventName by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    var message by remember { mutableStateOf("") }

    val eventOptions = listOf(
        "Coding Competition",
        "AI Workshop",
        "Technical Seminar"
    )

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
            text = "📝 Event Registration",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Student Name
        OutlinedTextField(
            value = studentName,
            onValueChange = { studentName = it },
            label = { Text("Student Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        // USN
        OutlinedTextField(
            value = usn,
            onValueChange = { usn = it },
            label = { Text("USN") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        // Email
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        // Department
        OutlinedTextField(
            value = department,
            onValueChange = { department = it },
            label = { Text("Department") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        // Event Dropdown
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {

            OutlinedButton(
                onClick = {
                    expanded = true
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = if (eventName.isEmpty()) {
                        "Select Event"
                    } else {
                        eventName
                    }
                )
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = {
                    expanded = false
                }
            ) {

                eventOptions.forEach { event ->

                    DropdownMenuItem(
                        text = {
                            Text(event)
                        },
                        onClick = {
                            eventName = event
                            expanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Register Button
        Button(
            onClick = {

                if (
                    studentName.isNotEmpty() &&
                    usn.isNotEmpty() &&
                    email.isNotEmpty() &&
                    department.isNotEmpty() &&
                    eventName.isNotEmpty()
                ) {
                    message = "✅ Event Registered Successfully!"
                    studentName = ""
                    usn = ""
                    email = ""
                    department = ""
                    eventName = ""
                } else {
                    message = "⚠ Please fill all fields."
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Register Event")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = message,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}