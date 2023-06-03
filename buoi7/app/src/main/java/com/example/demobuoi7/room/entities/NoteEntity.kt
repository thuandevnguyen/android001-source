package com.example.demobuoi7.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
  tableName = "notes",
  foreignKeys = [
    ForeignKey(
      entity = UserEntity::class,
      parentColumns = ["id"],
      childColumns = ["user_id"],
      onDelete = ForeignKey.CASCADE,
      onUpdate = ForeignKey.CASCADE,
    )
  ],
  indices = [
    Index("user_id"),
  ]
)
data class NoteEntity(
  @PrimaryKey
  @ColumnInfo(name = "id")
  val id: Int,
  @ColumnInfo(name = "title")
  val title: String,
  @ColumnInfo(name = "user_id")
  val userId: Int,
)