package com.idealista.application;

import com.idealista.infrastructure.api.PublicAd;
import com.idealista.infrastructure.api.QualityAd;

import java.util.List;
/**
 * Interface AdsService
 * que incluye los metodos siguientes:
 */
public interface AdsService {
    /**
     * Método que devuelve una List de anuncios (PublicAd) es decir
     * devuelve una lista con todos los anuncios que esten publicos
     * @return findPublicAds()
     */
    List<PublicAd> findPublicAds();
    /**
     * Método que devuelve una List de anuncios (PublicAd) es decir
     * devuelve una lista con todos los anuncios que tengan calidad
     * @return findQualityAds()
     */

    List<QualityAd> findQualityAds();
    /**
     * Método que no devuelve nada y
     * calcula los puntos de cada anuncio
     */
    void calculateScores();
}
