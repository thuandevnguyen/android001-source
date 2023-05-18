package com.example.demobuoi4

import android.Manifest
import android.content.ComponentName
import android.content.ContentValues
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.provider.ContactsContract
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.database.getIntOrNull
import androidx.core.database.getStringOrNull
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
    private val myContentObserver = MyContentObserver {
        val cursor = contentResolver.query(
            /* uri = */ StudentsProvider.CONTENT_URI,
            /* projection = */ arrayOf(DatabaseHelper.COLUMN_ID, DatabaseHelper.COLUMN_NAME, DatabaseHelper.COLUMN_AGE),
            /* selection = */  null,
            /* selectionArgs = */null,
            /* sortOrder = */ "${DatabaseHelper.COLUMN_ID} ASC"
        )

        cursor?.use {
            val s = StringBuilder()

            if (it.count > 0) {
                while (it.moveToNext()) {
                    val id = it.getStringOrNull(it.getColumnIndex(DatabaseHelper.COLUMN_ID))
                    val name = it.getStringOrNull(it.getColumnIndex(DatabaseHelper.COLUMN_NAME))
                    val age = it.getIntOrNull(it.getColumnIndex(DatabaseHelper.COLUMN_AGE))
                    s.append("id=$id, name=$name, age=$age\n")
                }
            }

            Log.d(TAG, s.toString())
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

            //            resultLauncherActivityRequestPermission.launch(Manifest.permission.RECEIVE_SMS)
            contactsPermissionLauncher.launch(Manifest.permission.READ_CONTACTS)
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

        var index = 0
        binding.button3.setOnClickListener {
            helloBoundService?.getData()
            contentResolver.insert(
                StudentsProvider.CONTENT_URI,
                ContentValues().apply {
                    put(DatabaseHelper.COLUMN_NAME, "Hoc $index++")
                    put(DatabaseHelper.COLUMN_AGE, 25)
                }
            )
        }

        contentResolver.registerContentObserver(
            StudentsProvider.CONTENT_URI,
            true,
            myContentObserver
        )

        // su dung o app khac
        //        contentResolver.insert(
        //            Uri.parse("content://com.example.demobuoi4.provider/students"),
        //            ContentValues().apply {
        //                put("name", "Hoc $index++")
        //                put("age", 25)
        //            }
        //        )
    }

    private fun readContacts() {
        val cursor = contentResolver.query(
            /* uri = */ ContactsContract.Contacts.CONTENT_URI,
            /* projection = */ arrayOf(ContactsContract.Contacts._ID, ContactsContract.Contacts.DISPLAY_NAME),
            /* selection = */ "${ContactsContract.Contacts.DISPLAY_NAME} LIKE ?",
            /* selectionArgs = */ arrayOf("A%"),
            /* sortOrder = */ "${ContactsContract.Contacts.DISPLAY_NAME} ASC"
        )

        cursor?.use {
            val s = StringBuilder()

            if (it.count > 0) {
                while (it.moveToNext()) {
                    val id = it.getStringOrNull(it.getColumnIndex(ContactsContract.Contacts._ID))
                    val name = it.getStringOrNull(it.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
                    s.append("id=$id, name=$name\n")
                }
            }

            binding.textViewContacts.text = s
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

    private var contactsPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { result ->
            if (result) {
                readContacts()
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