package com.ofr.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ofr.exception.AddLandlordException;
import com.ofr.exception.LandlordNotFoundException;
import com.ofr.model.Landlord;
import com.ofr.service.LandlordServiceImpl;

@RestController
@RequestMapping("/landlord")
@Validated
public class LandlordController {
	
	@Autowired
	LandlordServiceImpl landlordService;
	
	public LandlordServiceImpl getLandlordService() {
		return landlordService;
	}

	public void setLandlordService(LandlordServiceImpl landlordService) {
		this.landlordService = landlordService;
	}

	/*
	 * when add request is received, business logic for respective method is performed
	 * returns true if added
	 * 
	 */	
	@PostMapping("/add")
	public ResponseEntity<Boolean> add(@Valid @RequestBody Landlord landlord) throws AddLandlordException {
		getLandlordService().addLandlord(landlord);
		@SuppressWarnings({ "unchecked", "rawtypes" })
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		return responseEntity;
		
	}
	
	/*
	 * when update request is received, business logic for respective method is performed
	 * returns true if updated
	 * 
	 */
	
	@PutMapping("/update")
	public ResponseEntity<Landlord> update(@Valid @RequestBody Landlord landlord) throws LandlordNotFoundException {
		landlord = getLandlordService().updateLandlord(landlord);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		ResponseEntity<Landlord> responseEntity = new ResponseEntity(landlord, HttpStatus.OK);
		return responseEntity;
		
	}
	
	/*
	 * when remove request is received, business logic for respective method is performed
	 * returns true if removed
	 * 
	 */
	
	@DeleteMapping("/remove")
	public ResponseEntity<Boolean> deleteLandlord(@RequestBody Landlord landlord) throws LandlordNotFoundException {
		getLandlordService().deleteLandlord(landlord);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		return responseEntity;
		
	}
	
	/*
	 * when find request is received, business logic for respective method is performed
	 * returns landlord details by ID
	 * 
	 */
	
	@GetMapping("/find/{landlordId}")
	public ResponseEntity<Optional<Landlord>> viewById(@PathVariable("landlordId") Integer landlordId) throws LandlordNotFoundException {
		Optional<Landlord> landlord = getLandlordService().viewLandlord(landlordId);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		ResponseEntity<Optional<Landlord>> responseEntity = new ResponseEntity(landlord, HttpStatus.OK);
		return responseEntity;
		
	}
	
	/*
	 * when findAll request is received, business logic for respective method is performed
	 * returns list of landlords
	 * 
	 */
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Landlord>> viewAllLandlord() {
		List<Landlord> landlordList = getLandlordService().viewAllLandlord();
		@SuppressWarnings({ "rawtypes", "unchecked" })
		ResponseEntity<List<Landlord>> responseEntity = new ResponseEntity(landlordList, HttpStatus.OK);
		return responseEntity;
	}
	
	

}
