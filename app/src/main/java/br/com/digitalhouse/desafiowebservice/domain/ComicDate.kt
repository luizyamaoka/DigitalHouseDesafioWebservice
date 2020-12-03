package br.com.digitalhouse.desafiowebservice.domain

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.*

class ComicDate (
    @SerializedName("date") val dateString: String,
    @SerializedName("type") val type: String
) : Serializable {

    fun getDate() : Date? {
        try {
            return SimpleDateFormat("YYYY-MM-dd").parse(dateString.substring(0, 10))
        } catch (e: Exception) {
            return null
        }
    }
}