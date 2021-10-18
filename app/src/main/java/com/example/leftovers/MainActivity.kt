package com.example.leftovers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.material.Icon
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.PopupProperties
import com.example.leftovers.ui.theme.LeftoversTheme
import com.example.leftovers.ui.theme.Orange
import java.lang.reflect.Type

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LeftoversTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = Color(0xFFF5A320))

                 {
                    MainScreen()
                    //DropdownDemo()
                    //AlertDialogSample()
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
    var expanded by remember { mutableStateOf(false)}
    val items = listOf("Store login", "", "C", "D", "E", "F")
    val disabledValue = "B"
    var selectedIndex by remember { mutableStateOf(0) }
//    Column(
//        modifier = Modifier.fillMaxWidth(),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text(
//
//            style = MaterialTheme.typography.body1,
//            text = "Leftovers",
//            fontSize = 32.sp,
//            modifier = Modifier.padding(all = 30.dp)
//        )
//        Row() {
//            Text(
//                text = "A better way of giving",
//                fontSize = 24.sp,
//
//            )
//
//        }


//        Row(
//            horizontalArrangement = Arrangement.Start,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Text("")
//        }
   // }
    Box(Modifier.fillMaxSize()){
        Text("Leftovers",
            style = MaterialTheme.typography.body1,
            fontSize = 44.sp,
            modifier =
//            Modifier.padding(all = 30.dp),
            Modifier
                .align(Alignment.TopCenter)
                .padding(all = 30.dp),
            color = Color.White,

        )
        FloatingActionButton(
            onClick = {expanded = true},
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(12.dp),
            backgroundColor = Color.White

        ) {
            Icon(Icons.Rounded.Menu, contentDescription = "Localized description")
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Color.Red
                )
        ) {
            items.forEachIndexed { index, s ->
                DropdownMenuItem(onClick = {
                    selectedIndex = index
                    expanded = false
                }) {
                    val disabledText = if (s == disabledValue) {
                        " (Disabled)"
                    } else {
                        ""
                    }
                    Text(text = s + disabledText)
                }
            }
        }
//        AlertDialog(
//            onDismissRequest = {
//                openDialog.value = false
//            },
//
//        )
    }
}

//@Composable
//fun DropdownMenu(
//    expanded: Boolean,
//    onDismissRequest: () -> Unit,
//    modifier: Modifier = Modifier,
//    offset: DpOffset = DpOffset(0.dp, 0.dp),
//    properties: PopupProperties = PopupProperties(focusable = true),
//    content: @Composable ColumnScope.() -> Unit)
//{
////){
////    Column(){
////        FloatingActionButton(onClick = {ex}) {
////
////        }
////    }
//}

@Composable
fun AlertDialogSample() {
    MaterialTheme {
        Column {
            val openDialog = remember { mutableStateOf(false)  }

            Button(onClick = {
                openDialog.value = true
            }) {
                Text("Click me")
            }

            if (openDialog.value) {

                AlertDialog(
                    onDismissRequest = {
                        // Dismiss the dialog when the user clicks outside the dialog or on the back
                        // button. If you want to disable that functionality, simply use an empty
                        // onCloseRequest.
                        openDialog.value = false
                    },
                    title = {
                        Text(text = "Dialog Title")
                    },
                    text = {
                        Text("Here is a text ")
                    },
                    confirmButton = {
                        Button(

                            onClick = {
                                openDialog.value = false
                            }) {
                            Text("This is the Confirm Button")
                        }
                    },
                    dismissButton = {
                        Button(

                            onClick = {
                                openDialog.value = false
                            }) {
                            Text("This is the dismiss Button")
                        }
                    }
                )
            }
        }

    }
}

@Composable
fun DropdownDemo() {
    var expanded by remember { mutableStateOf(false) }
    val items = listOf("A", "B", "C", "D", "E", "F")
    val disabledValue = "B"
    var selectedIndex by remember { mutableStateOf(0) }
    Box(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.TopStart)) {
        Text(items[selectedIndex],modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = { expanded = true })
            .background(
                Color.Gray
            ))
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Color.Red
                )
        ) {
            items.forEachIndexed { index, s ->
                DropdownMenuItem(onClick = {
                    selectedIndex = index
                    expanded = false
                }) {
                    val disabledText = if (s == disabledValue) {
                        " (Disabled)"
                    } else {
                        ""
                    }
                    Text(text = s + disabledText)
                }
            }
        }
    }
}




