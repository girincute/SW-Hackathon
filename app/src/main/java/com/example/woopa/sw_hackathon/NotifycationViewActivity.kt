package com.example.woopa.sw_hackathon

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.woopa.sw_hackathon.Adapter.NotifycationAdapter
import kotlinx.android.synthetic.main.activity_notifiylog.*

class NotifycationViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notifiylog)

        var name = "이종현"
        var place = "학교"

        var bool = true
        var data = arrayListOf<NotifycationItem>()

        for (i in 0..10) {
            if (bool) {
                bool = false
                data.add(NotifycationItem(name + " 님이 도움을 요청했습니다.", "8월 28일 화요일", bool))
            } else {
                bool = true
                data.add(NotifycationItem(name + " 님이 " + place + "에 도착하셨습니다.", "8월 28일 화요일", bool))
            }
        }

        var adapter = NotifycationAdapter(this@NotifycationViewActivity, data)
        notify_recycler.adapter = adapter
    }
}