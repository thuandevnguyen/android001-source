package com.example.demobuoi8.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.FromJson
import com.squareup.moshi.Json
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import com.squareup.moshi.ToJson
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.util.UUID

data class Course(
  @SerializedName("name")
  @Json(name = "name")
  val name: String,
  @SerializedName("code")
  @Json(name = "code")
  val code: UUID,
  @SerializedName("students")
  @Json(name = "students")
  val students: List<Student>,
)

data class Student(
  @SerializedName("id")
  @Json(name = "id")
  val id: UUID,
  @SerializedName("first_name")
  @Json(name = "first_name")
  val firstName: String,
  @SerializedName("last_name")
  @Json(name = "last_name")
  val lastName: String,
  @SerializedName("age")
  @Json(name = "age")
  val age: Int
)

class UuidAdapter : JsonAdapter<UUID>() {
  @FromJson
  override fun fromJson(reader: JsonReader): UUID? {
    return reader.readJsonValue()
      ?.toString()
      ?.let(UUID::fromString)
  }

  @ToJson
  override fun toJson(writer: JsonWriter, value: UUID?) {
    writer.jsonValue(value?.toString())
  }
}

fun buildMoshi(): Moshi = Moshi.Builder()
  .add(UuidAdapter())
  .addLast(KotlinJsonAdapterFactory())
  .build()

fun buildGson(): Gson = Gson()
