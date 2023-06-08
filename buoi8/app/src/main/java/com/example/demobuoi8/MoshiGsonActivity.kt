package com.example.demobuoi8

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.demobuoi8.databinding.ActivityMoshiGsonBinding
import com.example.demobuoi8.model.Course
import com.example.demobuoi8.model.Student
import com.example.demobuoi8.model.buildGson
import com.example.demobuoi8.model.buildMoshi
import com.google.gson.reflect.TypeToken
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter
import org.intellij.lang.annotations.Language
import java.util.UUID
import kotlin.LazyThreadSafetyMode.NONE

@OptIn(ExperimentalStdlibApi::class)
class MoshiGsonActivity : AppCompatActivity() {
  private val binding by lazy(NONE) {
    ActivityMoshiGsonBinding.inflate(layoutInflater)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(binding.root)

    demoMoshi()
    demoGson()
  }

  private fun demoGson() {
    val gson = buildGson()

    @Language("JSON")
    val jsonString =
      """[{"id":"4f2314a8-f166-4256-84fe-27149bab9273","first_name":null,"last_name":"Kristin Miles","age":20},{"id":"c5e79118-5c4f-4ad5-a554-8a2516ae42d1","first_name":"Araceli Meyer","last_name":"Bonnie Mendez","age":21}]"""

    val studentList = gson.fromJson<List<Student>>(
      jsonString,
      object : TypeToken<List<Student>>() {}.type
    )
    binding.textView.text = "Course: ${studentList?.joinToString(separator = "\n\n------")}"
    Log.d("Main", "--> $studentList")

    studentList[0].firstName.length
  }

  private fun demoMoshi() {
    val moshi: Moshi = buildMoshi()
    val adapter = moshi.adapter<List<Student>>()

    val jsonString =
      """[{"id":"4f2314a8-f166-4256-84fe-27149bab9273","first_name":"hello","last_name":"Kristin Miles","age":20},{"id":"c5e79118-5c4f-4ad5-a554-8a2516ae42d1","first_name":"Araceli Meyer","last_name":"Bonnie Mendez","age":21}]"""

    val studentList = adapter.fromJson(jsonString)
    binding.textView.text = "Course: ${studentList?.joinToString(separator = "\n\n------")}"
    Log.d("Main", "--> $studentList")
  }
}