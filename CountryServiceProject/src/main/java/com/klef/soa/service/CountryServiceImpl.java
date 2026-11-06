
package com.klef.soa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.entity.Country;
import com.klef.soa.repository.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService{
	  @Autowired
	  private CountryRepository repo;

	@Override
	public Country addCountry(Country country) {
		// TODO Auto-generated method stub
		return repo.save(country);
	}

	@Override
	public Country updateCountry(Country c) {
		// TODO Auto-generated method stub
		Optional <Country> optional=repo.findById(c.getCountryId());
		if(optional.isPresent()) {
			Country country=optional.get();
			country.setName(c.getName());
			country.setType(c.getType());
			return   repo.save(country);
		}
		else
			{
			return null;
			}
			}

	@Override
	public String deleteCountryById(Long id) {
		// TODO Auto-generated method stub
		boolean status=repo.existsById(id);
	    if(status) {
	      repo.deleteById(id);
	      return "Country Deleted Successfully";
	    }else {
	      return ""
	      		+ "Country Id not found";
	    }
	}

	@Override
	public List<Country> displayAllCountry() {
		// TODO Auto-generated method stub
		  return repo.findAll();
	}

	@Override
	public Country displayCountryById(Long id) {
		// TODO Auto-generated method stub
		  return   repo.findById(id).orElse(null);
	}

	@Override
	public List<Country> displayCountryByName(String name) {
		// TODO Auto-generated method stub
		return repo.findByName(name);
	}

	@Override
	public List<Country> displayCountryByType(String type) {
		// TODO Auto-generated method stub
		return repo.findByType(type);
	}

    // TODO Auto-generated method stub
  }
