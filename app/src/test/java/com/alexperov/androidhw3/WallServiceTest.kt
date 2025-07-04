package com.alexperov.androidhw3

import com.alexperov.test.Attachment
import com.alexperov.test.Attachment.AttachmentPhoto
import com.alexperov.test.Photo
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class WallServiceTest {
    private lateinit var testPost: Post
    private lateinit var testAttachment: Attachment

    @Before
    fun clear() {
        WallService.clear()
        testPost = Post(1, 1, 1, 1, "1", 1, 1, true, 0)
        testAttachment =
            AttachmentPhoto( Photo(1, 1, 1, 1, "http://example.com/1.jpg"))
    }

    @Test
    fun checkaAddPost() {
        var result = WallService.addPost(testPost)
        assertEquals(result, testPost)

    }

    @Test
    fun checkUpdateTrue() {
        WallService.addPost(testPost)
        val result = WallService.update(testPost, "new text")
        assertEquals(result, true)
    }

    @Test
    fun checkUpdateFalse() {
        val result = WallService.update(testPost, "skip add post ")
        assertEquals(result, false)
    }

    @Test
    fun checkClear() {
        WallService.addPost(testPost)
        var result = WallService.clear()
        assertEquals(result, true)

    }

    @Test
    fun checkAddAttachment() {

        var result = WallService.addAttachment(testPost, testAttachment)
        assertEquals(result, true)
    }

}