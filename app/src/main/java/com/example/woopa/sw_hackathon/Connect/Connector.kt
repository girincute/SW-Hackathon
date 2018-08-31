package PaperEd.quickStart.Connect

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Connector {
    val api: API
    val retrofit: Retrofit
    init {
        retrofit = Retrofit.Builder()
                .baseUrl("https://radiant-atoll-81120.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        api = retrofit.create(API::class.java)
    }
    fun createApi() = retrofit.create(API::class.java)
}