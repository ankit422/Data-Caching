package com.testdatacaching

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.data_view.view.*

class DataAdapter(private val context: Context, private var data: MutableList<Repo> = ArrayList()) :
    RecyclerView.Adapter<DataAdapter.DataView>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataView {
        return DataView(
            LayoutInflater.from(context).inflate(
                R.layout.data_view,
                parent,
                false
            )
        )
    }

    fun setData(data: MutableList<Repo>?) {
        this.data = data!!
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: DataView, position: Int) {
        holder.textId.text = data[position].id.toString()
        holder.textName.text = data[position].name
    }

    class DataView(view: View) : RecyclerView.ViewHolder(view) {
        val textId: TextView = view.data_id
        val textName: TextView = view.name
    }
}