package com.example.myapplication;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdaptadorTitulares extends RecyclerView.Adapter<AdaptadorTitulares.ViewHolder> {
    private final List<Titular> datos;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView lblTitulo;
        TextView lblSubtitulo;
        public ViewHolder(View view){
            super(view);
            lblTitulo = (TextView) view.findViewById(R.id.lblTitulo);
            lblSubtitulo = (TextView) view.findViewById(R.id.lblSubtitulo);
        }
        public TextView getLblTitulo(){
            return lblTitulo;
        }
        public TextView getLblSubtitulo(){
            return lblSubtitulo;
        }
    }

    public AdaptadorTitulares(List<Titular> datos){
        this.datos = datos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_dades, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, @SuppressLint("RecyclerView") int position) {
        viewHolder.getLblTitulo().setText(datos.get(position).getTitulo());
        viewHolder.getLblSubtitulo().setText(datos.get(position).getSubtitulo());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(datos.get(position).titulo, datos.get(position).subtitulo);
            }
        });
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }
}
