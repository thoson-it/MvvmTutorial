package com.it.thoson.mvvmtutorial.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.it.thoson.mvvmtutorial.model.AccountInfo
import com.it.thoson.mvvmtutorial.model.VideoInfo
import com.it.thoson.mvvmtutorial.ultilities.network.NetworkError
import com.it.thoson.mvvmtutorial.ultilities.network.Service
import rx.subscriptions.CompositeSubscription
import timber.log.Timber
import java.util.ArrayList
import javax.inject.Inject

/**
 * Created by sonlt on 3/30/18.
 */
class ListVideoViewModel {

    lateinit var mService: Service
    lateinit var mSubscription: CompositeSubscription

    var videos: MutableLiveData<ArrayList<VideoInfo>> = MutableLiveData()

    @Inject
    constructor(service: Service) {
        mService = service
        mSubscription = CompositeSubscription()
    }

    fun login() {
        var subscription = mService.getVideo(object : Service.ApiCallback<VideoInfo> {
            override fun onSuccess(data: ArrayList<VideoInfo>?) {

                videos.value = data

                Timber.i("Success")
            }

            override fun onError(networkError: NetworkError) {
                Timber.i(networkError.appErrorMessage)
            }

        })
        mSubscription.add(subscription)
    }
}