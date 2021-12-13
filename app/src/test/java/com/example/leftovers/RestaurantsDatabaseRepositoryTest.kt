package com.example.leftovers

import android.app.Application
import androidx.room.Room
import com.example.leftovers.data.api.RestaurantApiComm
import com.example.leftovers.data.db.RestaurantsDatabase
import com.example.leftovers.data.impl.RestaurantsDatabaseRepository
import com.example.leftovers.model.Restaurant
import com.example.leftovers.network.IFoodFetcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test

import org.junit.Assert.*
import java.util.*

//local unit test
class RestaurantsDatabaseRepositoryTest {

//    @ExperimentalCoroutinesApi
//    @Test
//    fun addSongAddsToBeginningOfList() = runBlockingTest {
//       //  arrange
//      //  val repo = RestaurantsDatabaseRepository(app = Application())
//        val db: RestaurantsDatabase
//        val foodFetcher: IFoodFetcher
//        val repo = RestaurantApiComm(db , foodFetcher)
//        val rests = Restaurant(1, "Test Restaurant", "", 1, "test url", true)
//
//       //  act
//        db.addRestaurant(rests)
//
//      //   assert
//       // val rests = repo.getRestaurants()
//      //  assertEquals(rest.size, 21)
//        assertEquals(rests.name, "Test Rest")
//    }
}