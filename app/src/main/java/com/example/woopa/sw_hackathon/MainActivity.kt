package com.example.woopa.sw_hackathon

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.util.Log
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import android.view.Window
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(),OnMapReadyCallback,NavigationView.OnNavigationItemSelectedListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var flag = false;

        var del_anim1 = AnimationUtils.loadAnimation(baseContext,R.anim.delete_fab_anim1)

//        del_anim1.setAnimationListener(object : Animation.AnimationListener{
//            override fun onAnimationStart(p0: Animation?) {
//            }
//
//            override fun onAnimationRepeat(p0: Animation?) {
//
//            }
//
//            override fun onAnimationEnd(p0: Animation?) {
//                delete_fab.translationY = (-200).toFloat()
//            }
//        })

        var noti_anim1 = AnimationUtils.loadAnimation(baseContext,R.anim.noti_fab_anim1)
        var main_anim1 = AnimationUtils.loadAnimation(baseContext,R.anim.main_fab_anim1)
        var main_anim2 = AnimationUtils.loadAnimation(baseContext,R.anim.main_fab_anim2)


            delete_fab.hide()
            modi_fab.hide()
            noti_fab.hide()
            childlist_fab.hide()


        main_fab.setOnClickListener {
            if(!flag){
                flag = true

//                requestWindowFeature(Window.FEATURE_NO_TITLE)

                window.setBackgroundDrawable(ColorDrawable(Color.parseColor("#44000000")))

                main_fab.startAnimation(main_anim1)
                delete_fab.show()
                modi_fab.show()
                noti_fab.show()
                childlist_fab.show()

                delete_text.visibility = View.VISIBLE
                modi_text.visibility = View.VISIBLE
                childlist_text.visibility = View.VISIBLE
                noti_text.visibility = View.VISIBLE

                main_fab_background.visibility = View.VISIBLE

//                delete_fab.startAnimation(del_anim1)
//                delete_fab.translationY = (-200).toFloat()
//                noti_fab.translationY = (-400).toFloat()
//                modi_fab.translationY = (-600).toFloat()
//                childlist_fab.translationY = (-800).toFloat()
            } else {
                flag = false
                main_fab.startAnimation(main_anim2)
                delete_fab.hide()
                modi_fab.hide()
                noti_fab.hide()
                childlist_fab.hide()

                main_fab_background.visibility = View.INVISIBLE

                delete_text.visibility = View.INVISIBLE
                modi_text.visibility = View.INVISIBLE
                childlist_text.visibility = View.INVISIBLE
                noti_text.visibility = View.INVISIBLE

//                delete_fab.translationY = (0).toFloat()
//                noti_fab.translationY = (0).toFloat()
//                modi_fab.translationY = (0).toFloat()
//                childlist_fab.translationY = (0).toFloat()
            }
        }

        delete_fab.setOnClickListener { v -> Toast.makeText(baseContext,"sss",Toast.LENGTH_SHORT).show() }
        main_drawer_button.setOnClickListener {
            if(drawer_layout.isDrawerOpen(GravityCompat.START)){
                drawer_layout.closeDrawer(GravityCompat.START)
            } else {
                drawer_layout.openDrawer(GravityCompat.START)
            }
        }

        navigation_view.setNavigationItemSelectedListener(this)

    }

    override fun onMapReady(p0: GoogleMap?) {
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.navigation_noti_btn -> {
                var intent = Intent(this@MainActivity,NotifycationViewActivity::class.java)
                startActivity(intent)
            }
            R.id.navigation_setting_btn ->{
                var intent = Intent(this@MainActivity,ChildViewDetailActivity::class.java)
                startActivity(intent)
            }
        }
        return false;
    }


}
