package com.example.leftovers.ui.restaurantList

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.leftovers.model.Restaurant
import com.example.leftovers.ui.theme.FoodRow

@ExperimentalFoundationApi
@Composable
fun RestaurantListView(
    vm: RestaurantListViewModel = viewModel(),
    restaurants: List<Restaurant>,
    isReadyChange: (Restaurant) -> Unit,


){
    //TODO: Uncomment if you are just installing the app
//    try{
//        vm.initializeValues()
//    } catch (e: Exception){
//        Log.d("No", "Bad")
//    }
    Box(
        contentAlignment = Alignment.Center,
    ) {
        Column(
            modifier = Modifier
            //         .alpha(if(waiting) 0.2f else 1.0f)
        ) {
            Row() {
                //   SearchBar(onFilter = onFilter)
                val config = LocalConfiguration.current
                LazyVerticalGrid(cells = GridCells.Fixed(2), contentPadding = PaddingValues(8.dp), content = {
                    itemsIndexed(restaurants) {idx, restaurant ->
                        (
                                FoodRow(restaurant, isReadyChange)
                                )
                    }
                })
            }

//                val config = LocalConfiguration.current
//                LazyColumn(contentPadding = PaddingValues(8.dp), content = {
//                    itemsIndexed(restaurants) { id, restaurant ->
//                        (
//                                FoodRow(restaurant, isReadyChange)
//                                )
//                    }
//                })
            //if (config.orientation == Configuration.ORIENTATION_PORTRAIT) {
//                    LazyColumn(
//                        horizontalAlignment = Alignment.Start
//                    ){
////                    itemsIndexed(restaurants) { restaurant ->
////                        (restaurant,
////                            //confirmViewModel.showConfirmDelete(onConfirm={ onDelete(song) })
////                         isReadyChange)
////                    }
//                    LazyRow(
//                        contentPadding = PaddingValues(8.dp)
//                    ){
//                        itemsIndexed(restaurants) { id, restaurant ->
//                            (
////                                    if (id % 2 == 0)
//                                        FoodRow(restaurant, isReadyChange)
////                                    )
//                                    )
//                        }
//                    }
//                    }
//                }
//           // }
//        }
//    }
//             else {
//                //LandscapeView(selectedSong?.name) {
//                    LazyColumn {
//                        itemsIndexed(restaurants) { idx, song ->
//                            FoodRow(song, { idx ->
//                                confirmViewModel.showConfirmDelete(onConfirm={ onDelete(song) })
//                            }, onToggle, onSelectSong)
//                        }
//                    }
//                }
//            }
//    Log.d("TAG", restaurants.name)
//    Card(
//        shape = RoundedCornerShape(5.dp),
//        elevation = 16.dp,
//        modifier = Modifier
//            .padding(start=16.dp, end=16.dp, top=5.dp, bottom=5.dp)
//            .fillMaxWidth()
//    ){
//        Row(
//            modifier = Modifier
//                .padding(16.dp),
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.SpaceEvenly
//        ) {
//            Column(
//                modifier = Modifier.weight(1.5f)
//            ) {
//                Row(
//                    modifier = Modifier.padding(5.dp),
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Text("Name:", modifier = Modifier.weight(1.0f))
//                    Text(
//                        restaurant.name,
//                        modifier = Modifier.weight(2.0f),
//                        fontSize = 28.sp,
//                        color = MaterialTheme.colors.secondary
//                    )
//                }
//                Row(
//                    modifier = Modifier.padding(5.dp),
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Text("Artist:", modifier = Modifier.weight(1.0f))
//                    Text(restaurant.location, modifier = Modifier.weight(2.0f))
//                }
//                Row(
//                    modifier = Modifier.padding(5.dp),
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Text("Track:", modifier = Modifier.weight(1.0f))
//                    Text(restaurant.distance.toString(), modifier = Modifier.weight(2.0f))
//                }
//            }
//            Column(
//                modifier = Modifier.weight(1.0f),
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Button(onClick = { onDelete(restaurant) }, modifier = Modifier.fillMaxWidth()) {
//                    Text("Delete")
//                }
//                Spacer(modifier = Modifier.padding(bottom = 5.dp))
//                Row() {
//                    Checkbox(
//                        checked = restaurant.is_ready,
//                        onCheckedChange = { donationReadyChange(restaurant) },
//                        modifier = Modifier.padding(end = 5.dp)
//                    )
//                    Text("Is Awesome")
//                }
//            }
//        }
//    }
        }
    }
}