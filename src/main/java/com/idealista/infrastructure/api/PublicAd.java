package com.idealista.infrastructure.api;

import java.util.List;

/**
 * Clase que se encarga de que el anuncio este publico
 * sus atributos son los siguientes
 */

public class PublicAd {

    private Integer id;
    private String typology;
    private String description;
    private List<String> pictureUrls;
    private Integer houseSize;
    private Integer gardenSize;

    //Aniadido constructor vacio
    public PublicAd() {
    }
    //Aniadido constructor con parametros
    public PublicAd(Integer id, String typology, String description, List<String> pictureUrls, Integer houseSize, Integer gardenSize) {
        this.id = id;
        this.typology = typology;
        this.description = description;
        this.pictureUrls = pictureUrls;
        this.houseSize = houseSize;
        this.gardenSize = gardenSize;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypology() {
        return typology;
    }

    public void setTypology(String typology) {
        this.typology = typology;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getPictureUrls() {
        return pictureUrls;
    }

    public void setPictureUrls(List<String> pictureUrls) {
        this.pictureUrls = pictureUrls;
    }

    public Integer getHouseSize() {
        return houseSize;
    }

    public void setHouseSize(Integer houseSize) {
        this.houseSize = houseSize;
    }

    public Integer getGardenSize() {
        return gardenSize;
    }

    public void setGardenSize(Integer gardenSize) {
        this.gardenSize = gardenSize;
    }

    //Aniadido el metodo toString
    @Override
    public String toString() {
        return "PublicAd{" +
                "id=" + id +
                ", typology='" + typology + '\'' +
                ", description='" + description + '\'' +
                ", pictureUrls=" + pictureUrls +
                ", houseSize=" + houseSize +
                ", gardenSize=" + gardenSize +
                '}';
    }

}
