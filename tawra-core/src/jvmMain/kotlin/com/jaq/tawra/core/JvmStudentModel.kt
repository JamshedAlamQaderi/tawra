package com.jaq.tawra.core

data class JvmStudentModel(val id: Int, val name: String)

fun main() {
    println(JvmStudentModel(123, "Jamshed"))
}