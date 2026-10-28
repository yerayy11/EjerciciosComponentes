package screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    onEjercicio1Click: () -> Unit,
    onEjercicio2Click: () -> Unit
    ) {
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Text(
            text = "Ejercicios Componentes",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = onEjercicio1Click,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ejercicio 1")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onEjercicio2Click,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ejercicio 2")
        }
    }
}