package com.tripmaker.service;

import java.util.List;

import com.tripmaker.exception.BusException;
import com.tripmaker.exception.PackageException;
import com.tripmaker.model.Bus;

public interface BusService {

	public Bus addAnewBus(Bus bus) throws BusException;
	
	public Bus deleteBusById(Integer busId) throws BusException;
	
	public Bus searchBusById(Integer busId) throws BusException;
	
	public Bus updateBus(Bus bus) throws BusException;
	
	public List<Bus> getAllBuses() throws BusException;
}
