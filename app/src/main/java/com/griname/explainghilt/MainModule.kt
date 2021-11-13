package com.griname.explainghilt

import android.content.Context
import androidx.room.Room
import com.griname.explainghilt.data.UserDao
import com.griname.explainghilt.data.UserDatabase
import com.griname.explainghilt.data.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainModule {

    @Singleton
    @Provides
    fun provideUserDatabase(@ApplicationContext context: Context): UserDatabase {
        return Room.databaseBuilder(
            context,
            UserDatabase::class.java,
            UserDatabase.DATABASE_NAME
        ).build()
    }

    @Singleton
    @Provides
    fun provideUserDao(userDatabase: UserDatabase): UserDao {
        return userDatabase.getUserDao()
    }

    @Singleton
    @Provides
    fun provideRepository(userDao: UserDao) : UserRepository {
        return UserRepository(userDao)
    }
}