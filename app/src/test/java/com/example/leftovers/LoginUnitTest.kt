package com.example.leftovers

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.leftovers.ui.landingpage.LandingPageViewModel
import com.example.leftovers.ui.nav.Routes
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.junit.Assert
import org.junit.Rule
import org.junit.Test



@HiltAndroidTest
class LoginUnitTest {
    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()
//
//    @Test
//    fun loginButtonTest() {
//        composeTestRule.mainClock.autoAdvance = false
//
//        composeTestRule.setContent {
//            //arrange
//            val vm: LandingPageViewModel = viewModel()
//            Assert.assertNull(vm.userMode.value)
//
//            //act
//            vm.setUserMode(1)
//           // val click = vm.onClick()
//            //assert
//            //assertTrue(vm.userMode.value?.name, "Restaurant")
//        }
   // }
}
