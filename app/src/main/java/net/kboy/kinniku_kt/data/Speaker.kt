package net.kboy.kinniku_kt.data

import java.io.Serializable

data class Speaker(
    val imgURL: String = "",
    val name: String = "",
    val screenName: String = "",
    val title: String = "",
    val order: String = "",
    val point: String = ""
): Serializable