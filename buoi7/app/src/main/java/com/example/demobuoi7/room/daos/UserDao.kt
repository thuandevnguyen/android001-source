package com.example.demobuoi7.room.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.demobuoi7.room.entities.UserEntity

@Dao
interface UserDao {
  @Query("SELECT * FROM users")
  fun observeAll(): LiveData<List<UserEntity>>

  @Query("SELECT * FROM users WHERE id = :id")
  fun observeById(id: Int): LiveData<UserEntity?>

  @Insert
  suspend fun insertMany(users: List<UserEntity>)

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insert(user: UserEntity)

  @Update
  suspend fun update(user: UserEntity)

  @Delete
  suspend fun delete(user: UserEntity)
}