package com.it.thoson.mvvmtutorial.ultilities.network

import com.it.thoson.mvvmtutorial.model.AccountInfo
import com.it.thoson.mvvmtutorial.model.UserInfo
import com.it.thoson.mvvmtutorial.model.VideoInfo
import java.util.ArrayList

import retrofit2.Response
import rx.Subscriber
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class Service(private val networkService: NetworkService) {

    fun getVideo(callback: ApiCallback<VideoInfo>): Subscription {

        return networkService.videos
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Subscriber<Response<ArrayList<VideoInfo>>>() {
                    override fun onCompleted() {

                    }

                    override fun onError(e: Throwable) {
                        callback.onError(NetworkError(e))
                    }

                    override fun onNext(response: Response<ArrayList<VideoInfo>>) {
                        callback.onSuccess(response.body())
                    }
                })
    }

    fun getLogin(user: UserInfo, callback: ApiCallback<AccountInfo>): Subscription {

        return networkService.getLogin(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Subscriber<Response<AccountInfo>>() {
                    override fun onCompleted() {

                    }

                    override fun onError(e: Throwable) {
                        callback.onError(NetworkError(e))
                    }

                    override fun onNext(response: Response<AccountInfo>) {
                        val accounts = ArrayList<AccountInfo>()
                        response.body()?.let{
                            accounts.add(response.body()!!)
                        }
                        callback.onSuccess(accounts)
                    }
                })
    }

    interface ApiCallback<T> {
        fun onSuccess(data: ArrayList<T>?)

        fun onError(networkError: NetworkError)
    }
}
