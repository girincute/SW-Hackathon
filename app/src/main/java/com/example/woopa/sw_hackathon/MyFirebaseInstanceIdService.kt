package com.example.woopa.sw_hackathon

import android.util.Log
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.FirebaseInstanceIdService

class MyFirebaseInstanceIdService : FirebaseInstanceIdService() {
    companion object {
        val TAG = "MyFirebaseIIDService"
    }



    private fun sendRegistrationToServer(refreshedToken: String?) {

    }
}