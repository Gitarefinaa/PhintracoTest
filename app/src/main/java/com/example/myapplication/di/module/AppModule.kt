package com.example.myapplication.di.module
import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.myapplication.PokemonApp
import com.example.myapplication.database.pokemonDao
import com.example.myapplication.database.pokemonDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    @Singleton
    fun provideDatabaseDao(db: pokemonDatabase): pokemonDao {
        return db.pokemonDao()
    }

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): pokemonDatabase {
        return Room.databaseBuilder(
            context,
            pokemonDatabase::class.java,
            pokemonDatabase.DATABASE_NAME,
        ).fallbackToDestructiveMigration()
            .build()


    }
}