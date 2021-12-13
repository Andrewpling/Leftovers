package com.example.leftovers

import android.app.Application
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.test.internal.runner.junit3.AndroidJUnit3Builder
import androidx.test.runner.AndroidJUnit4
import com.example.leftovers.ui.homescreen.HomeScreenView
import com.example.leftovers.ui.landingpage.LandingPageViewModel
import com.example.leftovers.ui.nav.Routes
import com.google.errorprone.annotations.DoNotMock
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit
import org.mockito.runners.MockitoJUnitRunner



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
