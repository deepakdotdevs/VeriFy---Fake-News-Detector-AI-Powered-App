package com.verify.newsai

import com.verify.newsai.viewmodel.NewsViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import com.verify.newsai.ui.news.NewsFragment
import dagger.hilt.android.AndroidEntryPoint
import androidx.appcompat.app.AppCompatActivity

@AndroidEntryPoint

class MainActivity : AppCompatActivity() {


    // private val viewModel: NewsViewModel by viewModels() -> fragment handles it

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // viewModel.fetchNews() we have to remove it coz now fragment handles it
        enableEdgeToEdge()
        supportFragmentManager.beginTransaction()
            .replace(android.R.id.content, NewsFragment())
            .commit()
    }
}