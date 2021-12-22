package com.idealista.application;

import com.idealista.domain.*;
import com.idealista.infrastructure.api.PublicAd;
import com.idealista.infrastructure.api.QualityAd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AdsServiceImpl implements AdsService {

    @Autowired
    private AdRepository adRepository;

    //Aniadido el Constructor con el parametro del Repositorio AdRepository
    public AdsServiceImpl(AdRepository adRepository) {
        this.adRepository = adRepository;
    }

    @Override
    public List<PublicAd> findPublicAds() {
        List<Ad> ads = adRepository.findRelevantAds();
        ads.sort(Comparator.comparing(Ad::getScore));

        List<PublicAd> result = new ArrayList<>();
        for (Ad ad: ads) {
            PublicAd publicAd = new PublicAd();
            publicAd.setDescription(ad.getDescription());
            publicAd.setGardenSize(ad.getGardenSize());
            publicAd.setHouseSize(ad.getHouseSize());
            publicAd.setId(ad.getId());
            publicAd.setPictureUrls(ad.getPictures().stream().map(Picture::getUrl).collect(Collectors.toList()));
            publicAd.setTypology(ad.getTypology().name());

            result.add(publicAd);
        }
        return result;
    }

    @Override
    public List<QualityAd> findQualityAds() {
        List<Ad> ads = adRepository.findIrrelevantAds();

        List<QualityAd> result = new ArrayList<>();
        for (Ad ad: ads) {
            QualityAd qualityAd = new QualityAd();
            qualityAd.setDescription(ad.getDescription());
            qualityAd.setGardenSize(ad.getGardenSize());
            qualityAd.setHouseSize(ad.getHouseSize());
            qualityAd.setId(ad.getId());
            qualityAd.setPictureUrls(ad.getPictures().stream().map(Picture::getUrl).collect(Collectors.toList()));
            qualityAd.setTypology(ad.getTypology().name());
            qualityAd.setScore(ad.getScore());
            qualityAd.setIrrelevantSince(ad.getIrrelevantSince());

            result.add(qualityAd);
        }

        return result;
    }

    @Override
    public void calculateScores() {
        adRepository
                .findAllAds()
                .forEach(this::calculateScore);
    }



    private void calculateScore(Ad ad) {
        int score = Constants.ZERO;

        //Calcular puntuación por fotos
        if (ad.getPictures().isEmpty()) {
            score -= Constants.TEN; //Si no hay fotos restamos 10 puntos
        } else {
            for (Picture picture: ad.getPictures()) {
                if(Quality.HD.equals(picture.getQuality())) {
                    score += Constants.TWENTY; //Cada foto en alta definición aporta 20 puntos
                } else if(Quality.SD.equals(picture.getQuality())){
                    score += Constants.TEN; //Cada foto normal aporta 10 puntos
                }else{
                    System.out.println("No se ha podido realizar ninguna accion");
                }
            }
        }

        //Calcular puntuación por descripción
        Optional<String> optDesc = Optional.ofNullable(ad.getDescription());

        if (optDesc.isPresent()) {
            String description = optDesc.get();

            //Si la descripcion no esta vacia se le sumaran 5 puntos
            if (!description.isEmpty()) {
                score += Constants.FIVE;
            }

            //Esto lo que hara es contar el numero de palabras
            List<String> wds = Arrays.asList(description.split(" ")); //número de palabras

            if (Typology.FLAT.equals(ad.getTypology())) {
                if (wds.size() >= Constants.TWENTY && wds.size() <= Constants.FORTY_NINE) {
                    score += Constants.TEN;
                }
                //Si la descripcion tiene 50 o mas palabras se le pondra 30 puntos
                if (wds.size() >= Constants.FIFTY)
                    score += Constants.THIRTY;
            }
                //Si el chalet tiene mas de 50 palabras se le aniadira 20 puntos
            if(Typology.CHALET.equals(ad.getTypology())){
                    if (wds.size() >= Constants.FIFTY)
                        score += Constants.TWENTY;
            }





            //Cada vez que aparezcan estas palabras se le aniadira 5 puntos
            if (wds.contains("Luminoso")) score += Constants.FIVE;
            if (wds.contains("Nuevo")) score += Constants.FIVE;
            if (wds.contains("Céntrico")) score += Constants.FIVE;
            if (wds.contains("Reformado")) score += Constants.FIVE;
            if (wds.contains("Ático")) score += Constants.FIVE;
        }

        //Calcular puntuación que esta completo
        if (ad.isComplete()) {
            score = Constants.FORTY;
        }

        ad.setScore(score);

        if (ad.getScore() < Constants.ZERO) {
            ad.setScore(Constants.ZERO);
        }

        if (ad.getScore() > Constants.ONE_HUNDRED) {
            ad.setScore(Constants.ONE_HUNDRED);
        }

        //Si el anuncio es irrelevante se le aniadiran 40 puntos
        if (ad.getScore() < Constants.FORTY) {
            ad.setIrrelevantSince(new Date());
        } else {
            ad.setIrrelevantSince(null);
        }

        //En el repositorio de anuncios guardamos todos los datos de los anuncios
        adRepository.save(ad);
    }


}
