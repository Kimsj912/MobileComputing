package com.example.mobilecomputing

import android.content.Context
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.edit
import com.example.mobilecomputing.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = getPreferences(Context.MODE_PRIVATE)
        val sharedPref2 = getSharedPreferences("pref_test1", Context.MODE_PRIVATE)

        sharedPref.edit(){
            putBoolean("hi", true)
            putString("Store", "Emart everyday")
            putInt("Number", 10)
            apply()
        }
        sharedPref2.edit(){
            putBoolean("hi", false)
            putString("Store", "Daiso everyday")
            putInt("Number", 5)
            apply()
        }

        sharedPref.getString("Store","?")?.let{Log.d("Debug", it)}
        sharedPref2.getString("Store","?")?.let{Log.d("Debug", it)}
    }
}