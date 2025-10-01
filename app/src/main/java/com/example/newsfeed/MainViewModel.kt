package com.example.newsfeed

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val posts = mutableListOf<Post>()  // хранение списка постов
}
