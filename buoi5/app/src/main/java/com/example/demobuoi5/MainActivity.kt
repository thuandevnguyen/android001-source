package com.example.demobuoi5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import androidx.fragment.app.add

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<FirstFragment>(
                    containerViewId = R.id.container,
                    tag = "FirstFragment",
                    args = bundleOf(
                        "key1" to 1,
                        "key2" to "hello",
                        "key3" to arrayListOf("1", "2", "3")
                    ),
                )
            }
        }
    }
}