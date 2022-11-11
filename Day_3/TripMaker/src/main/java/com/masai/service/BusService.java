package com.masai.service;

import java.util.List;

import com.masai.exception.BusException;
import com.masai.exception.PackageException;
import com.masai.model.Bus;

public interface BusService {

	public Bus addAnewBus(Bus bus) throws BusException;
	
	public Bus deleteBusById(Integer busId) throws BusException;
	
	public Bus searchBusById(Integer busId) throws BusException;
	
	public Bus updateBus(Bus bus) throws BusException;
	
	public List<Bus> getAllBuses() throws BusException;
}
