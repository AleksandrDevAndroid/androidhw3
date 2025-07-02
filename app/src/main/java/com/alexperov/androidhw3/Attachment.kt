package com.alexperov.test

interface Attachment {
    val type: String
}

class AttachmentPhoto(
    override val type: String,
    val photo: Photo
) : Attachment

class AttachmentVideo(
    override val type: String,
    val video: Video
) : Attachment

class AttachmentFile(
    override val type: String,
    val file: File
) : Attachment

class AttachmentAudio(
    override val type: String,
    val audio: Audio
) : Attachment

class AttachmentUrl(
    override val type: String,
    val url: Url
) : Attachment

data class Photo(
    val id: Int,
    val ownerId: Int,
    val height: Int,
    val weight: Int,
    val url: String,

    )

data class Video(
    val id: Int,
    val ownerId: Int,
    val duration: Int,
    val title: String,
    val url: String,

    )

data class File(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val size: Int,
    val url: String
)

data class Audio(
    val id: Int,
    val ownerId: Int,
    val artist: String,
    val title: String,
    val url: String

)

data class Url(
    val url: String,
    val title: String,
    val descption: String,
    val caption: String,
    val photo: Photo
)