package com.example.leftovers.ui.userprofile


import android.app.Application
import android.content.Context
import android.content.Intent
import android.graphics.fonts.FontStyle
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.example.leftovers.R
import com.example.leftovers.model.FoodBank
import com.example.leftovers.model.Restaurant
import com.example.leftovers.ui.foodbankList.FoodBankListViewModel
import com.example.leftovers.ui.landingpage.LandingPageViewModel
import com.example.leftovers.ui.nav.Routes
import com.example.leftovers.ui.restaurantList.RestaurantListViewModel
import kotlinx.coroutines.delay
import okhttp3.internal.userAgent
import okhttp3.internal.wait
import java.net.URLEncoder
import java.nio.charset.StandardCharsets


@ExperimentalComposeUiApi
@Composable
fun BankUser(
    vm: FoodBankListViewModel = viewModel(),
    app: Context,
    nav: NavHostController

) {
    val editFlag = remember { mutableStateOf(false) }
    val newPicUrl = "https://2qibqm39xjt6q46gf1rwo2g1-wpengine.netdna-ssl.com/wp-content/uploads/2020/11/23354992_web1_L3-foodbank-edh-201009-FS.jpg"
    val encodePicUrl = URLEncoder.encode(
        newPicUrl,
        StandardCharsets.UTF_8.toString()
    )

    val painter = rememberImagePainter(
        data = vm.userBank.value?.picUrl,
        builder = {
            placeholder(R.mipmap.leftovers_logo_foreground)
        }
    )

    val name = remember { mutableStateOf("") }
    val location = remember { mutableStateOf("") }
    val vmName = remember { mutableStateOf("${vm.userBank.value?.name}")}
    val vmLocation = remember { mutableStateOf("${vm.userBank.value?.location}")}

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ){
        Row() {
            if(editFlag.value == false)
                Text(
                    text = vmName.value,
                    modifier = Modifier.padding(16.dp),
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )
            else if(editFlag.value == true){
                TextField(
                    value = name.value,
                    onValueChange = { name.value = it },
                    placeholder = {
                        Text("Enter new name here...")
                    },
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
        Row() {
            Image(
                modifier = Modifier
                    .size(250.dp)
                    .clip(CircleShape)
                    .border(6.dp, Color.Black, CircleShape)
                    .padding(20.dp),
                painter = painter,
                contentDescription = "Full picture",
                alignment = Alignment.Center,
                contentScale = ContentScale.FillBounds
            )
        }
        Row(){
            if(editFlag.value == false)
                Text(
                    text = vmLocation.value,
                    modifier = Modifier.padding(16.dp),
                    fontSize = 14.sp
                )
            else if(editFlag.value == true){
                TextField(
                    value = location.value,
                    onValueChange = { location.value = it },
                    placeholder = {
                        Text("Enter new location here...")
                    },
                    modifier = Modifier.padding(16.dp)
                )
            }
        }

//    Spacer(modifier = Modifier.size(20.dp))
//    Row() {
//        //pseudocode of all the code here
//        TextField(
//            value = name.value,
//            onValueChange = { name.value = it }
//        )
//        Text("This textfield has this text: " + name.value)
//    }
////        Button(
////            onClick = {
////                vm.updateRest(Restaurant(1, "${name.value}", "${location.value}", 10, newPicUrl, true))
////                val url = "https://androidclass.herokuapp.com/?idP=v1&nameP=${name.value}&locationP=${location.value}&distanceP=v4&picURLP=${encodePicUrl}&isAcceptingP=true"
////                val intent = Intent(Intent.ACTION_VIEW)
////                intent.setData(Uri.parse(url))
////                app.startActivity(intent)
////            }
////        ) {
////            Text("Submit changes")
////        }
        if(editFlag.value == false) {
            Button(
                onClick = {
                    editFlag.value = true
                }
            ) {
                Text("Edit profile")
            }
        }
        else if(editFlag.value == true){
            Button(
                onClick = {
                    vm.updateBank(
                        FoodBank(
                            1,
                            "${name.value}",
                            "${location.value}",
                            10,
                            newPicUrl,
                            true
                        )
                    )
                    editFlag.value = false
                    val url =
                        "https://androidclass.herokuapp.com/?idP=v1&nameP=${name.value}&locationP=${location.value}&distanceP=v4&picURLP=${encodePicUrl}&isAcceptingP=true"
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.setData(Uri.parse(url))
                    app.startActivity(intent)
//                    vmName.value = "${vm.userRest.value?.name}"
//                    vmLocation.value = "${vm.userRest.value?.location}"
                    nav.navigate(Routes.FoodBankLandingPage.route){
                        popUpTo(Routes.FoodBankLandingPage.route)
                    }
                },
                modifier = Modifier.padding(16.dp)
            ) {
                Text("Submit changes")
            }

        }
    } //if ending
}