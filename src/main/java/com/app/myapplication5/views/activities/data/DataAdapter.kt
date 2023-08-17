package com.app.myapplication5.views.activities.data

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.app.myapplication5.R
import com.app.myapplication5.databinding.ContentUsersItemsBinding
import com.app.myapplication5.utilities.roomdatabases.Data

class DataAdapter(private val data: List<Data>) : RecyclerView.Adapter<DataAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataAdapter.ViewHolder {

        val binding : ContentUsersItemsBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.content_users_items,
            parent,
            false)

        return ViewHolder(binding)
    }

    inner class ViewHolder (val binding: ContentUsersItemsBinding)  : RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.txtvwId.text = data.get(position).id.toString()
        holder.binding.txtvwFirstName.text = data.get(position).first_name
        holder.binding.txtvwLastName.text = data.get(position).last_name

/*        holder.binding.txtvwId.text = data.get(position).data.get(position).id.toString()
        holder.binding.txtvwFirstName.text = data.get(position).data.get(position).first_name
        holder.binding.txtvwLastName.text = data.get(position).data.get(position).last_name*/

    }

    override fun getItemCount(): Int {
        return data.size
    }

}