package com.alexperov.androidhw3

import com.alexperov.test.Attachment

object WallService {

    private var posts = mutableMapOf<Int, Post>()
    private var id = 0

    private var attachment: Array<Attachment> = emptyArray()
    private fun add(post: Post) {
        posts[post.id as Int] = post
    }

    fun addAttachment(post: Post, attachment: Attachment): Boolean {
        post.attachment.add(attachment)
        if (post.attachment.last() == attachment)
            return true
        else return false

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
