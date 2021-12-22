package com.idealista.infrastructure.persistence;

/**
 * Clase que indica las especificaciones de la imagen en el anuncio
 */
public class PictureVO {

    private Integer id;
    private String url;
    private String quality;

    //Se aniade un constructor vacio por sino queremos crear un objeto con atributos
    public PictureVO() {}

    public PictureVO(Integer id, String url, String quality) {
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

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    //Aniadido metodo de toString()
    @Override
    public String toString() {
        return "PictureVO{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", quality='" + quality + '\'' +
                '}';
    }

}
