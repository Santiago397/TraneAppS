package com.example.appfragments.main

import android.os.Bundle
import android.text.format.DateFormat
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.example.appfragments.R
import com.example.appfragments.preferences.SettingsFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_overflow, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val fm = supportFragmentManager
        val ft = fm.beginTransaction()

        return when (item.itemId) {
            R.id.menu_settings -> {
                val settingFragment = SettingsFragment()
                ft.replace(R.id.fragmentContainerView, settingFragment).commit()
                true
            }
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> {
                return true
            }
        }

    }

    fun showIcon() {
        val actionBar: ActionBar? = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

    fun hideIcon() {
        val actionBar: ActionBar? = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(false)
    }
}