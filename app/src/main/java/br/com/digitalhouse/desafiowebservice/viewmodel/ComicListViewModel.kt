package br.com.digitalhouse.desafiowebservice.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.digitalhouse.desafiowebservice.BuildConfig
import br.com.digitalhouse.desafiowebservice.domain.Comic
import br.com.digitalhouse.desafiowebservice.service.MarvelService
import kotlinx.coroutines.launch
import java.lang.Exception
import java.security.MessageDigest
import kotlin.text.Charsets.UTF_8

class ComicListViewModel(val marvelService: MarvelService) : ViewModel() {

    val listComics = MutableLiveData<ArrayList<Comic>>()
    val apiError = MutableLiveData<String>()

    fun getComics(offset: Int = 0, limit: Int = 20) {
        viewModelScope.launch {
            try {
                val ts = System.currentTimeMillis()
                listComics.value = marvelService.getComicsFromCharacter(
                    ts = ts,
                    hash = getHash(ts),
                    offset = offset,
                    limit = limit
                ).data.results
            } catch (e: Exception) {
                Log.e("ComicListViewModel", e.toString())
                apiError.value = e.toString()
            }
        }
    }

    fun md5(str: String): ByteArray = MessageDigest.getInstance("MD5").digest(str.toByteArray(UTF_8))
    fun ByteArray.toHex() = joinToString("") { "%02x".format(it) }

    fun getHash(ts: Long) : String {
        return md5("${ts}${BuildConfig.MARVEL_API_PRIVATEKEY}${BuildConfig.MARVEL_API_PUBLICKEY}").toHex()
    }


}