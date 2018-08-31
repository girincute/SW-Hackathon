package com.example.woopa.sw_hackathon.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.woopa.sw_hackathon.ChildViewDetailItem
import com.example.woopa.sw_hackathon.R
import org.w3c.dom.Text

class ChildViewDetailAdapter(val item : ArrayList<ChildViewDetailItem>, val context : Context) : RecyclerView.Adapter<ChildViewDetailAdapter.ViewBinder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewBinder {
        val layoutId = when(viewType){
             0 -> R.layout.item_childview_number_with_address
             1 -> R.layout.item_childviewdetail_cal_text
             2 -> R.layout.item_childviewdetail_calender
            else -> 2
        }
        val view = LayoutInflater.from(parent.context).inflate(layoutId,parent,false)
        return getViewHolder(viewType, view)
    }

    override fun onBindViewHolder(holder: ViewBinder, position: Int) = holder.bind(item[position])

    override fun getItemCount(): Int {
        return item.size
    }

    override fun getItemViewType(position: Int): Int = item[position].viewtype

    abstract class ViewBinder(itemView: View): RecyclerView.ViewHolder(itemView){
        abstract fun bind(item: ChildViewDetailItem)
    }


    class FirstViewHolder(itemView: View) : ViewBinder(itemView){
        override fun bind(item: ChildViewDetailItem) {
            number.text = item.text1
            address.text = item.text2
        }

        var number = itemView.findViewById<TextView>(R.id.item_childview_number_text)
        var address = itemView.findViewById<TextView>(R.id.item_childview_address_text)
    }

    class SecondViewHolder(itemView : View) : ViewBinder(itemView){
        override fun bind(item: ChildViewDetailItem) {

        }

    }

    class ThirdViewHolder(itemView: View) : ViewBinder(itemView) {
        override fun bind(item: ChildViewDetailItem) {
            date.text = item.text1
            address.text = item.text2
        }
        var date = itemView.findViewById<TextView>(R.id.item_childview_cal_date_text)
        var address = itemView.findViewById<TextView>(R.id.item_childview_cal_address_text)
    }

    fun getViewHolder(viewType: Int, itemView: View): ViewBinder{
        return when(viewType){
            0 -> FirstViewHolder(itemView)
            1 -> SecondViewHolder(itemView)
            2 -> ThirdViewHolder(itemView)
            else -> ThirdViewHolder(itemView)
        }
    }
}