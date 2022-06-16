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
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val requestGalleryLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()){
            try{
                Log.d("TAG","$it")
                Log.d("TAG","${it.data!!}")
                Log.d("TAG","${it.data!!.data!!}")

                val inputStream = contentResolver.openInputStream(it.data!!.data!!)
                val bitmap = BitmapFactory.decodeStream(inputStream,null,null)
                inputStream?.close()
                if(bitmap!=null){
                    binding.imageView.setImageBitmap(bitmap)
                }else{
                    Log.d("TAG","null")
                }
            }catch (e:Exception){
                e.printStackTrace()
            }
        }
        binding.btnGal.setOnClickListener{
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            requestGalleryLauncher.launch(intent)
        }
        binding.btnReset.setOnClickListener{
            binding.imageView.setImageResource(R.drawable.ic_launcher_background)
        }
    }

}

