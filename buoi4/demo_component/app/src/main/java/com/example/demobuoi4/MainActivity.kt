package com.example.demobuoi4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.demobuoi4.SecondActivity.Companion.RESULT_HELLO
import com.example.demobuoi4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var count = 0

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(TAG, "onCreate")
//        findViewById<TextView>(R.id.tvIncrement).setOnClickListener {
//            count++
//            updateCounter()
//        }
        binding.tvIncrement.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            val data = "Hello Second Activity 1234"
            val bundle = Bundle()
            bundle.putString("Hello",data)
            intent.putExtras(bundle)
            resultLauncherActivity.launch(intent)
        }
    }

    private var resultLauncherActivity =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_HELLO) {
                val dataReceive = result.data
                val resultData = dataReceive?.getStringExtra("result")
                Toast.makeText(this, resultData, Toast.LENGTH_LONG).show()
            }
        }

    private fun updateCounter() {
        findViewById<TextView>(R.id.tvCount).text = count.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_COUNTER, count)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        count = savedInstanceState.getInt(KEY_COUNTER)
        updateCounter()
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    companion object {
        private const val KEY_COUNTER = "KEY_COUNTER"
        private const val TAG = "MainActivity1"
    }
}