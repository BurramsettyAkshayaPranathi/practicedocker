package com.klef.soa.service;

import java.util.List;

import com.klef.soa.entity.Country;

public interface CountryService {

Country addCountry(Country country);
Country updateCountry(Country c);
String deleteCountryById(Long id);
List<Country> displayAllCountry();
Country displayCountryById(Long id);
List<Country> displayCountryByName(String name);
List<Country> displayCountryByType(String type);
}

