package br.com.digitalhouse.desafiowebservice.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import br.com.digitalhouse.desafiowebservice.R
import br.com.digitalhouse.desafiowebservice.adapter.ComicAdapter
import br.com.digitalhouse.desafiowebservice.domain.Comic
import br.com.digitalhouse.desafiowebservice.service.marvelService
import br.com.digitalhouse.desafiowebservice.viewmodel.ComicListViewModel
import kotlinx.android.synthetic.main.activity_comics_list.*

class ComicsListActivity : AppCompatActivity() {

    private val adapter = ComicAdapter()
    private val viewModel by viewModels<ComicListViewModel>() {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return ComicListViewModel(marvelService) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comics_list)

        rvComics.adapter = adapter
        rvComics.layoutManager = GridLayoutManager(this, 3)

        viewModel.listComics.observe(this, Observer {
            adapter.addComics(it)
            Log.i("ComicsListActivity", it.toString())
        })

        viewModel.getComics()

//        adapter.addComics(arrayListOf(
//            Comic(1, "1"),
//            Comic(2, "1"),
//            Comic(3, "1"),
//            Comic(4, "1"),
//            Comic(5, "1"),
//            Comic(6, "1"),
//            Comic(7, "1"),
//            Comic(8, "1"),
//            Comic(9, "1")))
    }
}