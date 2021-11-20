package com.example.leftovers.ui.theme

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.leftovers.model.Restaurant

@ExperimentalFoundationApi
@Composable
fun FoodRow(
    restaurant: Restaurant,
    //onDelete: (Restaurant) -> Unit,
    isReadyChange: (Restaurant) -> Unit,
    //onSelectSong: (Restaurant) -> Unit
) {
    Log.d("TAG", restaurant.name)
    Card(
        shape = RoundedCornerShape(5.dp),
        elevation = 16.dp,
        modifier = Modifier
            .padding(start=16.dp, end=16.dp, top=5.dp, bottom=5.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .combinedClickable(
                    onLongClick = {
                        //onDelete(song)
                    }
                ) {
                    //onSelectSong(song)
                }.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(
                modifier = Modifier.weight(1.5f)
            ) {
                Row(
                    modifier = Modifier.padding(5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Name:", modifier = Modifier.weight(1.0f))
                    Text(restaurant.name, modifier = Modifier.weight(2.0f), fontSize = 28.sp, color = MaterialTheme.colors.secondary)
                }
                Row(
                    modifier = Modifier.padding(5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Location: ${restaurant.location}", modifier = Modifier.weight(1.0f))
                    //Text(restaurant.location, modifier = Modifier.weight(2f))
                }
                Row(
                    modifier = Modifier.padding(5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Distance: ${restaurant.distance.toString()}", modifier = Modifier.weight(2.0f))
                    //Text(restaurant.distance.toString(), modifier = Modifier.weight(4f))
                }
            }
            Column(
                modifier = Modifier.weight(1.0f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(onClick= {  }, modifier = Modifier.fillMaxWidth()) {
                    Text("Delete")
                }
                Spacer(modifier = Modifier.padding(bottom=5.dp))
                Row() {
                    Checkbox(checked = restaurant.is_ready, onCheckedChange = { isReadyChange(restaurant) }, modifier = Modifier.padding(end=5.dp))
                    Text("Is Ready?")
                }
            }
        }
    }
}
