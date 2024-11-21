package com.misapps.gestorturnos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.jakewharton.threetenabp.AndroidThreeTen
import com.misapps.gestorturnos.ui.theme.GestorTurnosTheme

class MainActivity : ComponentActivity() {
    lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidThreeTen.init(this)

        // Inicializar la base de datos
        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "gestor_turnos_db"
        ).build()

        setContent {
            GestorTurnosTheme {
                AppNavigation(database)
            }
        }
    }
}

@Composable
fun AppNavigation(database: AppDatabase) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") { HomeScreen(navController, database) }
        composable("calendar") { CalendarScreen(database) }
        composable("salary_config") { SalaryConfigScreen(database) }
    }
}

@Composable
fun HomeScreen(navController: NavHostController, database: AppDatabase) {
    Scaffold { contentPadding ->
        Column(modifier = Modifier.padding(contentPadding)) {
            Button(onClick = { navController.navigate("calendar") }) {
                Text("Gestionar Calendario")
            }
            Button(onClick = { navController.navigate("salary_config") }) {
                Text("Configurar Nómina")
            }
            // Se puede usar la base de datos aquí para acceder a los datos y mostrarlos en la pantalla principal

        }
    }
}

@Composable
fun CalendarScreen(database: AppDatabase) {
    Scaffold { contentPadding ->
        Column(modifier = Modifier.padding(contentPadding)) {
            Text("Calendario", style = MaterialTheme.typography.headlineLarge)

            // Aquí implementaremos el calendario
            // Por ahora, solo mostramos un texto de ejemplo para comprobar que funcione
            Text("Próximamente: Calendario Interactivo")
        }
    }
}

@Composable
fun SalaryConfigScreen(database: AppDatabase) {
    Scaffold { contentPadding ->
        Column(modifier = Modifier.padding(contentPadding)) {
            Text("Configurar Nómina", style = MaterialTheme.typography.headlineLarge)

            // Campos para ingresar los datos de la nómina
            Text("Próximamente: Configuración de Nómina")
        }
    }
}
