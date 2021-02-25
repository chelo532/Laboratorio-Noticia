package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var noticias: MutableList<Noticia> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        noticias.add(Noticia("Prueba", "https://play.google.com/store/apps/details?id=com.researchmobile.guatepreviene&hl=af&gl=US"))//0

        val adaptador: NoticiasAdapter = NoticiasAdapter(noticias)//nueva instancia de noticias

        val listaNoticias: RecyclerView = findViewById(R.id.listaNoticias)
            listaNoticias.layoutManager = LinearLayoutManager(this)//orientacion y forma que se muestran los elementos
        listaNoticias.adapter = adaptador

    }
}