package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

//adaptador
public class NoticiasAdapter(var noticias: MutableList<Noticia> = mutableListOf()) : RecyclerView.Adapter<NoticiasAdapter.NoticiasHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticiasHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_noticia,parent, false)
        //Convertir el texto en una vista > lo que vamos a inflar
        return NoticiasHolder(view)
        //Retornamos una nueva instancia del folder de abajo
    }

    override fun getItemCount(): Int {
        return this.noticias.size
    }

    override fun onBindViewHolder(holder: NoticiasHolder, position: Int) {//Pasarle valores
        val actual : Noticia = this.noticias[position]//del objeto global se obtiene una posicion
        holder.bind(actual)
    }

    class NoticiasHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {//Constructor View Holder

        fun bind(noticia: Noticia) = with(itemView){
            val txtTitulo: TextView = findViewById(R.id.txtTitulo)
            val imagen: ImageView = findViewById(R.id.imagen)
            txtTitulo.text = noticia.titulo

            Picasso.get().load(noticia.imagen).into(imagen);
        }
    }
}