package screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Badge
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import model.Tarea


@Composable
fun TareaCard(
    tarea: Tarea,
    onUpdate: (Tarea) -> Unit
) {

    var menuAbierto by remember {
        mutableStateOf(false)
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = tarea.nombre,
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row {

                Badge {
                    Text(tarea.prioridad)
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                if (tarea.completada)
                    "Completada"
                else
                    "Pendiente"
            )

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = {
                    menuAbierto = true
                }
            ) {
                Text("Opciones")
            }

            DropdownMenu(
                expanded = menuAbierto,
                onDismissRequest = {
                    menuAbierto = false
                }
            ) {

                DropdownMenuItem(
                    text = {
                        Text("Cambiar estado")
                    },
                    onClick = {

                        onUpdate(
                            tarea.copy(
                                completada = !tarea.completada
                            )
                        )

                        menuAbierto = false
                    }
                )

                DropdownMenuItem(
                    text = {
                        Text("Prioridad Alta")
                    },
                    onClick = {

                        onUpdate(
                            tarea.copy(
                                prioridad = "Alta"
                            )
                        )

                        menuAbierto = false
                    }
                )

                DropdownMenuItem(
                    text = {
                        Text("Prioridad Media")
                    },
                    onClick = {

                        onUpdate(
                            tarea.copy(
                                prioridad = "Media"
                            )
                        )

                        menuAbierto = false
                    }
                )

                DropdownMenuItem(
                    text = {
                        Text("Prioridad Baja")
                    },
                    onClick = {

                        onUpdate(
                            tarea.copy(
                                prioridad = "Baja"
                            )
                        )

                        menuAbierto = false
                    }
                )
            }
        }
    }
}
