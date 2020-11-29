package br.com.digitalhouse.desafiowebservice.domain

import com.google.gson.annotations.SerializedName
import java.util.*

data class ComicDate(
    @SerializedName("date") val date: Date,
    @SerializedName("type") val type: String
)