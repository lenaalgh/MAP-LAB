package com.example.profilecard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.profilecard.ui.theme.ProfileCardTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ProfileCardTheme {

                val sampleStudent = Student(
                    name = "lena alghamdi",
                    program = "Computer Science",
                    gpa = "4.5",
                    email = "2240001570@iau.edu.sa",
                    city = "Dammam"
                )

                StudentCard(student = sampleStudent)
            }
        }
    }
}


data class Student(
    val name: String,
    val program: String,
    val gpa: String,
    val email: String,
    val city: String
)


@Composable
fun StudentCard(
    student: Student,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {


            Box(
                modifier = Modifier.size(52.dp),
                contentAlignment = Alignment.Center
            ) {


                Box(
                    modifier = Modifier
                        .size(52.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primary),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = getInitials(student.name),
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                }


                Box(
                    modifier = Modifier
                        .size(15.dp)
                        .align(Alignment.BottomEnd)
                        .clip(CircleShape)
                        .background(Color.Green)
                        .border(
                            width = 2.dp,
                            color = MaterialTheme.colorScheme.surface,
                            shape = CircleShape
                        )
                )
            }


            Spacer(modifier = Modifier.width(12.dp))


            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = student.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = student.program,
                    fontSize = 14.sp,
                    color = Color.Gray
                )

                Text(
                    text = "Level 4",
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }


            Column(
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = student.gpa,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "GPA",
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }
        }

        HorizontalDivider()

        Text(
            text = student.email,
            fontSize = 14.sp
        )

        Text(
            text = student.city,
            fontSize = 14.sp,
            color = Color.Gray
        )
    }
}


fun getInitials(name: String): String {
    return name
        .trim()
        .split(" ")
        .filter { it.isNotEmpty() }
        .take(2)
        .joinToString("") { it.first().uppercase() }
}


@Preview(showBackground = true)
@Composable
fun StudentCardPreview() {

    ProfileCardTheme {

        StudentCard(
            student = Student(
                name = "lena alghamdi",
                program = "Computer Science",
                gpa = "4.5",
                email = "2240001570@iau.edu.sa",
                city = "dammam"
            )
        )
    }
}