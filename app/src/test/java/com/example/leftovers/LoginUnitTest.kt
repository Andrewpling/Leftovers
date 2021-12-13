package com.example.leftovers

<<<<<<< HEAD
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.leftovers.ui.landingpage.LandingPageViewModel
=======
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
>>>>>>> 974b003661bd4e2c8c26b8f6567905ba07d39285
import junit.framework.Assert.assertTrue
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit
import org.mockito.runners.MockitoJUnitRunner



<<<<<<< HEAD

class LoginUnitTest {
//    @get:Rule
//    val hiltRule = HiltAndroidRule(this)
=======
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


>>>>>>> 974b003661bd4e2c8c26b8f6567905ba07d39285
//
//    @get:Rule
//    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Composable
    @Test
    fun loginButtonTest() {
//        composeTestRule.mainClock.autoAdvance = false
//
//        composeTestRule.setContent {
            //arrange
            val vm: LandingPageViewModel = viewModel()
            Assert.assertNull(vm.userMode.value)

            //act
            vm.setUserMode(1)
            //assert
            assertTrue("Restaurant", true)
        //}
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
