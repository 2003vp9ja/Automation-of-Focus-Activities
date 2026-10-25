package com.example.automationfocusactivities.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun BottomNavigationBar(

    currentScreen: String,

    onHomeClick: () -> Unit,

    onCalendarClick: () -> Unit,

    onNotificationClick: () -> Unit,

    onProfileClick: () -> Unit

) {

    NavigationBar {

        NavigationBarItem(
            selected = currentScreen == "Home",
            onClick = onHomeClick,
            icon = {
                Icon(Icons.Default.Home, null)
            },
            label = {
                Text("Home")
            }
        )

        NavigationBarItem(
            selected = currentScreen == "Calendar",
            onClick = onCalendarClick,
            icon = {
                Icon(Icons.Default.CalendarMonth, null)
            },
            label = {
                Text("Calendar")
            }
        )

        NavigationBarItem(
            selected = currentScreen == "Notification",
            onClick = onNotificationClick,
            icon = {
                Icon(Icons.Default.Notifications, null)
            },
            label = {
                Text("Alerts")
            }
        )

        NavigationBarItem(
            selected = currentScreen == "Profile",
            onClick = onProfileClick,
            icon = {
                Icon(Icons.Default.Person, null)
            },
            label = {
                Text("Profile")
            }
        )

    }
}