package com.idealista.domain;

import java.util.List;

/**
 * Interface AdRepository
 * que incluye los siguientes metodos:
 */
public interface AdRepository {

    /**
     * Método que devuelve una List de anuncios(Ad) es decir devuelve una lista con
     * todos los anuncios
     * @return List findAllAds()
     */
    List<Ad> findAllAds();

    /**
     * Metodo que no devuelve nada y con el metodo save() guarda un anuncio
     * @param ad
     */
    void save(Ad ad);

    /**
     * Método que devuelve una List de anuncios que sean relevantes
     * @return List findRelevantAds()
     */
    List<Ad> findRelevantAds();

    /**
     * Método que devuelve una List de anuncios que sean irrelevantes
     * @return List findIrrelevantAds()
     */
    List<Ad> findIrrelevantAds();
}
