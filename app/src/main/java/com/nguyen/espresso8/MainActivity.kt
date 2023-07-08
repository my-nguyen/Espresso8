package com.nguyen.espresso8

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.nguyen.espresso8.databinding.ActivityMainBinding

/**
 * An [Activity] that gets a text string from the user and displays it back when the user
 * clicks on one of the two buttons. The first one shows it in the same activity and the second
 * one opens another activity and displays the message.
 */
class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        // Set the listeners for the buttons.
        binding.changeTextBt.setOnClickListener(this)
        binding.activityChangeTextBtn.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        // Get the text from the EditText view.
        val text = binding.editTextUserInput.text.toString()
        when (view.id) {
            R.id.changeTextBt -> binding.textToBeChanged.text = text
            R.id.activityChangeTextBtn -> startActivity(ShowTextActivity.newStartIntent(this, text))
        }
    }
}