package com.adl.newsapp.adapter

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.adl.newsapp.WebViewActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.news_item.view.*

class NewsVH(view: View): RecyclerView.ViewHolder(view) {
    val title = view.newshead
    val desc = view.content
    val image = view.imageview
    val auth = view.author
    val pubtime = view.time
    val nitem = view.newsitem

    fun bindData(adapter: NewsAdapter, position:Int){

        title.setText(adapter.data.get(position)?.title.toString())

        desc.setText(adapter.data.get(position)?.description.toString())

        image?.let {
            Glide.with(adapter.parent.context)
                .asBitmap()
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .load(adapter.data.get(position).urlToImage)
                .into(it)
        }

        auth.setText(adapter.data.get(position)?.author.toString())

        pubtime.setText(adapter.data.get(position)?.publishedAt.toString())

        nitem.setOnClickListener({
            val intent = Intent(adapter.parent.context, WebViewActivity::class.java)
            intent.putExtra("data", adapter.data.get(position))
            adapter.parent.context.startActivity(intent)
        })

    }
}