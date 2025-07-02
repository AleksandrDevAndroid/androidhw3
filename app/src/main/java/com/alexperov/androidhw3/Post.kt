package com.alexperov.androidhw3

import com.alexperov.test.Attachment
import java.time.LocalDate


data class Post(
    val id: Int? = 0,
    val ownerId: Int?,
    val fromId: Int?,
    val createdBy: Int?,
    val text: String?,
    val replyOwnerId: Int?,
    val replyPostId: Int?,
    val canPin: Boolean?,
    val likes: Int?,
    val date: LocalDate = LocalDate.now(),
    var attachment: MutableList<Attachment> = mutableListOf()
)



