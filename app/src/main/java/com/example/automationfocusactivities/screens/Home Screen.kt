package com.example.automationfocusactivities.screens

import com.example.automationfocusactivities.components.BottomNavigationBar
import com.example.automationfocusactivities.components.EventCard
import com.example.automationfocusactivities.model.Event
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Event
import androidx.compose.material.icons.filled.Logout
import com.example.automationfocusactivities.components.DashboardCard
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import kotlinx.coroutines.launch
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    currentScreen: String,
    onHomeClick: () -> Unit,
    onProfileClick: () -> Unit,
    onCalendarClick: () -> Unit,
    onRegistrationClick: () -> Unit,
    onNotificationClick: () -> Unit,
    onPreviousEventsClick: () -> Unit,
    onLogoutClick: () -> Unit
) {


    var searchText by remember { mutableStateOf("") }

    val events = listOf(
        Event(
            title = "Coding Competition",
            date = "10-07-2026",
            venue = "Seminar Hall"
        ),
        Event(
            title = "AI Workshop",
            date = "15-07-2026",
            venue = "Computer Lab"
        ),
        Event(
            title = "Technical Seminar",
            date = "20-07-2026",
            venue = "Auditorium"
        )
    )

    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()


    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {

            ModalDrawerSheet {

                Text(
                    text = "Automation Focus Activities",
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.titleLarge
                )

                NavigationDrawerItem(
                    label = { Text("Home") },
                    selected = false,
                    onClick = { }
                )

                NavigationDrawerItem(
                    label = { Text("Profile") },
                    selected = false,
                    onClick = onProfileClick
                )

                NavigationDrawerItem(
                    label = { Text("Calendar") },
                    selected = false,
                    onClick = onCalendarClick
                )

                NavigationDrawerItem(
                    label = { Text("Event Registration") },
                    selected = false,
                    onClick = onRegistrationClick
                )

                NavigationDrawerItem(
                    label = { Text("Notifications") },
                    selected = false,
                    onClick = onNotificationClick
                )

                NavigationDrawerItem(
                    label = { Text("Previous Events") },
                    selected = false,
                    onClick = onPreviousEventsClick
                )

                HorizontalDivider()

                NavigationDrawerItem(
                    label = { Text("Home") },
                    selected = currentScreen == "Home",
                    onClick = onHomeClick
                )
            }
        }
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {

        CenterAlignedTopAppBar(
            title = {
                Text("Automation Focus Activities")
            },
            navigationIcon = {
                IconButton(
                    onClick = {
                        scope.launch {
                            drawerState.open()
                        }
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Menu"
                    )
                }
            }
        )

        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF1565C0)
                )
            ) {
                Column(
                    modifier = Modifier.padding(20.dp)
                ) {

                    Text(
                        text = "Good Evening, Vaishnavi",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.headlineSmall
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = "Automation Focus Activities",
                        color = Color.White,
                        style = MaterialTheme.typography.titleMedium
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "Department of Computer Science & Engineering",
                        color = Color.White.copy(alpha = 0.9f),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = searchText,
                onValueChange = {
                    searchText = it
                },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text("Search Events")
                },
                placeholder = {
                    Text("Search...")
                }
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Welcome Student!",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {

                Box(modifier = Modifier.weight(1f)) {
                    DashboardCard(
                        title = "Total Events",
                        value = "12",
                        emoji = "📅"
                    )
                }

                Box(modifier = Modifier.weight(1f)) {
                    DashboardCard(
                        title = "Notifications",
                        value = "5",
                        emoji = "🔔"
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Upcoming Events",
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(10.dp))

            Column {

                val filteredEvents = events.filter {
                    it.title.contains(searchText, ignoreCase = true)
                }

                filteredEvents.forEach { event ->

                    EventCard(
                        title = event.title,
                        date = event.date,
                        venue = event.venue
                    )

                    Spacer(modifier = Modifier.height(10.dp))
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Quick Actions",
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Button(
                    onClick = onProfileClick,
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Profile")
                }

                Spacer(modifier = Modifier.width(10.dp))

                Button(
                    onClick = onCalendarClick,
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Calendar")
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Button(
                    onClick = onRegistrationClick,
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Register")
                }

                Spacer(modifier = Modifier.width(10.dp))

                Button(
                    onClick = onNotificationClick,
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Notifications")
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = onPreviousEventsClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Previous Events")
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Latest Updates",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text("• Registration is open for Coding Competition.")
            Text("• Workshop seats are limited.")
            Text("• Check Notifications for more details.")

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = onLogoutClick,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red
                )
            ) {
                Text("Logout")
            }

            Spacer(modifier = Modifier.height(10.dp))

            BottomNavigationBar(
                currentScreen = currentScreen,
                onHomeClick = onHomeClick,
                onCalendarClick = onCalendarClick,
                onNotificationClick = onNotificationClick,
                onProfileClick = onProfileClick
            )

        }
        }
}
    }