package net.kboy.kinniku_kt.data

import java.io.Serializable

data class Speaker(
    var id: String = "",
    val imgURL: String = "",
    val name: String = "",
    val screenName: String = "",
    val title: String = "",
    val order: Int = 0,
    val point: Int = 0
): Serializable