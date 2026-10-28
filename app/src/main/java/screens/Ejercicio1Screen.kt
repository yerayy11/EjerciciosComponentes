package screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ejercicioscomponentes.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun Ejercicio1Screen(
    onBack: () -> Unit
) {

    var mensaje by remember { mutableStateOf("") }

    var mostrarTexto by remember { mutableStateOf(false) }

    var mostrarOpciones by remember { mutableStateOf(false) }

    var cargando by remember { mutableStateOf(false) }

    var opcionSeleccionada by remember { mutableStateOf("") }

    var indiceImagen by remember { mutableStateOf(0) }

    val imagenes = listOf(
        R.drawable.imagen1,
        R.drawable.imagen2,
        R.drawable.imagen3
    )

    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(
            onClick = onBack
        ) {
            Text("Volver")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Ejercicio 1",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        Icon(
            imageVector = Icons.Default.Star,
            contentDescription = "Icono"
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {

                mensaje = "Botón presionado"

                indiceImagen =
                    (indiceImagen + 1) % imagenes.size

                cargando = true

                scope.launch {

                    delay(5000)

                    cargando = false
                }
            }
        ) {
            Text("Presionar")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Checkbox(
                checked = mostrarTexto,
                onCheckedChange = {
                    mostrarTexto = it
                }
            )

            Text("Activar")
        }

        if (mostrarTexto) {

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = mensaje)
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (cargando) {

            CircularProgressIndicator()

            Spacer(modifier = Modifier.height(16.dp))
        }

        Image(
            painter = painterResource(imagenes[indiceImagen]),
            contentDescription = "Imagen",
            modifier = Modifier.size(180.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text("Mostrar opciones")

            Spacer(modifier = Modifier.width(8.dp))

            Switch(
                checked = mostrarOpciones,
                onCheckedChange = {
                    mostrarOpciones = it
                }
            )
        }

        if (mostrarOpciones) {

            Spacer(modifier = Modifier.height(16.dp))

            Column {

                listOf(
                    "Opción A",
                    "Opción B",
                    "Opción C"
                ).forEach { opcion ->

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        RadioButton(
                            selected = opcionSeleccionada == opcion,
                            onClick = {

                                opcionSeleccionada = opcion
                                mensaje = opcion
                            }
                        )

                        Text(opcion)
                    }
                }
            }
        }
    }
}
