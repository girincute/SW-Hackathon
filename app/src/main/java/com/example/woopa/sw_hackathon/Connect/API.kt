package PaperEd.quickStart.Connect

import PaperEd.quickStart.model.AccessTokenModel
import PaperEd.quickStart.model.ChildInfoModel
import PaperEd.quickStart.model.LocationModel
import PaperEd.quickStart.model.TokenModel
import com.google.gson.JsonObject
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.*

interface API {
    /**
     * 로그인
     * id: string
     * pw: string
     * type: "child" or "user"
     */
    @POST("login")
    fun login(@Body body: JSONObject): Call<TokenModel>

    @POST("refresh")
    fun refreshToken(@Header("Authorization") refreshToken: String): Call<AccessTokenModel>

    /**
     * 살려주세요 ㅠㅠ
     * child: 전화번호 (string)
     */
    @POST("shout")
    fun shout(@Header("Authorization") token: String, @Body body: JsonObject): Call<Void>


    /**
     * 유저 회원가입
     * id: String
     * pw: String
     * name: String
     * */
    @POST("user")
    fun user(@Body body: JsonObject): Call<TokenModel>

    /**
     * 자식 회원가입
     * id: String
     * pw: String
     * name: String
     * */
    @POST("child")
    fun child(@Body body: JsonObject): Call<TokenModel>

    /**
     * 위치전송 하기
     * location: 위도,경도 고대로 때려박아서~~
     * id: 자식 전화번호(string)
     * */
    @POST("child/{id}")
    fun sendLocation(@Header("Authorization") token: String, @Body body: JsonObject, @Path("id") id: String): Call<Void>

    /**
     * 탈퇴하기
     * location: 위도,경도 고대로 때려박아서~~
     * id: 자식 전화번호(string)
     * */
    @PATCH("child/{id}")
    fun delete(@Header("Authorization") token: String, @Body body: JsonObject, @Path("id") id: String): Call<Void>

    /**
     * 집 바꾸기
     * location: 위도,경도 고대로 때려박아서~~
     * id: 자식 전화번호(string)
     * */
    @PATCH("child/{id}")
    fun changeHome(@Header("Authorization") token: String, @Body body: JsonObject, @Path("id") id: String): Call<Void>

    /**
     * 자녀 정보 받아오기
     * location: 위도,경도 고대로 때려박아서~~
     * id: 자식 전화번호(string)
     * */
    @GET("child/{id}")
    fun childInfo(@Header("Authorization") token: String, @Path("id") id: String): Call<ChildInfoModel>


    /**
     * 자녀 추가
     * body - child: 애새기 전화번호
     * id: 엄마 전화번호
     */
    @PATCH("user/{id}")
    fun addChild(@Header("Authorization") token: String, @Body body: JsonObject, @Path("id") id: String): Call<Void>

    /**
     * 탈퇴하기
     * id: 엄마 전화번호
     */
    @DELETE("user/{id}")
    fun deleteUser(@Header("Authorization") token: String, @Path("id") id: String): Call<Void>

    /**
     * 부모님의 현재 위치
     * id: 엄마 전화번호
     */
    @GET("user/{id}")
    fun parentLocation(@Header("Authorization") token: String, @Path("id") id: String): Call<LocationModel>

    /**
     * 자식 제거하기
     * id: 엄마 전화번호
     * child: 애새기 전화번호
     */
    @DELETE("user/{id}/{child}")
    fun deleteChild(@Header("Authorization") token: String, @Path("id") id: String, @Path("child") child: String): Call<Void>

}