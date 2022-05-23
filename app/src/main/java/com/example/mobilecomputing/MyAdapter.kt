package com.example.mobilecomputing

import android.system.Os.remove
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mobilecomputing.databinding.ListItemBinding

class MyAdapter(private var dataSet: MutableList<String>):RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    class MyViewHolder(val binding: ListItemBinding, var counter:Int) : RecyclerView.ViewHolder(binding.root)

    override fun getItemCount() = dataSet.size

    private var count = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        count++
        Log.d("TAG", "Viewholder Num : $count")
        return MyViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),count)
    }

    fun addItem(item:String){
        dataSet.add(item)
//        this.notifyDataSetChanged()
        // notifyItemInserted is more efficient (https://todaycode.tistory.com/55)
        this.notifyItemInserted(dataSet.size-1)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val binding = (holder as MyViewHolder).binding
        binding.itemText.text = dataSet[position]
        binding.itemRoot.setOnClickListener {
            Log.d("TAG", "position $position counter ${holder.counter} clicked")
        }
        binding.itemRoot.setOnLongClickListener {
            Log.d("TAG", "position $position long clicked")
            dataSet.removeAt(position)
//            this.notifyDataSetChanged()
            this.notifyItemRemoved(position)
            this.notifyItemRangeChanged(position, dataSet.size -position)
            true
        }
    }
}