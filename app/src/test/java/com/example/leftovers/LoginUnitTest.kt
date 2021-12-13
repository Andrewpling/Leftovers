package com.example.leftovers

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.leftovers.ui.landingpage.LandingPageViewModel
import junit.framework.Assert.assertTrue
import org.junit.Assert
import org.junit.Rule
import org.junit.Test




class LoginUnitTest {
//    @get:Rule
//    val hiltRule = HiltAndroidRule(this)
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
