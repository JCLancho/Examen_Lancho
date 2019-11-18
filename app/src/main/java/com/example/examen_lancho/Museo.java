package com.example.examen_lancho;

public class Museo {

    private String museo;
    private String localidad;
    private String url;
    private int imagen;

    public Museo(String museo, String localidad, String url, int imagen) {
        this.museo = museo;
        this.localidad = localidad;
        this.url = url;
        this.imagen = imagen;
    }

    public String getMuseo() {
        return museo;
    }

    public void setMuseo(String museo) {
        this.museo = museo;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }


}
