package com.example.tareamenu;

public class Artista {

    String descripcion;
    String web;

    Artista (String descripcion,String web){
        this.descripcion = descripcion;
        this.web = web;
    }

    public String GetDescripcion (){
        return this.descripcion;
    }

    public void SetDescripcion (String descripcion){
        this.descripcion = descripcion;
    }

    public String GetWeb (){
        return this.web;
    }

    public void SetWeb (String web){
        this.web = web;
    }
}
