package com.it.thoson.mvvmtutorial

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.it.thoson.mvvmtutorial.view.LoginActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showLogin()
    }

    private fun showLogin() {
        startActivity(Intent(this, LoginActivity::class.java))
    }

//    private fun showListVideo() {
//        val fr = ListVideoFragment()
//        fr.setListener(object : ListVideoFragment.ListVideoListener() {
//            fun onBack() {
//                popContenFragment()
//            }
//        })
//        replaceContentFragment(fr)
//    }
//
//    private fun replaceContentFragment(contractFragment: Fragment) {
//        supportFragmentManager
//                .beginTransaction()
//                .replace(R.id.root_content, contractFragment)
//                .addToBackStack(contractFragment.javaClass.name)
//                .commit()
//    }
//
//    private fun popContenFragment() {
//        val fragmentManager = supportFragmentManager
//        if (fragmentManager.backStackEntryCount > 0) {
//            fragmentManager.popBackStack()
//        }
//    }
//
//    fun onBackPressed() {
//        val fragmentList = supportFragmentManager.fragments
//
//        var handled = false
//        for (i in fragmentList.indices) {
//            val f = fragmentList[i] as Fragment
//            if (f is BaseFragment) {
//                handled = (f as BaseFragment).onBackPressed()
//
//                if (handled) {
//                    break
//                }
//            }
//        }
//
//        if (!handled) {
//            super.onBackPressed()
//        }
//    }
}
