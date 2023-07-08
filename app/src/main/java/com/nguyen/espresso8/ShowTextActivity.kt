package com.nguyen.espresso8

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * A simple [Activity] that shows a message.
 */
class ShowTextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_text)

        // Show message.
        findViewById<TextView>(R.id.show_text_view).text = intent.getStringExtra(KEY_EXTRA_MESSAGE) ?: ""
    }

    companion object {
        // The name of the extra data sent through an {@link Intent}.
        const val KEY_EXTRA_MESSAGE = "com.example.android.testing.espresso.basicsample.MESSAGE"

        /**
         * Creates an [Intent] for [ShowTextActivity] with the message to be displayed.
         * @param context the [Context] where the [Intent] will be used
         * @param message a [String] with text to be displayed
         * @return an [Intent] used to start [ShowTextActivity]
         */
        fun newStartIntent(context: Context?, message: String?): Intent {
            val newIntent = Intent(context, ShowTextActivity::class.java)
            newIntent.putExtra(KEY_EXTRA_MESSAGE, message)
            return newIntent
        }
    }
}