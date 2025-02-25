package com.example.taskandroid.taskretrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.taskandroid.R

class RetroFitAdapter(var context: Context, val dataListAPI: MutableList<RetroFitDataClass?>)
    : RecyclerView.Adapter<RetroFitAdapter.RetroFitViewHolder>() {
    class RetroFitViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var nameRetroFit: TextView
        var companyNameRetroFit: TextView
        init {
            nameRetroFit = itemView.findViewById(R.id.nameRetroFit)
            companyNameRetroFit = itemView.findViewById(R.id.companyNameRetroFit)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetroFitViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.cardview_retrofit, parent, false)
        return RetroFitViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataListAPI.size
    }

    override fun onBindViewHolder(holder: RetroFitViewHolder, position: Int) {
        holder.nameRetroFit.text= dataListAPI[position]?.name.toString()
        holder.companyNameRetroFit.text= dataListAPI[position]?.company?.name.toString()
    }
}