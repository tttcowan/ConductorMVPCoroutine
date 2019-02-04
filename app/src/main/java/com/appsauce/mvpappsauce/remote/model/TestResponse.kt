package com.appsauce.mvpappsauce.remote.model

import com.google.gson.annotations.SerializedName

data class TestResponse(
    @SerializedName("args")
    val args: Args = Args(),
    @SerializedName("headers")
    val headers: Headers = Headers(),
    @SerializedName("origin")
    val origin: String = "",
    @SerializedName("url")
    val url: String = ""
) {
    class Args

    data class Headers(
        @SerializedName("Accept")
        val accept: String = "",
        @SerializedName("Accept-Encoding")
        val acceptEncoding: String = "",
        @SerializedName("Accept-Language")
        val acceptLanguage: String = "",
        @SerializedName("Connection")
        val connection: String = "",
        @SerializedName("Content-Type")
        val contentType: String = "",
        @SerializedName("Host")
        val host: String = "",
        @SerializedName("Origin")
        val origin: String = "",
        @SerializedName("Referer")
        val referer: String = "",
        @SerializedName("User-Agent")
        val userAgent: String = ""
    )
}