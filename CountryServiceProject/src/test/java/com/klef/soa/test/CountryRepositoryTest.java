
package com.klef.soa.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import com.klef.soa.entity.Country;
import com.klef.soa.repository.CountryRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CountryRepositoryTest 
{
    @Autowired
    private CountryRepository repository;

    @Test
    void testFindAllCountries() 
    {
        List<Country> countries = repository.findAll();
        // more than one assert should pass
        assertNotNull(countries);
        assertFalse(countries.isEmpty());
        System.out.println("Total Countries: " + countries.size());
    }

    @Test
    void testFindCountryById() 
    {
        Optional<Country> country = repository.findById(2L);
        assertTrue(country.isPresent());
        assertEquals(2L, country.get().getCountryId());
        System.out.println("Country ID: " + country.get().getCountryId());
        System.out.println("Name: " + country.get().getName());
    }

    @Test
    void testFindCountryByName() 
    {
        List<Country> countries = repository.findByName("India");
        assertNotNull(countries);
        assertFalse(countries.isEmpty());
        System.out.println("Country Name: " + countries);
    }

    @Test
    void testFindCountryByType() 
    {
        List<Country> countries = repository.findByType("Asia");
        assertNotNull(countries);
        assertFalse(countries.isEmpty());
        System.out.println("Country Type: " + countries);
    }

 

    @Test
    void testCountryDetails() 
    {
        Optional<Country> country = repository.findById(2L);
        assertTrue(country.isPresent());
        Country foundCountry = country.get();
        assertNotNull(foundCountry.getName());
        assertNotNull(foundCountry.getType());
        assertNotNull(foundCountry.getLocation());
        System.out.println("Name: " + foundCountry.getName());
        System.out.println("Type: " + foundCountry.getType());
        System.out.println("Location: " + foundCountry.getLocation());
    }

    @Test
    void testTotalCountryCount() 
    {
        long count = repository.count();
        assertEquals(2L, count);
    }
}
