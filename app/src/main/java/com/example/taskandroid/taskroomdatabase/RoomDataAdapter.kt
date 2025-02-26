package com.example.taskandroid.taskroomdatabase

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.taskandroid.R

class RoomDataAdapter(
    val chatList: MutableList<ChatModel>,
    private var optionsMenuClickListener: OptionsMenuClickListener
)  //extends by defalut : RecyclerView.Adapter
    : RecyclerView.Adapter<RoomDataAdapter.RoomDataViewHolder>() {
    lateinit var context: Context

    //inner class for TaskRecyclerView Adapter
    class RoomDataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val msgInRecycleView: TextView = itemView.findViewById(R.id.msgInRecyclerView)
        val timeInRecycleView: TextView = itemView.findViewById(R.id.timeInRecyclerView)
        val msgCardView: CardView = itemView.findViewById(R.id.msgCardView)
    }

    interface OptionsMenuClickListener {
        fun onOptionsMenuClicked(position: Int, view: View)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomDataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.chat_view, parent, false)
        //to find context of the cardView
        context = parent.context
        return RoomDataViewHolder(view)
    }

    override fun getItemCount(): Int {
        return chatList.size
    }

    override fun onBindViewHolder(holder: RoomDataViewHolder, position: Int) {
        holder.msgInRecycleView.text = chatList[position].message
        holder.timeInRecycleView.text = chatList[position].time
        if (chatList[position].isChecked) {
            holder.msgCardView.setCardBackgroundColor(
                ContextCompat.getColor(
                    context,
                    R.color.black
                )
            )
            holder.timeInRecycleView.textAlignment = TextView.TEXT_ALIGNMENT_VIEW_START
            holder.msgInRecycleView.textAlignment = TextView.TEXT_ALIGNMENT_VIEW_START
        } else {
            holder.msgCardView.setCardBackgroundColor(ContextCompat.getColor(context, R.color.grey))
            holder.timeInRecycleView.textAlignment = TextView.TEXT_ALIGNMENT_VIEW_END
            holder.msgInRecycleView.textAlignment = TextView.TEXT_ALIGNMENT_VIEW_END
        }

        holder.msgCardView.setOnLongClickListener() {
            optionsMenuClickListener.onOptionsMenuClicked(holder.absoluteAdapterPosition, holder.msgCardView)
            true
        }
    }
}
