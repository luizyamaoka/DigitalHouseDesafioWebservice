package br.com.digitalhouse.desafiowebservice.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import br.com.digitalhouse.desafiowebservice.R
import br.com.digitalhouse.desafiowebservice.adapter.ComicAdapter
import br.com.digitalhouse.desafiowebservice.domain.Comic
import kotlinx.android.synthetic.main.activity_comics_list.*

class ComicsListActivity : AppCompatActivity() {

    private val adapter = ComicAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comics_list)

        rvComics.adapter = adapter
        rvComics.layoutManager = GridLayoutManager(this, 3)

        adapter.addComics(arrayListOf(
            Comic(1, "1"),
            Comic(2, "1"),
            Comic(3, "1"),
            Comic(4, "1"),
            Comic(5, "1"),
            Comic(6, "1"),
            Comic(7, "1"),
            Comic(8, "1"),
            Comic(9, "1")))

    }
}