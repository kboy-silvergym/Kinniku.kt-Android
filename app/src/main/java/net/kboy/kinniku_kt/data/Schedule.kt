package net.kboy.kinniku_kt.data

import java.io.Serializable
import java.util.*

data class Schedule(
    val date: Date,
    val title: String,
    val detail: String
): Serializable