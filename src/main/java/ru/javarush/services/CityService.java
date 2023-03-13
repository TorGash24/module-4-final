package ru.javarush.services;

import ru.javarush.domain.City;
import ru.javarush.repositories.CityRepository;

import java.util.List;

public class CityService {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> fetchDat()  {
        //
        return null;
    }
}
