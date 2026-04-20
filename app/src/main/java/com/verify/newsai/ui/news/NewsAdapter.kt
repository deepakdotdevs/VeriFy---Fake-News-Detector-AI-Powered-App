package com.verify.newsai.ui.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.verify.newsai.R
import com.verify.newsai.data.model.Article
import com.bumptech.glide.Glide
class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>(){
    private val articles = mutableListOf<Article>()
    fun submitList(list: List<Article>) {
        articles.clear()
        articles.addAll(list)
        notifyDataSetChanged()
    }
    inner class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image = view.findViewById<ImageView>(R.id.imageNews)
        val title = view.findViewById<TextView>(R.id.textTitle)
        val desc = view.findViewById<TextView>(R.id.textDescription)
    }
    override fun getItemCount() = articles.size
    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val article = articles[position]
        holder.title.text = article.title
        holder.desc.text = article.description
        Glide.with(holder.itemView.context)
            .load(article.urlToImage)
            .into(holder.image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder{
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(view)
    }
}