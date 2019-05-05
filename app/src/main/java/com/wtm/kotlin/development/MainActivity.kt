package com.wtm.kotlin.development

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*
import java.text.DateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        supportActionBar?.title = "Kotlin Development"
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    fun showToast(view: View) {
        val toast = Toast.makeText(this, "Showing a Toast", Toast.LENGTH_SHORT)
        toast.show()
    }

    fun countForMe(view: View) {
        val mainTextView = findViewById<TextView>(R.id.textView)
        val countInString = mainTextView.text.toString()
        var countInNo = Integer.parseInt(countInString)
        countInNo += 1
        mainTextView.text = countInNo.toString()


    }

    fun showDate(view: View) {
        val date = Calendar.getInstance().time
        val formatteddate = DateFormat.getInstance().format(date)
        val mainTextView = findViewById<TextView>(R.id.textView)
        mainTextView.text = formatteddate.toString()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
