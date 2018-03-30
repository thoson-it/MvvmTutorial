package com.it.thoson.mvvmtutorial.view

import android.arch.lifecycle.Observer
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.it.thoson.mvvmtutorial.MyApplication
import com.it.thoson.mvvmtutorial.R
import com.it.thoson.mvvmtutorial.databinding.ActivityListVideoBinding
import com.it.thoson.mvvmtutorial.model.VideoInfo
import com.it.thoson.mvvmtutorial.view.adapter.ListVideoAdapter
import com.it.thoson.mvvmtutorial.viewmodel.ListVideoViewModel
import java.util.ArrayList
import javax.inject.Inject

class ListVideoActivity : AppCompatActivity() {

    @Inject lateinit var listVideoViewModel: ListVideoViewModel


    private val list = ArrayList<VideoInfo>()

    lateinit var swipeRefreshLayout: SwipeRefreshLayout
    lateinit var rvVideos: RecyclerView
    lateinit var adapter: ListVideoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initDI()
        bindingData()
        initView()
        initEvent()
    }

    private fun initDI() {
        (application as MyApplication).diComponent.inject(this)
    }

    private fun bindingData() {
        val binding: ActivityListVideoBinding = DataBindingUtil.setContentView(this, R.layout.activity_list_video)

    }

    private fun initView() {
        swipeRefreshLayout = findViewById(R.id.swipe_layout)
        rvVideos = findViewById(R.id.rc_videos)

        adapter = ListVideoAdapter(this, list)
        rvVideos.setLayoutManager(LinearLayoutManager(this))
        rvVideos.setAdapter(adapter)
    }

    private fun initEvent() {
        swipeRefreshLayout.setOnRefreshListener {
            adapter.updateData(ArrayList())
            adapter.notifyDataSetChanged()
            listVideoViewModel.login()
        }

        listVideoViewModel.videos.observe(this, Observer { videos ->
            videos?.let {
                adapter.updateData(videos)
                adapter.notifyDataSetChanged()
                swipeRefreshLayout.isRefreshing = false
            }
        })
    }
}
