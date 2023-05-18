package com.example.demobuoi4

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import java.lang.Exception

class SmsReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val bundles = intent?.extras

        try {
            bundles?.let {
                val extraMessage = Telephony.Sms.Intents.getMessagesFromIntent(intent)

                extraMessage.forEach { smsMessage ->
                    val secondActivityIntent = Intent(context, SecondActivity::class.java).apply {
                        flags = Intent.FLAG_ACTIVITY_NEW_TASK
                        putExtra(CONTENT_MESSAGE, smsMessage.displayMessageBody)
                        putExtra(NUMBER_PHONE, smsMessage.displayOriginatingAddress)
                    }
                    context?.startActivity(secondActivityIntent)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    companion object {
        const val NUMBER_PHONE = "NUMBER_PHONE"
        const val CONTENT_MESSAGE = "CONTENT_MESSAGE"
    }

}