package com.it.thoson.mvvmtutorial.view.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View

import com.it.thoson.mvvmtutorial.MyApplication
import com.it.thoson.mvvmtutorial.di.module.DiComponent

/**
 * Created by sonlt on 1/9/18.
 */

class BaseFragment : Fragment() {

    private val mainApplication: MyApplication
        get() = activity.application as MyApplication

    protected val diComponent: DiComponent
        get() = mainApplication.diComponent

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    /**
     *
     * @return true: this handled back press
     */
    fun onBackPressed(): Boolean {
        return false
    }
}
