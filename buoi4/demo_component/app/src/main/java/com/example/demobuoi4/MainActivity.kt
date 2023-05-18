package com.example.demobuoi4

import android.Manifest
import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.demobuoi4.SecondActivity.Companion.RESULT_HELLO
import com.example.demobuoi4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var count = 0

    private lateinit var binding: ActivityMainBinding

    private var helloBoundService: HelloBoundService? = null
    private var bound = false
    private val connection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            val localBinder = service as HelloBoundService.LocalBinder

            helloBoundService = localBinder.getHelloBoundService()
            bound = true
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            helloBoundService = null
            bound = false
        }
    }

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
//            val intent = Intent(this, SecondActivity::class.java)
//            val data = "Hello Second Activity 1234"
//            val bundle = Bundle()
//            bundle.putString("Hello", data)
//            intent.putExtras(bundle)
//            resultLauncherActivity.launch(intent)
            resultLauncherActivityRequestPermission.launch(Manifest.permission.RECEIVE_SMS)
        }

        binding.buttonStartService.setOnClickListener {
            ContextCompat.startForegroundService(
                this,
                Intent(this, HelloForegroundService::class.java).apply {
                    putExtra(HelloForegroundService.EXTRA_ACTION_KEY, "START")
                }
            )
        }

        binding.buttonStopService.setOnClickListener {
            stopService(Intent(this, HelloForegroundService::class.java))
        }

        binding.button3.setOnClickListener {
            helloBoundService?.getData()
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
    private var resultLauncherActivityRequestPermission =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { result ->
            if (result) {
                Toast.makeText(this, "Da co quyen", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Chua co quyen", Toast.LENGTH_LONG).show()
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

        val boundIntent = Intent(this, HelloBoundService::class.java)
        bindService(
            /* service = */ boundIntent,
            /* conn = */ connection,
            /* flags = */ 0
        )
        startService(boundIntent)
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

        if (bound) {
            unbindService(connection)
            bound = false
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")

        stopService(Intent(this, HelloBoundService::class.java))
    }

    companion object {
        private const val KEY_COUNTER = "KEY_COUNTER"
        private const val TAG = "MainActivity1"
    }
}