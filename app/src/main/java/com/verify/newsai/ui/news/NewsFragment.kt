package com.verify.newsai.ui.news

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels // for it we add a dependency -> implementation("androidx.fragment:fragment-ktx:1.6.2")
import androidx.recyclerview.widget.LinearLayoutManager
import com.verify.newsai.R
import com.verify.newsai.viewmodel.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint
import androidx.recyclerview.widget.RecyclerView
@AndroidEntryPoint
class NewsFragment : Fragment(R.layout.fragment_news) {
    private val viewModel: NewsViewModel by viewModels()
    private lateinit var adapter: NewsAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = NewsAdapter()
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewNews)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        viewModel.news.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
        viewModel.fetchNews()
    }
}