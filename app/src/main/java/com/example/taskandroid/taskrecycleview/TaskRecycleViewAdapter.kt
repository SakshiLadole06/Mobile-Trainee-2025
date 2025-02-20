package com.example.taskandroid.taskrecycleview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.taskandroid.R

class TaskRecycleViewAdapter(val chatList: MutableList<DataClassRecycleView>, private var optionsMenuClickListener: OptionsMenuClickListener)  //extends by defalut : RecyclerView.Adapter
    : RecyclerView.Adapter<TaskRecycleViewAdapter.TaskRecycleViewHolder>(){
    lateinit var context:Context

    //inner class for TaskRecyclerView Adapter
    class TaskRecycleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)  {
        val msgInRecycleView : TextView= itemView.findViewById(R.id.msgInRecyclerView)
        val timeInRecycleView :TextView = itemView.findViewById(R.id.timeInRecyclerView)
        val msgCardView:CardView=itemView.findViewById(R.id.msgCardView)
    }

    interface OptionsMenuClickListener {
        fun onOptionsMenuClicked(position: Int,view :View)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskRecycleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.chat_view, parent, false)
        //to find context of the cardView
        context = parent.context
        return TaskRecycleViewHolder(view)
    }

    override fun getItemCount(): Int {
        return chatList.size
    }

    override fun onBindViewHolder(holder: TaskRecycleViewHolder, position: Int) {
        holder.msgInRecycleView.text=chatList[position].message
        holder.timeInRecycleView.text=chatList[position].time
        if(chatList[position].isChecked){
            holder.msgCardView.setCardBackgroundColor(ContextCompat.getColor(context,R.color.black))
            holder.timeInRecycleView.textAlignment = TextView.TEXT_ALIGNMENT_VIEW_START
            holder.msgInRecycleView.textAlignment = TextView.TEXT_ALIGNMENT_VIEW_START
        }

        holder.msgCardView.setOnClickListener {
            optionsMenuClickListener.onOptionsMenuClicked(position,holder.msgCardView)
        }

    }

    //To add data in Recycler View
    fun addName(message: String,time:String,isChecked:Boolean) {
        chatList.add(DataClassRecycleView(message,time,isChecked))
        notifyItemInserted(chatList.size - 1) // Notify RecyclerView to update UI
    }
}