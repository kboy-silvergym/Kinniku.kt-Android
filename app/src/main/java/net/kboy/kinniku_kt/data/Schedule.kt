package net.kboy.kinniku_kt.data

import java.io.Serializable

data class Schedule(
    val date: String,
    val title: String,
    val detail: String
): Serializable