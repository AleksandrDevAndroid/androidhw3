package com.alexperov.test

sealed class Attachment {
abstract val type: String

    class AttachmentPhoto(
        val photo: Photo,
        override val type: String ="photo"
    ): Attachment ()

    class AttachmentVideo(
        val video: Video,
        override val type: String = "video"
    ) : Attachment()

    class AttachmentFile(
        val file: File,
        override val type: String = "file"
    ) : Attachment()

    class AttachmentAudio(
        val audio: Audio,
        override val type: String = "audio"
    ) : Attachment ()

    class AttachmentUrl(
        val url: Url,
        override val type: String = "url"
    ) : Attachment ()
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