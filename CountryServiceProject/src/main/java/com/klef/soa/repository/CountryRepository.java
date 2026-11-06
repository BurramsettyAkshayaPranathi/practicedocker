package com.klef.soa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.soa.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    List<Country> findByName(String name);

    List<Country> findByType(String type);
    

}