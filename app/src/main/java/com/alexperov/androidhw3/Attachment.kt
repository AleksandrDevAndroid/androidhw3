package com.alexperov.test

interface Attachment {
    val type: String
}

data class AttachmentPhoto(
    val id: Int,
    val ownerId: Int,
    val height: Int,
    val weight: Int,
    val url: String,
    override val type: String
) : Attachment

data class AttachmentVideo(
    val id: Int,
    val ownerId: Int,
    val duration: Int,
    val title: String,
    val url: String,
    override val type: String
) : Attachment