package com.alexperov.androidhw3

import com.alexperov.test.Attachment
import java.time.LocalDate

class Comment(
    val id: Int?,
    val fromId: Int?,
    val text: String,
    val replyToUser: Int,
    val reportsArray: MutableList<String> = mutableListOf(),
    val date: LocalDate = LocalDate.now(),
    val attachment: Attachment?,
)

