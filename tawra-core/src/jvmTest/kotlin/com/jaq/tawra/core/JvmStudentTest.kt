package com.jaq.tawra.core

import org.junit.Test
import kotlin.test.assertTrue

class JvmStudentTest {

    @Test
    fun jvmStudentTest(){
        println("Jvm Test ${JvmStudentModel(4343, "Jamshed Alam Qaderi")}")
        assertTrue(true)
    }
}