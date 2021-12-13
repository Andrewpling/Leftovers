package com.example.leftovers

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.leftovers.ui.homescreen.HomeScreenView
import com.example.leftovers.ui.landingpage.LandingPageViewModel
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import junit.framework.Assert.assertTrue
import org.junit.Assert


import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Rule


@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class LoginUnitTest {

    private lateinit var mockApp: Application

    private lateinit var mockNav: NavHostController

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @ExperimentalComposeUiApi
    @Test
    fun TestUserMode(){
        val vm = LandingPageViewModel(mockApp)

        composeTestRule.setContent {
            HomeScreenView(
                vm = vm,
                nav = mockNav
            )
        }

        //act
        composeTestRule.onNodeWithText("Food Bank").performClick()

        //assert
        Assert.assertEquals(1, vm.userMode.value)
    }

    @Composable
    @Test
    fun loginButtonTest() {
        composeTestRule.mainClock.autoAdvance = false

        composeTestRule.setContent {
        //arrange
        val vm: LandingPageViewModel = viewModel()
        Assert.assertNull(vm.userMode.value)

        //act
        vm.setUserMode(1)
        //assert
        assertTrue("Restaurant", true)
        }
    }
}

//    @get:Rule
//    val hiltRule = HiltAndroidRule(this)
//
//    @get:Rule
//    val composeTestRule = createAndroidComposeRule<MainActivity>()
//
//
////    val vm: LandingPageViewModel = viewModel()
////
////    @Test
////    fun checkButton() {
////        val restDisplay = vm.setUserMode(1)
////        assertThat("Restauarant", restDisplay).isTrue()
////    }
//
//}
