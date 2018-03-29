package com.it.thoson.mvvmtutorial.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.it.thoson.mvvmtutorial.model.AccountInfo
import com.it.thoson.mvvmtutorial.model.UserInfo
import com.it.thoson.mvvmtutorial.ultilities.network.NetworkError
import com.it.thoson.mvvmtutorial.ultilities.network.Service
import rx.subscriptions.CompositeSubscription
import java.util.ArrayList
import javax.inject.Inject

/**
 * Created by sonlt on 3/29/18.
 */
class LoginViewModel {
    lateinit var mService : Service
    lateinit var mSubscription : CompositeSubscription

    @Inject
    constructor(service : Service){
        this.mService = service
        mSubscription = CompositeSubscription()
    }

    var accountInfo : AccountInfo? = null
    var account: MutableLiveData<AccountInfo> = MutableLiveData()

    fun login(userInfo: UserInfo) {
        var subscription = mService.getLogin(userInfo!!, object : Service.ApiCallback<AccountInfo> {
            override fun onSuccess(data: ArrayList<AccountInfo>?) {
                Log.i("login", "onSuccess")
            }

            override fun onError(networkError: NetworkError) {
                Log.i("login", "onError")
            }

        })
        mSubscription.add(subscription)
    }
}