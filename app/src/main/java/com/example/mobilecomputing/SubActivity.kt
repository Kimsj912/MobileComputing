package com.example.mobilecomputing

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilecomputing.databinding.SubActivityBinding

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = SubActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        (intent.getIntExtra("num", 0).toString()+" / "+intent.getStringExtra("next")+"/"+intent.data).also {
            binding.txtView1.text = it
        }
        binding.txtView2.text = intent.getStringExtra("edit")

        binding.btn1.setOnClickListener{
            intent.putExtra("res","이것")
        }
        binding.btn2.setOnClickListener{
            intent.putExtra("res","저것")
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        setResult(RESULT_OK, intent)
        finish()
        return true
    }
}