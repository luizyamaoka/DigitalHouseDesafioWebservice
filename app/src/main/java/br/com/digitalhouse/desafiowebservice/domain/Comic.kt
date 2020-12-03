package br.com.digitalhouse.desafiowebservice.domain

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Comic(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String?,
    @SerializedName("pageCount") val pageCount: Int?,
    @SerializedName("dates") @Expose val dates: ArrayList<ComicDate>,
    @SerializedName("prices") @Expose val prices: ArrayList<ComicPrice>,
    @SerializedName("images") @Expose val images: ArrayList<ComicImage>
) : Serializable {

}
