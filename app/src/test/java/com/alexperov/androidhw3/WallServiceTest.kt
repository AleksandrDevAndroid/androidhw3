package com.alexperov.androidhw3

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class WallServiceTest {

    @Test
    fun checkaAddPost() {
        var post1 = Post(1,1,1,1,"1",1,1,true,0)
        var result = WallService.addPost(post1)
        assertEquals(result,post1)

    }

    @Test
    fun checkUpdateTrue() {
        var post2 = Post(2,1,1,1,"1",1,1,true,0)
        WallService.addPost(post2)
        val result = WallService.update(post2,"new text")
        assertEquals(result, true)
    }
    @Test
    fun checkUpdateFalse() {
        var post3 = Post(3,1,1,1,"1",1,1,true,0)
        val result = WallService.update(post3,"skip add post ")
        assertEquals(result,false)
    }

    @Test
    fun checkClear(){
        var post4 = Post(4,1,1,1,"1",1,1,true,0)
        WallService.addPost(post4)
        var result = WallService.clear()
        assertEquals(result,true)

    }


}