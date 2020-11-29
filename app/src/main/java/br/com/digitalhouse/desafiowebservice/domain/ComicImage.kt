package br.com.digitalhouse.desafiowebservice.domain

import com.google.gson.annotations.SerializedName

class ComicImage(
    @SerializedName("path") val path: String,
    @SerializedName("extension") val extension: String
) {
    override fun toString() = "$path.$extension"
}
