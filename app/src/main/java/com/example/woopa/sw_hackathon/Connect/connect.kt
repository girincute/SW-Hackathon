package PaperEd.quickStart.Connect

import PaperEd.quickStart.model.AccessTokenModel
import PaperEd.quickStart.model.ChildInfoModel
import PaperEd.quickStart.model.LocationModel
import PaperEd.quickStart.model.TokenModel
import android.widget.Toast
import com.google.gson.JsonObject
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

val api = Connector.createApi()

fun login(body: JSONObject, success: Response<TokenModel>.() -> Unit, failure: () -> Unit) {
    api.login(body).enqueue(object : Callback<TokenModel> {
        override fun onResponse(call: Call<TokenModel>?, response: Response<TokenModel>) {
            response.success()
        }

        override fun onFailure(call: Call<TokenModel>?, t: Throwable?) {
            failure()
        }

    })
}

fun refresh(refreshToken: String, success: Response<AccessTokenModel>.() -> Unit, failure: () -> Unit) {
    api.refreshToken(refreshToken).enqueue(object : Callback<AccessTokenModel> {
        override fun onResponse(call: Call<AccessTokenModel>?, response: Response<AccessTokenModel>) {
            response.success()
        }

        override fun onFailure(call: Call<AccessTokenModel>?, t: Throwable?) {
            failure()
        }

    })
}

fun shout(token: String, body: JsonObject, success: Response<Void>.() -> Unit, failure: () -> Unit) {
    api.shout(token, body).enqueue(object : Callback<Void> {
        override fun onResponse(call: Call<Void>?, response: Response<Void>) {
            response.success()
        }

        override fun onFailure(call: Call<Void>?, t: Throwable?) {
            failure()
        }

    })
}

fun user(body: JsonObject, success: Response<TokenModel>.() -> Unit, failure: () -> Unit) {
    api.user(body).enqueue(object : Callback<TokenModel> {
        override fun onResponse(call: Call<TokenModel>?, response: Response<TokenModel>) {
            response.success()
        }

        override fun onFailure(call: Call<TokenModel>?, t: Throwable?) {
            failure()
        }
    })
}

fun child(body: JsonObject, success: Response<TokenModel>.() -> Unit, failure: () -> Unit) {
    api.child(body).enqueue(object : Callback<TokenModel> {
        override fun onResponse(call: Call<TokenModel>?, response: Response<TokenModel>) {
            response.success()
        }

        override fun onFailure(call: Call<TokenModel>?, t: Throwable?) {
            failure()
        }

    })
}

fun sendLocation(token: String, body: JsonObject, id: String, success: Response<Void>.() -> Unit, failure: () -> Unit) {
    api.sendLocation(token, body, id).enqueue(object : Callback<Void> {
        override fun onResponse(call: Call<Void>?, response: Response<Void>) {
            response.success()
        }

        override fun onFailure(call: Call<Void>?, t: Throwable?) {
            failure()
        }

    })
}

fun delete(token: String, body: JsonObject, id: String, success: Response<Void>.() -> Unit, failure: () -> Unit) {
    api.delete(token, body, id).enqueue(object : Callback<Void> {
        override fun onResponse(call: Call<Void>?, response: Response<Void>) {
            response.success()
        }

        override fun onFailure(call: Call<Void>?, t: Throwable?) {
            failure()
        }

    })
}

fun changeHome(token: String, body: JsonObject, id: String, success: Response<Void>.() -> Unit, failure: () -> Unit) {
    api.changeHome(token, body, id).enqueue(object : Callback<Void> {
        override fun onResponse(call: Call<Void>?, response: Response<Void>) {
            response.success()
        }

        override fun onFailure(call: Call<Void>?, t: Throwable?) {
            failure()
        }

    })
}

fun childInfo(token: String, id: String, success: Response<ChildInfoModel>.() -> Unit, failure: () -> Unit) {
    api.childInfo(token, id).enqueue(object : Callback<ChildInfoModel> {
        override fun onResponse(call: Call<ChildInfoModel>?, response: Response<ChildInfoModel>) {
            response.success()
        }

        override fun onFailure(call: Call<ChildInfoModel>?, t: Throwable?) {
            failure()
        }
    })
}

fun addChild(token: String, body: JsonObject, id: String, success: Response<Void>.() -> Unit, failure: () -> Unit) {
    api.addChild(token, body, id).enqueue(object : Callback<Void> {
        override fun onResponse(call: Call<Void>?, response: Response<Void>) {
            response.success()
        }

        override fun onFailure(call: Call<Void>?, t: Throwable?) {
            failure()
        }
    })
}

fun deleteUser(token: String, id: String, success: Response<Void>.() -> Unit, failure: () -> Unit) {
    api.deleteUser(token, id).enqueue(object : Callback<Void> {
        override fun onResponse(call: Call<Void>?, response: Response<Void>) {
            response.success()
        }

        override fun onFailure(call: Call<Void>?, t: Throwable?) {
            failure()
        }
    })
}

fun parentLocation(token: String, id: String, success: Response<LocationModel>.() -> Unit, failure: () -> Unit) {
    api.parentLocation(token, id).enqueue(object : Callback<LocationModel> {
        override fun onResponse(call: Call<LocationModel>?, response: Response<LocationModel>) {
            response.success()
        }

        override fun onFailure(call: Call<LocationModel>?, t: Throwable?) {
            failure()
        }

    })
}

fun deleteChild(token: String, id: String, child: String, success: Response<Void>.() -> Unit, failure: () -> Unit) {
    api.deleteChild(token, id, child).enqueue(object : Callback<Void> {
        override fun onResponse(call: Call<Void>?, response: Response<Void>) {
            response.success()
        }

        override fun onFailure(call: Call<Void>?, t: Throwable?) {
            failure()
        }

    })
}