package com.example.demobuoi4

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.demobuoi4.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val message = intent.getStringExtra("message")

        val bundleReceive = intent.extras
        val datas = bundleReceive?.getString("Hello")
        binding.tvContent.text = datas

        binding.closeActivity.setOnClickListener {
            val data = "Result from Activity 2"
            val resultIntent = Intent()
            resultIntent.putExtra("result", data)
            setResult(RESULT_HELLO, resultIntent)
            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("SecondActivity1","onDestroy")
    }
    companion object {
        const val RESULT_HELLO = 12312321
    }
}