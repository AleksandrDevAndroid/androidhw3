package com.alexperov.androidhw3


fun main() {
    var post1 = Post(2,1,1,1,"1",1,1,true,0)
    var post2 = Post(1,1,1,1,"2",1,1,true,0)

    WallService.addPost(post1)
    WallService.addPost(post2)

    WallService.showPost(post1.id)
    WallService.showPost(post2.id)

}
