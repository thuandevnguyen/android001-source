package com.example.demobuoi7.room.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Embedded
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Relation
import androidx.room.Transaction
import androidx.room.Update
import com.example.demobuoi7.room.entities.NoteEntity
import com.example.demobuoi7.room.entities.UserEntity

data class UserAndNotes(
  @Embedded
  val user: UserEntity,
  @Relation(
    parentColumn = "id",
    entityColumn = "user_id",
    entity = NoteEntity::class
  )
  val notes: List<NoteEntity>
)

@Dao
interface NoteDao {
  @Query("SELECT * FROM notes")
  fun observeAll(): LiveData<List<NoteEntity>>

  @Query("SELECT * FROM notes WHERE id = :id")
  fun observeById(id: Int): LiveData<NoteEntity?>

  @Transaction
  @Query("SELECT * FROM users WHERE id = :userId")
  fun observeAllByUserId(userId: Int): LiveData<UserAndNotes?>

  @Insert
  suspend fun insertMany(users: List<NoteEntity>)

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun insert(user: NoteEntity)

  @Update
  suspend fun update(user: NoteEntity)

  @Delete
  suspend fun delete(user: NoteEntity)
}