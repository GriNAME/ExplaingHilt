package com.griname.explainghilt.data

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {

    fun getAllData(): LiveData<List<User>> {
        return userDao.getAllData()
    }

    suspend fun insertUser(user: User) {
        userDao.insertUser(user)
    }
}