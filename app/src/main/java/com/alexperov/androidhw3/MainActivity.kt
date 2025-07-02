package com.alexperov.androidhw3

import com.alexperov.test.AttachmentPhoto
import com.alexperov.test.Photo


fun main() {
    var post1 = Post(2,1,1,1,"1",1,1,true,0)
    var post2 = Post(1,1,1,1,"2",1,1,true,0)
    var post3 = Post(3,3,3,4,"show photo",1,1,true,1)
    val attachmentPhoto = AttachmentPhoto("photo", Photo(1,1,1,1,"http://example.com/1.jpg"))
    WallService.addPost(post1)
    WallService.addPost(post2)
    WallService.update(post2,"test")
    WallService.addPost(post3)
    WallService.addAttachment(post3,attachmentPhoto)

    WallService.showPost(post1.id)
    WallService.showPost(post2.id)
    WallService.showPost(post3.id)
}
