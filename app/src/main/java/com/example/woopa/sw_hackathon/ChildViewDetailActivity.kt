package com.example.woopa.sw_hackathon

import android.app.Dialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.CalendarView
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.example.woopa.sw_hackathon.Adapter.ChildViewDetailAdapter
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import kotlinx.android.synthetic.main.activity_childviewdetail.*

class ChildViewDetailActivity : AppCompatActivity(),OnMapReadyCallback {
    override fun onMapReady(p0: GoogleMap?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_childviewdetail)

        var flag = false;


            childviewdetail_calender_fab.hide()
            childviewdetail_place_fab.hide()


        var data = arrayListOf<ChildViewDetailItem>()
                .apply { add(ChildViewDetailItem("010-1234-5678","대전광역시 유성구 가정북로 76\n" +
                        "(대덕소프트웨어마이스터고등학교 우정관)",0))
                        add(ChildViewDetailItem(" ", " ",1))
                        add(ChildViewDetailItem("2018.08.31","대전광역시 유성구 가정북로 76\n" +
                                "(대덕소프트웨어마이스터고등학교 우정관)",2))
                        add(ChildViewDetailItem("2018.08.31","대전광역시 유성구 가정북로 76\n" +
                                "(대덕소프트웨어마이스터고등학교 우정관)",2))}

        var adapter = ChildViewDetailAdapter(data,this@ChildViewDetailActivity)

        childviewdetail_recycler.adapter = adapter

        val main_anim1 = AnimationUtils.loadAnimation(baseContext,R.anim.main_fab_anim1)
        val main_anim2 = AnimationUtils.loadAnimation(baseContext,R.anim.main_fab_anim2)

        childviewdetail_main_fab.setOnClickListener {
            if(!flag){
                flag = true
                childviewdetail_main_fab.startAnimation(main_anim1)
                childviewdetail_calender_fab.show()
                childviewdetail_place_fab.show()
                childviewdetail_calender_text.visibility = View.VISIBLE
                childviewdetail_place_text.visibility = View.VISIBLE
                childviewdetail_background.visibility = View.VISIBLE

            } else {
                flag = false
                childviewdetail_main_fab.startAnimation(main_anim2)
                childviewdetail_calender_fab.hide()
                childviewdetail_place_fab.hide()
                childviewdetail_calender_text.visibility = View.INVISIBLE
                childviewdetail_place_text.visibility = View.INVISIBLE
                childviewdetail_background.visibility = View.INVISIBLE
            }
        }

        childviewdetail_calender_fab.setOnClickListener {
            val dialog_calender = Dialog(this)
            dialog_calender.setContentView(R.layout.dialog_calendar)

            val next_btn = dialog_calender.findViewById<TextView>(R.id.dialog_calendar_next_btn)
            val cancel_btn = dialog_calender.findViewById<TextView>(R.id.dialog_calendar_cancel_btn)
            val calendar = dialog_calender.findViewById<CalendarView>(R.id.dialog_calendar_view)
            val cal_year = dialog_calender.findViewById<TextView>(R.id.dialog_calendar_year)
            val month_with_day = dialog_calender.findViewById<TextView>(R.id.dialog_calendar_month_with_day)

            dialog_calender.show()

            calendar.setOnDateChangeListener(object : CalendarView.OnDateChangeListener{
                override fun onSelectedDayChange(p0: CalendarView?, year : Int, month: Int, day: Int) {
                    cal_year.text = year.toString()
                    month_with_day.text = month.toString() + "월 " + day.toString() + "일"
                }
            })

            var window = dialog_calender.window
                    .apply { setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT) }

            next_btn.setOnClickListener {
                val dialog_map = Dialog(this@ChildViewDetailActivity)
                dialog_map.setContentView(R.layout.dialog_map)

                val next_btn = dialog_map.findViewById<TextView>(R.id.dialog_map_next_btn)
                val cancel_btn = dialog_map.findViewById<TextView>(R.id.dialog_map_cancel_btn)
                val search_et = dialog_map.findViewById<EditText>(R.id.dialog_map_search_et)
                val search_reset_btn = dialog_map.findViewById<ImageView>(R.id.dialog_map_search_reset)

                dialog_map.show()

                next_btn.setOnClickListener {  }

                cancel_btn.setOnClickListener { v -> dialog_map.dismiss() }

                search_reset_btn.setOnClickListener { v -> search_et.setText(" ") }


                var window = dialog_map.window
                        .apply { setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT) }

                dialog_map.setCanceledOnTouchOutside(true)

            }
            cancel_btn.setOnClickListener { v -> dialog_calender.dismiss() }

            dialog_calender.setCanceledOnTouchOutside(true)
        }




    }
}