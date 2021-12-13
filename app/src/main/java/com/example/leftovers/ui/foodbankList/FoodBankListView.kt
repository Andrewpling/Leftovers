package com.example.leftovers.ui.foodbankList

import com.example.leftovers.ui.restaurantList.RestaurantListViewModel

import android.content.res.Configuration
import android.graphics.Paint
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.example.leftovers.R
import com.example.leftovers.model.FoodBank
import com.example.leftovers.model.Restaurant
import com.example.leftovers.ui.nav.Routes
import com.example.leftovers.ui.theme.SecondaryColor


@ExperimentalFoundationApi
@Composable
fun FoodBankListView(
    vm: FoodBankListViewModel = viewModel(),
    banks: List<FoodBank>,
    isReadyChange: (FoodBank) -> Unit,
    onSelectBank: (FoodBank) -> Unit,
    nav: NavHostController
) {
    Box(
        modifier = Modifier.background(
            color = SecondaryColor
        ),
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
                        itemsIndexed(banks) { idx, bank ->

                            val painter = rememberImagePainter(
                                data = bank.picUrl,
                                builder = {
                                    placeholder(R.mipmap.leftovers_logo_foreground)
                                }
                            )
//
//                            Box(
//                                contentAlignment = Alignment.Center,
//                            ) {
//                                Column(
//                                    modifier = Modifier.fillMaxWidth()
//                                ) {
//                                    Log.d("TAG", restaurant.name)
                            if(!bank.isAccepting) {
                                Card(
                                    contentColor = Color.Gray,
                                    backgroundColor = Color.Gray,
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
//                                        .clickable {
//                                            onSelectRest(restaurant)
//                                            nav.navigate(Routes.RestProfile.route)
//                                        }
                                        .fillMaxWidth()
                                ) {
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Text(
                                            text = bank.name,
                                            textAlign = TextAlign.Center,
                                            fontSize = 14.sp,
                                            modifier = Modifier.padding(4.dp)
                                        )
                                        Spacer(modifier = Modifier.height(8.dp))
                                        Image(
                                            contentScale = ContentScale.FillBounds,
                                            modifier = Modifier
                                                .size(125.dp),
                                            painter = painter,
                                            contentDescription = "Full picture",
                                            alignment = Alignment.Center,
                                            colorFilter = ColorFilter.tint(Color.Gray, BlendMode.Darken)
                                        )
                                        Spacer(modifier = Modifier.height(8.dp))
                                        Text(
                                            text = "Distance: ${bank.distance.toString()}mi",
                                            textAlign = TextAlign.Left,
                                            fontSize = 12.sp
                                        )
                                    }

                                }
                            }
                            else {
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
                                            onSelectBank(bank)
                                            nav.navigate(Routes.BankProfile.route)
                                        }
                                        .fillMaxWidth()
                                ) {
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Text(
                                            text = bank.name,
                                            textAlign = TextAlign.Center,
                                            fontSize = 14.sp,
                                            modifier = Modifier.padding(4.dp)
                                        )
                                        Spacer(modifier = Modifier.height(8.dp))
                                        Image(
                                            contentScale = ContentScale.FillBounds,
                                            modifier = Modifier
                                                .size(125.dp),
                                            painter = painter,
                                            contentDescription = "Full picture",
                                            alignment = Alignment.Center
                                        )
                                        Spacer(modifier = Modifier.height(8.dp))
                                        Text(
                                            text = "Distance: ${bank.distance.toString()}mi",
                                            textAlign = TextAlign.Left,
                                            fontSize = 12.sp
                                        )
                                    }
                                }
                            }
                        }
                    })
            }
        }
    }
}

