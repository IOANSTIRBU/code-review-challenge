package com.idealista.infrastructure.api;

import java.util.List;

import com.idealista.application.AdsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController


/**
 * Controller Rest que comunica con el servicio de anuncios es decir "adsService".
 */
public class AdsController {

    @Autowired
    private AdsService adsService;

    /**
     * Creamos un Contructor con el Controller para que se inicialize el servicio
     * @param adsService Tiene como parametro adsService
     */
    public AdsController(AdsService adsService) {
        this.adsService = adsService;
    }

    /**
     * Método que se conecta con la API a través del método Get
     * Nos devuelve una respuesta OK que es el numero 200 al
     * encontrar el método de findQualityAds()
     * @return devuelve una List de QualityAd
     */

    @GetMapping("/ads/quality")
    public ResponseEntity<List<QualityAd>> qualityListing() {
        return ResponseEntity.ok(adsService.findQualityAds());
    }

    /**
     * Método que se conecta con la API a través del método Get,
     * y nos devuelve una respuesta OK que es el numero 200 al
     * encontrar el metodo de ->findPublicAds()
     * @return Devuelve una List de PublicAd
     */

    @GetMapping("/ads/public")
    public ResponseEntity<List<PublicAd>> publicListing() {
        return ResponseEntity.ok(adsService.findPublicAds());
    }

    /**
     * Método que se conecta con la API a través del método Get,
     * y nos devuelve como respuesta accepted que es el numero 202
     * @return No devuelve nada en este metodo
     */
    @GetMapping("/ads/score")
    public ResponseEntity<Void> calculateScore() {
        adsService.calculateScores();
        return ResponseEntity.accepted().build();
    }
}
