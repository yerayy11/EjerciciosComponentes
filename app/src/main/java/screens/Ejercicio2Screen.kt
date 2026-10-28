package screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import model.Tarea

@Composable
fun Ejercicio2Screen(
    onBack: () -> Unit
) {

    var tareas by remember {

        mutableStateOf(

            listOf(

                Tarea(
                    1,
                    "Estudiar Kotlin",
                    false,
                    "Alta"
                ),

                Tarea(
                    2,
                    "Practicar ejercicios",
                    false,
                    "Media"
                ),

                Tarea(
                    3,
                    "Subir proyecto a GitHub",
                    true,
                    "Baja"
                )
            )
        )
    }

    val pendientes =
        tareas.filter { !it.completada }

    val completadas =
        tareas.filter { it.completada }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        item {

            Button(
                onClick = onBack
            ) {
                Text("Volver")
            }

            Spacer(
                modifier = Modifier.height(16.dp)
            )
        }


        item {

            Text(
                "Tareas pendientes",
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )
        }

        items(pendientes) { tarea ->

            TareaCard(
                tarea = tarea,
                onUpdate = { nuevaTarea ->

                    tareas = tareas.map {

                        if (it.id == nuevaTarea.id)
                            nuevaTarea
                        else
                            it
                    }
                }
            )
        }

        item {

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            HorizontalDivider(color = Color.Gray, thickness = 1.dp)

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            Text(
                "Tareas completadas",
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )
        }

        items(completadas) { tarea ->

            TareaCard(
                tarea = tarea,
                onUpdate = { nuevaTarea ->

                    tareas = tareas.map {

                        if (it.id == nuevaTarea.id)
                            nuevaTarea
                        else
                            it
                    }
                }
            )
        }
    }
}