package com.example.lab2task5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab2task5.ui.theme.Lab2Task5Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        task5()
        enableEdgeToEdge()
        setContent {
           Text("task5")
            }
        }
    }

data class Course(
    val code: String,
    val title: String,
    val credits: Int,
    val days: String
)

fun findCourse(list: List<Course>, code: String): String =
    list.firstOrNull { it.code == code }?.title ?: "Course not found"

fun task5() {
    val courses = listOf(
        Course("CSC 402", "Mobile Application Programming", 3, "Mon / Wed"),
        Course("CSC 311", "Database Systems", 4, "Sun / Tue"),
        Course("CSC 340", "Operating Systems", 3, "Mon / Wed"),
        Course("MATH 202", "Discrete Mathematics", 3, "Sun / Thu"),
        Course("ENG 214", "Technical Writing", 2, "Tue")
    )

    println("All courses:")
    courses.forEach { println(it) }

    println("\nCourses worth 3 credits or more:")
    courses.filter { it.credits >= 3 }.forEach { println(it) }

    val codes = courses.map { it.code }
    println("\nCourse codes: $codes")

    println("Total credit hours: ${courses.sumOf { it.credits }}")

    println("CSC 402: ${findCourse(courses, "CSC 402")}")
    println("CSC 999: ${findCourse(courses, "CSC 999")}")

    val updated = courses.first { it.code == "CSC 402" }.copy(credits = 4)
    println("Copied CSC 402: $updated")
    println("Original CSC 402: ${courses.first { it.code == "CSC 402" }}")
}

