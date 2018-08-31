package com.example.woopa.sw_hackathon.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.woopa.sw_hackathon.NotifycationItem
import com.example.woopa.sw_hackathon.R

class NotifycationAdapter(val context : Context, val items : ArrayList<NotifycationItem>) : RecyclerView.Adapter<NotifycationAdapter.CustomViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_notifiy,parent,false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.noti_log_text.text = items[position].logtext
        holder.noti_log_date.text = items[position].date
        if(!items[position].warn_img_bool)
            holder.noti_warn_img.visibility = View.VISIBLE
    }

    override fun getItemCount(): Int {
       return items.size
    }

    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var noti_profile_img = itemView.findViewById<ImageView>(R.id.item_noti_profile_img)
        var noti_log_text = itemView.findViewById<TextView>(R.id.item_noti_log)
        var noti_log_date = itemView.findViewById<TextView>(R.id.item_noti_log_date)
        var noti_warn_img = itemView.findViewById<ImageView>(R.id.item_warn_img)
    }
}