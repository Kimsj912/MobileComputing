package com.example.mobilecomputing

import android.system.Os.remove
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mobilecomputing.databinding.ListItemBinding

class MyAdapter(private var dataSet: MutableList<MyElement>):RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    class MyViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)
    override fun getItemCount() = dataSet.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }
    fun setList(newList: MutableList<MyElement>){
        this.dataSet = newList
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val binding = (holder as MyViewHolder).binding
        binding.title.text = dataSet[position].c1
        binding.date.text = dataSet[position].c2
        binding.loc.text = dataSet[position].c3
        binding.who.text = dataSet[position].c4
        binding.go.text = dataSet[position].c5
    }
}