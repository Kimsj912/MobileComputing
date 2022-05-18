package com.example.mobilecomputing

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobilecomputing.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var str = "Man with all his noble qualities...with his godlike intellect\n" +
                "which has penetrated into the movements and constitution\n" +
                "of the solar system...still bears in his bodily frame the indelible\n" +
                "stamp of his lowly origin."
        val dataSet: List<String> = str.split(' ')
        binding.recyclerView.layoutManager = LinearLayoutManager (this)
        var adapter = MyAdapter(dataSet as MutableList<String>)
        binding.recyclerView.adapter = adapter

        binding.addBtn.setOnClickListener{
            adapter.addItem(binding.editTxt.text.toString())
        }
    }
}