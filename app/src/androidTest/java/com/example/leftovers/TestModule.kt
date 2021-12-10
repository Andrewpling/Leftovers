package com.example.leftovers

import android.app.Application
import com.example.leftovers.data.IRestaurantRepository
import com.example.leftovers.di.RestModule
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.testing.TestInstallIn


@Module
@TestInstallIn(
    components = [ViewModelComponent::class],
    replaces = [RestModule::class]
)
class TestModule {

   // @Provides
//    fun provideRestaurantRepository(): IRestaurantRepository {
//        return RestaurantMemoryRepository()
//    }
}