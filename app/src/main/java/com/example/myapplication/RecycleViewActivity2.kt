package com.example.myapplication;


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecycleViewActivity2 : AppCompatActivity() {
    private lateinit var recView : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_recycleview)
        recView = findViewById(R.id.recView)
        val datos =Array(50) { i -> Titular("Titulo $i", "Subtítulo Item $i") }
        val adaptador = AdaptadorTitulares2(datos)
        recView.setHasFixedSize(true)
        recView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recView.adapter = adaptador
    }
}