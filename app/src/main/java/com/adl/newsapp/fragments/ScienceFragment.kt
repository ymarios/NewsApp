package com.adl.newsapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.adl.newsapp.R
import com.adl.newsapp.adapter.NewsAdapter
import com.adl.newsapp.model.NewsItem
import com.adl.newsapp.model.ResponseNews
import com.adl.newsapp.service.RetrofitConfig
import kotlinx.android.synthetic.main.homefragment.*
import kotlinx.android.synthetic.main.sciencefragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ScienceFragment : Fragment() {

    lateinit var allnews : ArrayList<NewsItem>
    lateinit var newsAdapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.sciencefragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        allnews = ArrayList<NewsItem>()

        newsAdapter = NewsAdapter(allnews)

        RetrofitConfig().getAPIService()
            .getScience()
            .enqueue(object : Callback<ResponseNews> {
                override fun onResponse(
                    call: Call<ResponseNews>,
                    response: Response<ResponseNews>
                ) {
                    val data: ResponseNews? = response.body()

                    for (content in data?.articles.orEmpty()) {
                        allnews.add(
                            NewsItem(
                                content?.publishedAt,
                                content?.author,
                                content?.urlToImage,
                                content?.description,
                                content?.source,
                                content?.title,
                                content?.url,
                                content?.content
                            )
                        )
                    }

                    newsAdapter.notifyDataSetChanged()

                }

                override fun onFailure(call: Call<ResponseNews>, t: Throwable) {

                }


            })

        rvScience.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,true)
            adapter = newsAdapter
        }
    }
}