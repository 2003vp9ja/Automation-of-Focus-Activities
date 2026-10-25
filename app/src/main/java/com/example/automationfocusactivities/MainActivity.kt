package com.example.automationfocusactivities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.automationfocusactivities.screens.CalendarScreen
import com.example.automationfocusactivities.screens.EventRegistrationScreen
import com.example.automationfocusactivities.screens.HomeScreen
import com.example.automationfocusactivities.screens.LoginScreen
import com.example.automationfocusactivities.screens.NotificationScreen
import com.example.automationfocusactivities.screens.PreviousEventsScreen
import com.example.automationfocusactivities.screens.ProfileScreen
import com.example.automationfocusactivities.screens.SignUpScreen
import com.example.automationfocusactivities.screens.SplashScreen
import com.example.automationfocusactivities.ui.theme.AutomationFocusActivitiesTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            AutomationFocusActivitiesTheme {

                var currentScreen by remember {
                    mutableStateOf("Splash")
                }

                when (currentScreen) {

                    "Splash" -> SplashScreen(
                        onSplashFinished = {
                            currentScreen = "Login"
                        }
                    )

                    "Login" -> LoginScreen(
                        onLoginSuccess = {
                            currentScreen = "Home"
                        },
                        onSignUpClick = {
                            currentScreen = "SignUp"
                        }
                    )

                    "SignUp" -> SignUpScreen(
                        onBackToLogin = {
                            currentScreen = "Login"
                        }
                    )

                    "Home" -> HomeScreen(
                        currentScreen = currentScreen,

                        onHomeClick = {
                            currentScreen = "Home"
                        },

                        onProfileClick = {
                            currentScreen = "Profile"
                        },

                        onCalendarClick = {
                            currentScreen = "Calendar"
                        },

                        onRegistrationClick = {
                            currentScreen = "Registration"
                        },

                        onNotificationClick = {
                            currentScreen = "Notification"
                        },

                        onPreviousEventsClick = {
                            currentScreen = "Previous"
                        },

                        onLogoutClick = {
                            currentScreen = "Login"
                        }
                    )

                    "Profile" -> ProfileScreen(
                        onBack = {
                            currentScreen = "Home"
                        }
                    )

                    "Calendar" -> CalendarScreen(
                        onBack = {
                            currentScreen = "Home"
                        }
                    )

                    "Registration" -> EventRegistrationScreen(
                        onBack = {
                            currentScreen = "Home"
                        }
                    )

                    "Notification" -> NotificationScreen(
                        onBack = {
                            currentScreen = "Home"
                        }
                    )

                    "Previous" -> PreviousEventsScreen(
                        onBack = {
                            currentScreen = "Home"
                        }
                    )
                }
            }
        }
    }
}