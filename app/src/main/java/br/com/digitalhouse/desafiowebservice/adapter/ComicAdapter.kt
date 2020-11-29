package br.com.digitalhouse.desafiowebservice.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.digitalhouse.desafiowebservice.R
import br.com.digitalhouse.desafiowebservice.domain.Comic
import kotlinx.android.synthetic.main.item_comic.view.*

class ComicAdapter : RecyclerView.Adapter<ComicAdapter.ComicViewHolder>() {

    private val comics = arrayListOf<Comic>()

    class ComicViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val ivComicCapa : ImageView = view.ivComicCapa
        val tvComicNumero : TextView = view.tvComicNumero
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_comic, parent, false)
        return ComicViewHolder(view)
    }

    override fun getItemCount() = comics.size

    override fun onBindViewHolder(holder: ComicViewHolder, position: Int) {
        val comic = comics[position]

        holder.ivComicCapa.setImageResource(R.drawable.raster)
        holder.tvComicNumero.text = "#${comic.id}"
    }

    fun addComics(_comics: ArrayList<Comic>) {
        comics.addAll(_comics)
        notifyDataSetChanged()
    }

}
