package com.alexperov.androidhw3

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
        val post = postsArray[postId] ?: throw Exception("PostNotFoundException")
        post.commentArray[id] = comment
        return comment

    }
    /*Реализовать саму функцию (для простоты храните эти репорты в отдельном массиве).
Подумать, в каких случаях и какие нужно выкидывать исключения*.
Написать автотесты.
Подсказка*
Обратите внимание, что неверным может быть не только ID комментария, но и причина.
Важно: после ваших обновлений WallService должна оставаться функциональной, т.е. автотесты должны проходить.
Итог: у вас должен быть репозиторий на GitHub, в котором расположен ваш Gradle-проект. Автотесты также должны храниться в репозитории.*/

    fun pushStrike(postId: Int?, comment: Int?, reason: Int): String? {
        val post = postsArray[postId]?.copy() ?: throw Exception("PostNotFoundException")
        if (post.commentArray.containsKey(comment)) {
            if(reason + 1 !in 1..NegativeComment.reasonStrike.size) throw Exception("ReasonNotFoundException")
            post.commentArray[comment]?.reportsArray?.add(NegativeComment.reasonStrike[reason])
                ?: throw Exception("CommentNotFoundException")
        }
        return post.commentArray[comment]?.reportsArray?.last()
    }
}



