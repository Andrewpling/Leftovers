package com.example.leftovers

import dagger.Module
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