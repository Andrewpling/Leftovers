package com.example.leftovers.ui.profile


import android.app.Application
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.example.leftovers.R
import com.example.leftovers.model.Restaurant
import com.example.leftovers.ui.landingpage.LandingPageViewModel
import com.example.leftovers.ui.restaurantList.RestaurantListViewModel


@ExperimentalComposeUiApi
@Composable
fun RestProfile(
    vm: RestaurantListViewModel = viewModel(),
    app: Context
) {


    val data = vm.selectedRest.value?.picUrl

    val painter = rememberImagePainter(
        data = data,
        builder = {
            placeholder(R.mipmap.sniper_monkey_foreground)
        }
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ){
        Text(
            text = vm.selectedRest.value?.name.toString(),
            modifier = Modifier.padding(16.dp)
        )
        Image(
            modifier = Modifier
                .size(250.dp),
            painter = painter,
            contentDescription = "Full picture",
            alignment = Alignment.Center
        )
        Text(
            text = vm.selectedRest.value?.location.toString(),
            modifier = Modifier.padding(16.dp)
        )
        Spacer(modifier = Modifier.size(20.dp))
        Row(

        ) {
            Button(
                onClick = {
                    //Todo: Create message intent functionality
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.setData(Uri.parse("smsto: 12345"))
                    intent.putExtra("sms_body", "What's going on?")
                    app.startActivity(intent)
                }
            ) {
                Text("Message")
            }
        }
    }

}
