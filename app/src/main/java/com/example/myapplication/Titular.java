package com.example.myapplication;

public class Titular {
    String titulo = "";
    String subtitulo = "";
    public Titular(String titulo, String subtitulo){
        this.titulo = titulo;
        this.subtitulo = subtitulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }
}
