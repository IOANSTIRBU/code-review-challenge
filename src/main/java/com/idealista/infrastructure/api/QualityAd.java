package com.idealista.infrastructure.api;

import java.util.Date;
import java.util.List;

/**
 * Clase que se encarga de que el anuncio tenga calidad
 * y tiene los siguientes atributos
 */

public class QualityAd {

    private Integer id;
    private String typology;
    private String description;
    private List<String> pictureUrls;
    private Integer houseSize;
    private Integer gardenSize;
    private Integer score;
    private Date irrelevantSince;

    /**
     * Aniadido el Constructor vacio
     */
    public QualityAd(){}


    /**
     * Aniadido el Constructor con todos los parametros
     */
    public QualityAd(Integer id, String typology, String description, List<String> pictureUrls, Integer houseSize, Integer gardenSize, Integer score, Date irrelevantSince) {
        this.id = id;
        this.typology = typology;
        this.description = description;
        this.pictureUrls = pictureUrls;
        this.houseSize = houseSize;
        this.gardenSize = gardenSize;
        this.score = score;
        this.irrelevantSince = irrelevantSince;
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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Date getIrrelevantSince() {
        return irrelevantSince;
    }

    public void setIrrelevantSince(Date irrelevantSince) {
        this.irrelevantSince = irrelevantSince;
    }

    //Aniadido el metodo toString()
    @Override
    public String toString() {
        return "QualityAd{" +
                "id=" + id +
                ", typology='" + typology + '\'' +
                ", description='" + description + '\'' +
                ", pictureUrls=" + pictureUrls +
                ", houseSize=" + houseSize +
                ", gardenSize=" + gardenSize +
                ", score=" + score +
                ", irrelevantSince=" + irrelevantSince +
                '}';
    }
}
