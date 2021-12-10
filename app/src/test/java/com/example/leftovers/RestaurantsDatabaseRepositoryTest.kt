package com.example.leftovers

import com.example.leftovers.data.impl.RestaurantsDatabaseRepository
import com.example.leftovers.model.Restaurant
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test

import org.junit.Assert.*
import java.util.*

//local unit test
class RestaurantsDatabaseRepositoryTest {
    @ExperimentalCoroutinesApi
    @Test
    fun restaurantRepositoryInitializedWithARest() = runBlockingTest {
        // arrange

        val repo = RestaurantsDatabaseRepository(app)

        // act
        val rests = repo.getRestaurants()

        // assert
        assertEquals(rests.size, 1)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun AddSongAddsToBeginningOfList() = runBlockingTest {
        // arrange
        val repo = RestaurantsDatabaseRepository()
        val rest = Restaurant(1, "Test Restaurant", "", 1, "test url", true)

        // act
        repo.addRestaurant(rest)

        // assert
        val rests = repo.getRestaurants()
        //assertEquals(rest.size, 21)
        //assertEquals(rests.name, "Test Rest")
    }
}