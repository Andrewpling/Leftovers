package com.example.leftovers.ui.restaurantList

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.example.leftovers.R
import com.example.leftovers.model.Restaurant
import com.example.leftovers.ui.nav.Routes
import com.example.leftovers.ui.theme.FoodRow

@ExperimentalFoundationApi
@Composable
fun RestaurantListView(
    vm: RestaurantListViewModel = viewModel(),
    restaurants: List<Restaurant>,
    isReadyChange: (Restaurant) -> Unit,
    onSelectRest: (Restaurant) -> Unit,
    nav: NavHostController
) {



    Box(
        contentAlignment = Alignment.Center,
    ) {
        Column(
            modifier = Modifier
        ) {
            Row() {
                val config = LocalConfiguration.current
                LazyVerticalGrid(
                    cells = GridCells.Fixed(2),
                    contentPadding = PaddingValues(8.dp),
                    content = {
                        itemsIndexed(restaurants) { idx, restaurant ->

                            val painter = rememberImagePainter(
                                data = restaurant.picUrl,
                                builder = {
                                    placeholder(R.mipmap.sniper_monkey_foreground)
                                }
                            )

                            Box(
                                contentAlignment = Alignment.Center,
                            ) {
                                Column(
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Log.d("TAG", restaurant.name)
                                    Card(
                                        shape = RoundedCornerShape(5.dp),
                                        elevation = 16.dp,
                                        modifier = Modifier
                                            .padding(
                                                start = 8.dp,
                                                end = 8.dp,
                                                top = 5.dp,
                                                bottom = 5.dp
                                            )
                                            .size(200.dp)
                                            .clickable {
                                                onSelectRest(restaurant)
                                                nav.navigate(Routes.RestProfile.route)
                                            }
                                            .fillMaxWidth()
                                    ) {
                                        Text(restaurant.name)
                                        Image(
                                            modifier = Modifier
                                                .size(200.dp),
                                            painter = painter,
                                            contentDescription = "Full picture",
                                            alignment = Alignment.Center
                                        )
                                        Spacer(modifier = Modifier.height(8.dp))
                                        Text(restaurant.distance.toString())
                                    }
                                }
                            }
                        }
                    })
            }
        }
    }
}

