package com.debra.yapechallenge.di

import android.content.Context
import androidx.room.Room
import com.debra.yapechallenge.data.database.AppDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    private const val RECIPE_DATABASE_NAME = "recipe_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, AppDataBase::class.java, RECIPE_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideComicDao(db: AppDataBase) = db.getRecipeDao()
}