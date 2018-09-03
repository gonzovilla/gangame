package com.cyclopsdev.commons

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class DataBindingRecyclerAdapter<MODEL>(val itemVariableId: Int,
                                        val itemLayoutResId: Int) : RecyclerView.Adapter<DataBindingViewHolder<MODEL>>() {

    val items = mutableListOf<MODEL>()

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBindingViewHolder<MODEL> {
        val binding: ViewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                itemLayoutResId,
                parent,
                false)

        return DataBindingViewHolder(itemVariableId, binding)
    }

    override fun onBindViewHolder(holder: DataBindingViewHolder<MODEL>, position: Int) {
        val item = items[position]
        holder.bindItem(item)
    }
}