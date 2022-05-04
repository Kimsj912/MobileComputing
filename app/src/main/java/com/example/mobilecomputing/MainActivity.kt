package com.example.mobilecomputing

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.example.mobilecomputing.databinding.ActivityMainAlterBinding
import com.example.mobilecomputing.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

//    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainAlterBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        suppㅣortFragmentManager.beginTransaction().replace(binding.setting.id, MySettingsFragment()).commit()

    }
}