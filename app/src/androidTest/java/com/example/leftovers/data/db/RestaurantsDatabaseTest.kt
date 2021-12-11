package com.example.leftovers.data.db

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.leftovers.model.Restaurant
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
//import com.google.common.truth.Truth.assertThat

@RunWith(AndroidJUnit4::class)
class RestaurantsDatabaseTest : TestCase() {

    private lateinit var db: RestaurantsDatabase
    private lateinit var dao: RestaurantsDao

    @Before
    public override fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, RestaurantsDatabase::class.java).build()
        dao = db.restaurantDao()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun writeAndReadRest() = runBlocking{

        val rest = Restaurant(1, "test rest", "test loc", 2, "test url", true)
        dao.addRestaurant(rest)
        val rests = dao.getRestaurants()
      //  assertThat(rests.contains(rest)).isTrue()
        assertEquals(rests, rest)

    }
}