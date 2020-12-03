package com.ofr.service;

import java.util.List;
import java.util.Optional;

import com.ofr.exception.AddLandlordException;
import com.ofr.exception.LandlordNotFoundException;
import com.ofr.model.Landlord;

public interface LandlordService {
	
	public Landlord addLandlord(Landlord landlord) throws AddLandlordException;
	public Landlord updateLandlord(Landlord landlord) throws LandlordNotFoundException;
	public Landlord deleteLandlord(Landlord landlord) throws LandlordNotFoundException;
	public Optional<Landlord> viewLandlord(Integer landlordId) throws LandlordNotFoundException;
	public List<Landlord> viewAllLandlord();

	

}
