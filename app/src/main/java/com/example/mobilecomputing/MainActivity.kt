package com.example.mobilecomputing

import android.content.ContentValues
import android.database.sqlite.SQLiteConstraintException
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobilecomputing.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val dbHelper = MyDbHelper.MyDbHelper(this)
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var db = dbHelper.writableDatabase
        val entryArr = mutableListOf(
            MyElement("뷰만리", "5/14", "올림픽 공원", "데이브레이크/멜로망스", "못감"),
            MyElement("오히려 좋아", "6/11", "올림픽 공원", "치즈/윤딴딴", "채점해야지"),
            MyElement("피크", "5/28", "난지한강공원", "국카스텐/넬", "문제내야지")
        )
        for (entry in entryArr) {
            val values = ContentValues().apply {
                put(MyDbHelper.MyDbHelper.MyEntry.c1, entry.c1)
                put(MyDbHelper.MyDbHelper.MyEntry.c2, entry.c2)
                put(MyDbHelper.MyDbHelper.MyEntry.c3, entry.c3)
                put(MyDbHelper.MyDbHelper.MyEntry.c4, entry.c4)
                put(MyDbHelper.MyDbHelper.MyEntry.c5, entry.c5)
            }
            Log.d("TAG", values.toString())
            val newRowId = db?.insert(MyDbHelper.MyDbHelper.MyEntry.TABLE_NAME, null, values)
            Log.d("TAG", newRowId.toString())
        }
        val getList = dbHelper.selectAll()
        val adapter = MyAdapter(getList)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
        binding.submit.setOnClickListener{
            db = dbHelper.writableDatabase
            val elem = MyElement(
                binding.name.text.toString(),
                binding.date.text.toString(),
                binding.loc.text.toString(),
                binding.who.text.toString(),
                binding.go.text.toString(),
            )
            val values = ContentValues().apply{
                put(MyDbHelper.MyDbHelper.MyEntry.c1, elem.c1)
                put(MyDbHelper.MyDbHelper.MyEntry.c2, elem.c2)
                put(MyDbHelper.MyDbHelper.MyEntry.c3, elem.c3)
                put(MyDbHelper.MyDbHelper.MyEntry.c4, elem.c4)
                put(MyDbHelper.MyDbHelper.MyEntry.c5, elem.c5)
            }
            Log.d("TAG", values.toString())
            try{
                val newRowId = db?.insertOrThrow(MyDbHelper.MyDbHelper.MyEntry.TABLE_NAME, null, values)
                Log.d("TAG", newRowId.toString())
            } catch (e: SQLiteConstraintException){
                db?.update(MyDbHelper.MyDbHelper.MyEntry.TABLE_NAME, values, "${MyDbHelper.MyDbHelper.MyEntry.c1} LIKE ?", arrayOf(elem.c1))
            }
            val newList = dbHelper.selectAll()
            adapter.setList(newList)
            adapter.notifyDataSetChanged()
            db.close()
        }
        adapter.setItemClickListener(object: MyAdapter.OnItemClickListener{
            override fun onClick(v: View, position: Int) {
                db = dbHelper.writableDatabase
                db?.delete(MyDbHelper.MyDbHelper.MyEntry.TABLE_NAME, "${MyDbHelper.MyDbHelper.MyEntry.c1} = ?", arrayOf(adapter.getElement(position).c1))
                val newList = dbHelper.selectAll()
                Toast.makeText(applicationContext,"${adapter.getElement(position).c1} is deleted", Toast.LENGTH_SHORT).show()
                adapter.setList(newList)
                adapter.notifyDataSetChanged()
            }
        })
    }

}

