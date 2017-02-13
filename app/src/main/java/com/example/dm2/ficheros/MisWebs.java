package com.example.dm2.ficheros;

public class MisWebs {
    private String nombre;
    private String url;
    private String id;

    public MisWebs(String nombre, String url, String id) {
        this.nombre = nombre;
        this.url = url;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUrl() {
        return url;
    }

    public String getId() {
        return id;
    }
}
