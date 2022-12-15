package com.example.myapplication;

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdaptadorTitulares2(private val datos: Array<Titular>) :
    RecyclerView.Adapter<AdaptadorTitulares2.TitularesViewHolder>() {
    class TitularesViewHolder(val item: View) : RecyclerView.ViewHolder(item) {
        val lblTitulo = item.findViewById(R.id.lblTitulo) as TextView
        val lblSubtitulo = item.findViewById(R.id.lblSubtitulo) as TextView
        fun bindTitular(titular: Titular){
            lblTitulo.text = titular.titulo
            lblSubtitulo.text = titular.subtitulo
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TitularesViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.layout_dades, parent, false) as LinearLayout
        return TitularesViewHolder(item)
    }
    override fun onBindViewHolder(holder: TitularesViewHolder, position: Int) {
        val titular = datos[position]
        holder.bindTitular(titular)
    }
    override fun getItemCount() = datos.size
}
