package br.com.digitalhouse.desafiowebservice.service

import br.com.digitalhouse.desafiowebservice.BuildConfig
import br.com.digitalhouse.desafiowebservice.domain.ApiResponse
import br.com.digitalhouse.desafiowebservice.domain.Comic
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelService {

    @GET("characters/{characterId}/comics")
    suspend fun getComicsFromCharacter (
        @Path("characterId") characterId: Int = 1016181,
        @Query("apikey") apikey: String = BuildConfig.MARVEL_API_PUBLICKEY,
        @Query("ts") ts: Long,
        @Query("hash") hash: String
    ) : ApiResponse<Comic>
}

private val retrofit = Retrofit.Builder()
    .baseUrl("https://gateway.marvel.com/v1/public/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val marvelService = retrofit.create(MarvelService::class.java)