package com.example.leftovers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.leftovers.ui.theme.LeftoversTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LeftoversTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = Color.Green) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    var inputCheck by remember { mutableStateOf("") }
//    var currentPercentage by remember { mutableStateOf(Percentage.OFF) }
    var result by remember { mutableStateOf("") }
    var total by remember { mutableStateOf("") }
    var showText by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Leftovers",
            fontSize = 32.sp,
            modifier = Modifier.padding(all = 30.dp)
        )
        Row() {
            Text(
                text = "A better way of giving",
                fontSize = 24.sp,

            )
        }

//        Row(
//            horizontalArrangement = Arrangement.Start,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Text("")
//        }
    }
}
