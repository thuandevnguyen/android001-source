package com.example.demobuoi7.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.demobuoi7.room.daos.NoteDao
import com.example.demobuoi7.room.daos.UserDao
import com.example.demobuoi7.room.entities.NoteEntity
import com.example.demobuoi7.room.entities.UserEntity

@Database(
  entities = [
    NoteEntity::class,
    UserEntity::class,
  ],
  version = 1,
  exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
  abstract fun noteDao(): NoteDao
  abstract fun userDao(): UserDao

  companion object {
    @Volatile
    private var instance: AppDatabase? = null

    // Double-check singleton pattern
    fun getInstance(context: Context): AppDatabase {
      return instance ?: synchronized(this) {
        instance ?: buildDb(context.applicationContext).also { instance = it }
      }
    }

    private const val DB_NAME = "demo_buoi7.db"
    private fun buildDb(context: Context): AppDatabase = Room.databaseBuilder(
      context = context,
      klass = AppDatabase::class.java,
      name = DB_NAME
    ).build()
  }
}