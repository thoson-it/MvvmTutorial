package com.it.thoson.mvvmtutorial.ultilities.network

import com.it.thoson.mvvmtutorial.model.AccountInfo
import com.it.thoson.mvvmtutorial.model.UserInfo
import com.it.thoson.mvvmtutorial.model.VideoInfo
import java.util.ArrayList

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import rx.Observable

/**
 * Created by ennur on 6/25/16.
 */
interface NetworkService {

    @get:GET("/v2/5a2cb8792f000021260393b1")
    val videos: Observable<Response<ArrayList<VideoInfo>>>

    @Headers("Content-Type: application/json")
    @POST("5a26725b30000004120e8740")
    fun getLogin(@Body user: UserInfo): Observable<Response<AccountInfo>>

}
