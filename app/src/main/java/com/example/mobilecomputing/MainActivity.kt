package com.example.mobilecomputing

import android.content.ContentValues
import android.content.Intent
import android.database.sqlite.SQLiteConstraintException
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobilecomputing.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Toast.makeText(applicationContext,"Start", Toast.LENGTH_LONG).show()
        binding.btn.setOnClickListener {
            CoroutineScope(Dispatchers.Default).launch {
                launch{
                    for (i in 1..10){
                        delay(1000)
                        withContext(Dispatchers.Main){
                            binding.count.text=i.toString()
                            Log.d("TAG","$i")
                        }
                    }
                }
            }
        }
        binding.btn2.setOnClickListener {
            Toast.makeText(applicationContext,"HiHi", Toast.LENGTH_LONG).show()
            Log.d("TAG","Button2 Clicked")

        }
    }

}

