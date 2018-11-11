package net.kboy.kinniku_kt.data

import java.io.Serializable

data class Sponsor(
    val name: String = "",
    val type: String = "",
    val description: String = "",
    val url: String = "",
    val imgURL: String = ""
): Serializable