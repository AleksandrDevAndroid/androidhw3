package com.alexperov.androidhw3

object WallService {

    private var posts = mutableMapOf<Int, Post>()
    private var id = 0

    private fun add(post: Post) {
        posts[post.id as Int] = post
    }

    fun clear(): Boolean {
        posts.clear()
        id = 0
        if (posts.isEmpty())
            return true
        else
            return false

    }

    fun addPost(post: Post): Post? {
        val newPost = post.copy(id = ++id)
        add(newPost)
        return posts[newPost.id]
    }


    fun update(post: Post, text: String): Boolean {
        if (!posts.containsKey(post.id)) return false
        var updatePost = post.copy()
        posts[post.id as Int] = updatePost.copy(text = text)
        return true
    }

    fun showPost(id: Int?) {
        println(posts[id].toString())
    }
}
