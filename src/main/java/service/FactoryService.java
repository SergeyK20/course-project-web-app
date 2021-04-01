package service;

import service.serviceActor.ServiceAddActor;
import service.serviceActor.ServiceDeleteActor;
import service.serviceActor.ServiceEditActor;
import service.serviceActor.ServiceGetActor;
import service.serviceCountry.ServiceAddCountry;
import service.serviceCountry.ServiceDeleteCountry;
import service.serviceCountry.ServiceEditCountry;
import service.serviceCountry.ServiceGetCountry;
import service.serviceFilm.*;
import service.serviceGenre.ServiceAddGenre;
import service.serviceGenre.ServiceDeleteGenre;
import service.serviceGenre.ServiceEditGenre;
import service.serviceGenre.ServiceGetGenre;

public enum FactoryService {
    GET_FILM(new ServiceGetFilm()),
    DELETE_FILM(new ServiceDeleteFilm()),
    EDIT_BEFORE_FILM(new ServiceBeforeEditFilm()),
    ADD_BEFORE_FILM(new ServiceBeforeAddFilm()),
    EDIT_FILM(new ServiceEditFilm()),
    ADD_FILM(new ServiceAddFilm()),
    FILTER_FILM(new ServiceGetFilteredFIlm()),
    GET_ACTOR(new ServiceGetActor()),
    DELETE_ACTOR(new ServiceDeleteActor()),
    EDIT_ACTOR(new ServiceEditActor()),
    ADD_ACTOR(new ServiceAddActor()),
    GET_GENRE(new ServiceGetGenre()),
    DELETE_GENRE(new ServiceDeleteGenre()),
    ADD_GENRE(new ServiceAddGenre()),
    EDIT_GENRE(new ServiceEditGenre()),
    GET_COUNTRY(new ServiceGetCountry()),
    ADD_COUNTRY(new ServiceAddCountry()),
    EDIT_COUNTRY(new ServiceEditCountry()),
    DELETE_COUNTRY(new ServiceDeleteCountry());

    private Service service;

    private FactoryService(Service service){
        this.service = service;
    }

    public Service getService(){
        return service;
    }
}
