package com.it.thoson.mvvmtutorial.view.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.it.thoson.mvvmtutorial.R
import com.it.thoson.mvvmtutorial.model.VideoInfo

import com.squareup.picasso.Picasso

import java.util.ArrayList
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import com.it.thoson.mvvmtutorial.BR


/**
 * Created by sonlt on 1/9/18.
 */

class ListVideoAdapter(internal var context: Context, list: ArrayList<VideoInfo>) : RecyclerView.Adapter<ListVideoAdapter.ViewHolder>() {
    internal var list = ArrayList<VideoInfo>()

    init {
        this.list = list
    }

    fun updateData(list: ArrayList<VideoInfo>) {
        this.list.clear()
        this.list.addAll(list)
    }

    inner class ViewHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
//        var tvTitle: TextView
//        var tvComment: TextView
//        var imvIcon: ImageView
//
//        init {
//            tvTitle = itemView.findViewById(R.id.tv_title)
//            tvComment = itemView.findViewById(R.id.tv_comment)
//            imvIcon = itemView.findViewById(R.id.imv_icon)
//        }

        lateinit var binding: ViewDataBinding

        init {
            this.binding = binding
        }

        fun bind(data: Any) {
            binding.setVariable(BR.video, data)
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListVideoAdapter.ViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_video, null)
//        return ViewHolder(view)

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ViewDataBinding = DataBindingUtil.inflate(layoutInflater, R.layout.row_video, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val video = list[position]
//        holder.tvTitle.setText(video.title)
//        holder.tvComment.setText(video.lastComment)
//        Picasso.with(context).load(video.thumb).into(holder.imvIcon)

        holder.bind(video)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
