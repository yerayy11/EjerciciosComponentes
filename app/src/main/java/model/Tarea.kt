package model

data class Tarea(

    val id: Int,

    val nombre: String,

    val completada: Boolean,

    var prioridad: String
)