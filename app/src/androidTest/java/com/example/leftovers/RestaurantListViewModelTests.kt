package com.example.leftovers

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import com.example.leftovers.ui.restaurantList.RestaurantListViewModel
import com.example.leftovers.model.Restaurant
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import java.util.*

@HiltAndroidTest
class RestaurantListViewModelTests {
    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun TestSelectRestaurant() {
        composeTestRule.mainClock.autoAdvance = false

        composeTestRule.setContent {
            // arrange
            val vm: RestaurantListViewModel = viewModel()
            Assert.assertNull(vm.selectedRest.value)
            val rest = Restaurant(1, "name", "Baltimore", 3, "",true )

            // act
            vm.selectRest(rest)

            // assert
            Assert.assertEquals("TestRest", vm.selectedRest.value?.name)
        }
    }
}