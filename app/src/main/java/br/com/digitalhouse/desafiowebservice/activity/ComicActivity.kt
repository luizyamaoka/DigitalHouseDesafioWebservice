package br.com.digitalhouse.desafiowebservice.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import br.com.digitalhouse.desafiowebservice.R
import br.com.digitalhouse.desafiowebservice.domain.Comic
import br.com.digitalhouse.desafiowebservice.extension.toFormatted
import br.com.digitalhouse.desafiowebservice.extension.toPrice
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_comic.*

class ComicActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comic)

        val comic = intent.getSerializableExtra("comic") as Comic

        tvTitulo.text = comic.title
        tvDescricao.text = comic.description
        tvPaginas.text = comic.pageCount.toString()
        tvDataPublicacao.text = comic.dates.filter { it.type == "onsaleDate" }.first().date.toFormatted()
        tvPreco.text = comic.prices.filter { it.type == "printPrice" }.first().price.toPrice()

        Glide.with(this).asBitmap()
            .load(comic.images.first().toString())
            .into(ivComicCover)

        Glide.with(this).asBitmap()
            .load(comic.images.first().toString())
            .into(ivCover)

        toolbar.setNavigationOnClickListener {
            this.onBackPressed()
        }

        Log.i("ComicActivity", comic.toString())
    }
}