package navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import screens.Ejercicio1Screen
import screens.Ejercicio2Screen
import screens.HomeScreen

@Composable
fun Navigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        composable("home") {
            HomeScreen(
                onEjercicio1Click = {
                    navController.navigate("ejercicio1")
                },
                onEjercicio2Click = {
                    navController.navigate("ejercicio2")
                }
            )
        }

        composable("ejercicio1") {
            Ejercicio1Screen(
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        composable("ejercicio2") {
            Ejercicio2Screen(
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}