package com.bank.demo.database
import androidx.room.Database
import androidx.room.RoomDatabase
import com.bank.demo.database.dao.UserDao
import com.bank.demo.database.entities.User

@Database(entities = arrayOf(User::class), version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
