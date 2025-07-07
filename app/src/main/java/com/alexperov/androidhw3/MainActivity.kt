package com.alexperov.androidhw3

import com.alexperov.test.Attachment
import com.alexperov.test.Photo


fun main() {
    var post1 = Post(1, 1, 1, 1, "1", 1, 1, true, 0)
    val attachmentPhoto = Attachment.AttachmentPhoto(Photo(1, 1, 1, 1, "http://example.com/1.jpg"))
    WallService.addPost(post1)
    WallService.createComment(post1.id, Comment(1, 2, "Hello",1, attachment = null))
    WallService.addAttachment(post1,attachmentPhoto)
    WallService.pushStrike(post1.id,1,2)
    println(WallService.pushStrike(post1.id,1,12))
    WallService.showPost(post1.id)
}
