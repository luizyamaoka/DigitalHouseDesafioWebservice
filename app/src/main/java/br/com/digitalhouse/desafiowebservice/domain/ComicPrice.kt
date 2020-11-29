package br.com.digitalhouse.desafiowebservice.domain

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ComicPrice(
    @SerializedName("type") val type: String,
    @SerializedName("price") val price: Double
) : Serializable
