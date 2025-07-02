package com.alexperov.test

sealed class Attachment(val type: String) {


    class AttachmentPhoto(
        val photo: Photo
    )

    class AttachmentVideo(
        val video: Video
    )

    class AttachmentFile(
        val file: File
    )

    class AttachmentAudio(
        val audio: Audio
    )

    class AttachmentUrl(
        val url: Url
    )
}

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