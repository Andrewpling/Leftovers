package com.example.leftovers

import android.app.Application
import com.example.leftovers.data.IBankRepository
import com.example.leftovers.data.api.BankApiComm
import com.example.leftovers.data.impl.BanksDatabaseRepository
import com.example.leftovers.network.FoodFetcher
import com.example.leftovers.network.IFoodFetcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class TestAppModule {

    @Provides
    fun provideFoodsRepository(
        db: BanksDatabaseRepository,
        foodsFetcher: IFoodFetcher
    ): IBankRepository {
        return BankApiComm(db, foodsFetcher)
    }

    @Provides
    fun provideFoodsFetcher(
        app: Application
    ): IFoodFetcher {
        return FoodFetcher(app)
    }
}