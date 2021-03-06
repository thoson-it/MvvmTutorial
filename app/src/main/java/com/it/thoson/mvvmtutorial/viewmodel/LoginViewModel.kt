package com.it.thoson.mvvmtutorial.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.it.thoson.mvvmtutorial.model.AccountInfo
import com.it.thoson.mvvmtutorial.model.UserInfo
import com.it.thoson.mvvmtutorial.ultilities.network.NetworkError
import com.it.thoson.mvvmtutorial.ultilities.network.Service
import rx.subscriptions.CompositeSubscription
import timber.log.Timber
import java.util.ArrayList
import javax.inject.Inject

/**
 * Created by sonlt on 3/29/18.
 */
class LoginViewModel {
    lateinit var mService: Service
    lateinit var mSubscription: CompositeSubscription

    @Inject
    constructor(service: Service) {
        this.mService = service
        mSubscription = CompositeSubscription()
    }

    var accountInfo: AccountInfo? = null
    var account: MutableLiveData<AccountInfo> = MutableLiveData()
    var userInfo: UserInfo = UserInfo("", "")

    fun login() {
        var subscription = mService.getLogin(userInfo, object : Service.ApiCallback<AccountInfo> {
            override fun onSuccess(data: ArrayList<AccountInfo>?) {

                account.value = data?.first()

                Timber.i("Success")
            }

            override fun onError(networkError: NetworkError) {
                Timber.i(networkError.appErrorMessage)
            }

        })
        mSubscription.add(subscription)
    }
}