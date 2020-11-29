package br.com.digitalhouse.desafiowebservice.domain

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ComicImage(
    @SerializedName("path") val path: String,
    @SerializedName("extension") val extension: String
) : Serializable {
    override fun toString() = "$path.$extension".replace("http://", "https://")
}
