package com.idealista.domain;

import java.util.Objects;

/**
 * Clase para la Entidad de Picture con sus atributos siguientes:
 */
public class Picture {
    private Integer id;
    private String url;
    private Quality quality;

    /**
     Aniadimos el constructor vacío que es necesario por si no queremos crear un objeto con sus parametros
     */
    public Picture(){}

    /**
     * Constructor con parametros que indicará si tiene:
     * @param id identificador de la imagen
     * @param url A donde se dirigirá esta imagen
     * @param quality Calidad de la imagen
     */
    public Picture(Integer id, String url, Quality quality) {
        this.id = id;
        this.url = url;
        this.quality = quality;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Quality getQuality() {
        return quality;
    }

    public void setQuality(Quality quality) {
        this.quality = quality;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", quality=" + quality +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Picture picture = (Picture) o;
        return Objects.equals(id, picture.id) && Objects.equals(url, picture.url) && quality == picture.quality;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, url, quality);
    }


}
