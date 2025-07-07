package com.alexperov.androidhw3

import com.alexperov.androidhw3.CustomException
import com.alexperov.test.Attachment

object WallService {

    private var postsArray = mutableMapOf<Int, Post>()
    private var id = 0
    private fun add(post: Post) {
        postsArray[post.id as Int] = post
    }

    fun clear(): Boolean {
        postsArray.clear()
        id = 0
        return postsArray.isEmpty()

    }

    fun addPost(post: Post): Post? {
        val newPost = post.copy(id = ++id)
        add(newPost)
        return postsArray[newPost.id]
    }

    fun update(post: Post, text: String): Boolean {
        if (!postsArray.containsKey(post.id)) return false
        var updatePost = post.copy()
        postsArray[post.id as Int] = updatePost.copy(text = text)
        return true
    }

    fun showPost(id: Int?) {
        println(postsArray[id].toString())
    }

    fun addAttachment(post: Post, attachment: Attachment): Boolean {
        post.attachment.add(attachment)
        return post.attachment.last() == attachment
    }

    fun createComment(postId: Int?, comment: Comment): Comment? {
        val post = postsArray[postId] ?: throw CustomException.PostNotFoundException("PostNotFoundException")
        post.commentArray[id] = comment
        return comment

    }
    fun pushStrike(postId: Int?, comment: Int?, reason: Int): String? {
        val post = postsArray[postId]?.copy() ?: throw CustomException.PostNotFoundException("PostNotFoundException")
        if (post.commentArray.containsKey(comment)) {
            if(reason + 1 !in 1..NegativeComment.reasonStrike.size) throw CustomException.ReasonNotFoundException("ReasonNotFoundException")
            post.commentArray[comment]?.reportsArray?.add(NegativeComment.reasonStrike[reason])
                ?: throw CustomException.CommentNotFoundException("CommentNotFoundException")
        }
        return post.commentArray[comment]?.reportsArray?.last()
    }
}



