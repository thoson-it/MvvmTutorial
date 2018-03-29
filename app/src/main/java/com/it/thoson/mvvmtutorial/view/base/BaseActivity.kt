package com.it.thoson.mvvmtutorial.view.base

import android.support.v7.app.AppCompatActivity

import com.it.thoson.mvvmtutorial.MyApplication
import com.it.thoson.mvvmtutorial.di.module.DiComponent

/**
 * Created by sonlt on 1/11/18.
 */

class BaseActivity : AppCompatActivity() {


    protected val diComponent: DiComponent
        get() = (application as MyApplication).diComponent
}
