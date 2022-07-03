package com.adl.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import com.adl.newsapp.model.NewsItem
import com.adl.newsapp.model.NewsModel

class WebViewActivity : AppCompatActivity() {
    lateinit var data: NewsItem
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        val myWebView: WebView = findViewById(R.id.webview)
        if(intent.hasExtra("data")) {
            data = intent.getParcelableExtra("data")!!
            data.url?.let { myWebView.loadUrl(it) }
        }
    }
}