package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RecycleViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_recycleview);
        RecyclerView recView = (RecyclerView) findViewById(R.id.recView);
        List<Titular> datos = new ArrayList<>();

        for (int i = 0; i < 5; i++){
            datos.add(new Titular("I have ", i + " sides" ));
        }

        AdaptadorTitulares adaptador = new AdaptadorTitulares(datos);
        recView.setHasFixedSize(true);
        recView.setAdapter(adaptador);
        recView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recView.setLayoutManager(new GridLayoutManager(this, 3));

        Button insertar = (Button) findViewById(R.id.insertar);
        Button eliminar = (Button) findViewById(R.id.eliminar);
        Button moure = (Button) findViewById(R.id.moure);
        insertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datos.add(new Titular("I have", datos.size() + " sides"));
                AdaptadorTitulares adaptador = new AdaptadorTitulares(datos);
                recView.setAdapter(adaptador);
            }
        });

        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datos.remove(0);
                AdaptadorTitulares adaptador = new AdaptadorTitulares(datos);
                recView.setAdapter(adaptador);

            }
        });

        moure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int pos1 = random.nextInt(datos.size());
                int pos2 = random.nextInt(datos.size());
                Titular temp = datos.get(pos1);
                datos.set(pos1, datos.get(pos2));
                datos.set(pos2, temp);

                AdaptadorTitulares adaptador = new AdaptadorTitulares(datos);
                recView.setAdapter(adaptador);
            }
        });
    }
}
