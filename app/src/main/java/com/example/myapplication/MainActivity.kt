//Marcelo Calderon Laboratorio 3: Noticias

package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), NoticiasAdapter.NoticiasHolder.ClickListener {
    private var noticias: MutableList<Noticia> = mutableListOf()
    private var adapter = NoticiasAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAdd: Button = findViewById(R.id.btnAdd)
        btnAdd.setOnClickListener {
            //Noticia que aparece al presionar el boton "Refresh"

            val aux = Noticia("Avances en Vacuna del COVID-19",
                    "El despliegue de las primeras vacunas contra el COVID-19 es un éxito en Guatemala.",
                    "https://vdmedia.elpais.com/elpaistopaudio/20203/16/2020031621016747_1584339299_asset_still.png")
            adapter.addItem(aux)
        }
        //Facilita la adicion de los enlaces en los espacios correspondientes.
        //Noticia 1
        adapter.addItem(Noticia("Ministra de Salud encarcelada",
                "Las declaraciones de la Ministra de Salud Maria Amelia Flores le dan 10 años en prisión sin derecho a fianza.",
                "https://s3.amazonaws.com/lahora.prod/file/2020/06/19154405/WhatsApp-Image-2020-06-19-at-13.42.41.jpeg"))

        //Noticia 2
        adapter.addItem(Noticia("Rara Condición afecta a niños que padecieron de Covid-19",
                "1 en cada 5,000 niños que hayan padecido del COVID pueden padecer de esta aflicción fatal.",
                "https://ichef.bbci.co.uk/news/800/cpsprodpb/6319/production/_117696352_gettyimages-1216346407.jpg"))

        //Noticia 3
        adapter.addItem(Noticia("Maduro sufre de COVID-19 pero es salvado por el espíritu de Chavez.",
                "El mandatario de Venezuela ha sufrido de COVID-19 por 14 días y asegura haber visto a su compañero difunto, Hugo Chavez, en la camilla del hospital.",
                "https://static.dw.com/image/56258097_303.jpg"))

        //Noticia 4
        adapter.addItem(Noticia("Farándula: Neto Bran responde a Tweet de una manera inesperada.",
                "El alcalde de Mixco responde de una manera polémica a un casual comentario hecho por un usuario de la red social 'Twitter'",
                "https://s3.amazonaws.com/lahora.prod/file/2019/04/30135956/NAC43_9.jpg"))

        //Noticia 5
        adapter.addItem(Noticia("AMD hace importante avance en su tarjeta gráfica que podría quebrar a N-VIDIA",
                "La competencia de N-VIDIA, AMD, hace una tarjeta de video sumamente económica y poderosa que podría rivalizar a la GTX de su rival.",
                "https://hardzone.es/app/uploads-hardzone.es/2020/01/AMD-vs-NVIDIA-01.jpg"))

        val lista: RecyclerView = findViewById(R.id.listaNoticias)
        lista.layoutManager = LinearLayoutManager(this)
        lista.adapter = adapter
    }

    override fun onItemClicked(position: Int) {
        adapter.removeItem(position)
    }

    override fun onItemLongClicked(position: Int): Boolean {
        val aux = Noticia(
                "Actualizado",
                "Actualizado",
                "https://lh3.googleusercontent.com/proxy/LgR7_wB39LyVAVkmqnVIkjZ-7Lnm-eB4rW6f_DadzNohhvNO9JNVWznhzj3UBs8IAovzghYj5Ti298HLQSW4wW1Ewc4HBQQ8leajsDcKEQ-2RtB1lY-fQd-yS6ePHJCtP_R_XII"
        )
        adapter.updateItem(position, aux)
        return true
    }
}