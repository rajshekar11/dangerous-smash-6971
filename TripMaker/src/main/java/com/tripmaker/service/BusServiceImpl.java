package com.tripmaker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripmaker.exception.BusException;
import com.tripmaker.model.Bus;
import com.tripmaker.repository.BusRepo;
import com.tripmaker.repository.RouteDao;
import com.tripmaker.repository.UserDao;


@Service
public class BusServiceImpl implements BusService {
	
	@Autowired
	private RouteDao routeRepo;
	
	@Autowired
	private BusRepo busRepo;
	
	@Autowired
	private UserDao userRepo;

	@Override
	public Bus addAnewBus(Bus bus) throws BusException {
		Optional<Bus> opt= busRepo.findById(bus.getBusId());
		
		if(opt.isPresent()) {
			throw new BusException("Bus already present in database");
		}
		return busRepo.save(bus);
	}

	@Override
	public Bus deleteBusById(Integer busId) throws BusException {
		Optional<Bus> opt= busRepo.findById(busId);
		if(opt.isPresent()) {
			Bus bus=opt.get();
			busRepo.delete(bus);
			return bus;
		}
		throw new BusException("There are no bus with id: "+busId);
	}

	@Override
	public Bus searchBusById(Integer busId) throws BusException {
		Optional<Bus> opt= busRepo.findById(busId);
		if(opt.isPresent()) {
			return opt.get();
		}
		throw new BusException("There are no busses with id: "+busId);
	}

	@Override
	public List<Bus> getAllBuses() throws BusException {
		List<Bus> li= busRepo.findAll();
		if(li.size()==0) {
			throw new BusException("There are no busses available currently");
		}
		return li;
	}

	@Override
	public Bus updateBus(Bus bus) throws BusException {
		Optional<Bus> opt= busRepo.findById(bus.getBusId());
		if(opt.isPresent()) {
			return busRepo.save(bus);
		}
		throw new BusException("There are no busses with id: "+bus.getBusId());
	}

}
