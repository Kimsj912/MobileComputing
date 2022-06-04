package com.example.mobilecomputing

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobilecomputing.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val dbHelper = MyDatabase.MyDbHelper(this)
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
                put(MyDatabase.MyDBContract.MyEntry.c1, entry.c1)
                put(MyDatabase.MyDBContract.MyEntry.c2, entry.c2)
                put(MyDatabase.MyDBContract.MyEntry.c3, entry.c3)
                put(MyDatabase.MyDBContract.MyEntry.c4, entry.c4)
                put(MyDatabase.MyDBContract.MyEntry.c5, entry.c5)
            }
            Log.d("TAG", values.toString())
            val newRowId = db?.insert(MyDatabase.MyDBContract.MyEntry.TABLE_NAME, null, values)
            Log.d("TAG", newRowId.toString())
        }
        val getList = selectAll()
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
                put(MyDatabase.MyDBContract.MyEntry.c1, elem.c1)
                put(MyDatabase.MyDBContract.MyEntry.c2, elem.c2)
                put(MyDatabase.MyDBContract.MyEntry.c3, elem.c3)
                put(MyDatabase.MyDBContract.MyEntry.c4, elem.c4)
                put(MyDatabase.MyDBContract.MyEntry.c5, elem.c5)
            }
            Log.d("TAG", values.toString())
            val newRowId = db?.insert(MyDatabase.MyDBContract.MyEntry.TABLE_NAME, null, values)
            Log.d("TAG", newRowId.toString())
            val newList = selectAll()
            adapter.setList(newList)
            adapter.notifyDataSetChanged()
            db.close()
        }
    }
    fun selectAll(): kotlin.collections.MutableList<MyElement> {
        val readList = mutableListOf<MyElement>()
        val db = dbHelper.readableDatabase
        val cursor = db.rawQuery(
            "SELECT * FROM " + MyDatabase.MyDBContract.MyEntry.TABLE_NAME + ";",
            null
        )
        with(cursor) {
            while (moveToNext()) {
                readList.add(
                    MyElement(
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5)
                    )
                )
            }
            cursor.close()
            db.close()
            return readList
        }
    }

}

