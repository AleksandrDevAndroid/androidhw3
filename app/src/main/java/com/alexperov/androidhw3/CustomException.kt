package com.alexperov.androidhw3

sealed class CustomException(message: String) : RuntimeException(message) {
    class PostNotFoundException(message: String) : CustomException(message)
    class CommentNotFoundException(message: String) : CustomException(message)
    class ReasonNotFoundException(message: String) : CustomException(message)
}