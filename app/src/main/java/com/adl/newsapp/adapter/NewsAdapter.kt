package com.adl.newsapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adl.newsapp.R
import com.adl.newsapp.model.NewsItem

class NewsAdapter(val data: ArrayList<NewsItem>): RecyclerView.Adapter<NewsVH>() {
    lateinit var parent: ViewGroup
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsVH {
        this.parent = parent

        return NewsVH(LayoutInflater.from(parent.context).inflate(R.layout.news_item,parent,false))
    }

    override fun onBindViewHolder(holder: NewsVH, position: Int) {
        holder.bindData(this@NewsAdapter,position)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}