package com.misapps.gestorturnos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.misapps.gestorturnos.ui.theme.GestorTurnosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GestorTurnosTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") { HomeScreen(navController) }
        composable("calendar") { CalendarScreen() }
        composable("salary_config") { SalaryConfigScreen() }
    }
}

@Composable
fun HomeScreen(navController: NavHostController) {
    Scaffold {
        Column {
            Button(onClick = { navController.navigate("calendar") }) {
                Text("Gestionar Calendario")
            }
            Button(onClick = { navController.navigate("salary_config") }) {
                Text("Configurar Nómina")
            }
        }
    }
}


@Composable
fun CalendarScreen() {
    Scaffold {
        Column {
            Text("Calendario", style = MaterialTheme.typography.headlineLarge)

            // Aquí implementaremos el calendario
            // Por ahora, solo mostramos un texto de ejemplo
            Text("Próximamente: Calendario Interactivo")
        }
    }
}


@Composable
fun SalaryConfigScreen() {
    Scaffold {
        Column {
            Text("Configurar Nómina", style = MaterialTheme.typography.headlineLarge)

            // Campos para ingresar los datos de la nómina
            Text("Próximamente: Configuración de Nómina")
        }
    }
}
