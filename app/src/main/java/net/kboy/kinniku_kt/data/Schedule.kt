package net.kboy.kinniku_kt.data

import java.io.Serializable

data class Schedule(
    val time: String = "",
    val title: String = "",
    val description: String = ""
): Serializable