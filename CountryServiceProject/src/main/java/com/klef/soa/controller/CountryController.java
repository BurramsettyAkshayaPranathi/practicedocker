package com.klef.soa.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.klef.soa.entity.Country;
import com.klef.soa.service.CountryService;

@RestController
@RequestMapping("/country")
public class CountryController {
	
	@Autowired
	private CountryService service;
	@GetMapping("/")
	public String test(){
		return "Test";
		
	}
	@PostMapping("/add") 
	public ResponseEntity<Country> addCountry(@RequestBody Country c) 
	{ 
		Country country = service.addCountry(c); 
		return ResponseEntity.status(201).body(country); 
	}
	@GetMapping("/displayall")
    public ResponseEntity<List<Country>> displayAllCountries() {
        List<Country> countries = service.displayAllCountry();
        return ResponseEntity.status(200).body(countries);
    }
	   @GetMapping("/displaybyid")
	    public ResponseEntity<?> displayCountryById(@RequestParam Long id) {
	        Country country = service.displayCountryById(id);

	        if (country != null) {
	            return ResponseEntity.status(200).body(country);
	        } else {
	            return ResponseEntity.status(404).body("Country ID Not Found");
	        }
	    }
	   @PutMapping("/update")
	    public ResponseEntity<?> updateCountry(@RequestBody Country country) {
	        Country c = service.updateCountry(country);

	        if (c != null) {
	            return ResponseEntity.ok(c);
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Country ID Not Found");
	        }
	    }
	   @DeleteMapping("/delete/{id}")
	    public ResponseEntity<String> deleteCountryById(@PathVariable Long id) {
	        String message = service.deleteCountryById(id);
	        return new ResponseEntity<>(message, HttpStatus.OK);
	    }

	    // Display Country By Name
	    @GetMapping("/displaybyname/{name}")
	    public ResponseEntity<List<Country>> displayCountryByName(@PathVariable String name) {
	        List<Country> countries = service.displayCountryByName(name);
	        return ResponseEntity.status(200).body(countries);
	    }

	    // Display Country By Type
	    @GetMapping("/displaybytype/{type}")
	    public ResponseEntity<List<Country>> displayCountryByType(@PathVariable String type) {
	        List<Country> countries = service.displayCountryByType(type);
	        return ResponseEntity.status(200).body(countries);
	    }

}
