package com.tripmaker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripmaker.exception.RouteException;
import com.tripmaker.model.Route;
import com.tripmaker.repository.RouteDao;

@Service
public class RouteServiceImpl implements RouteService {

	@Autowired
	RouteDao routeDao;

	@Override
	public Route addRoute(Route route) {
		Route route2 = routeDao.save(route);
		return route2;
	}

	@Override
	public Route updateRoute(Integer routeId, Integer busId) throws RouteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Route removeRoute(int routeId) throws RouteException {
		Optional<Route> rOptional = routeDao.findById(routeId);
		if (!rOptional.isPresent()) {
			throw new RouteException("This Route is not present in database to delete.");
		}
		routeDao.delete(rOptional.get());
		return rOptional.get();
	}

	@Override
	public Route searchRoute(int routeId) throws RouteException {
		Optional<Route> rOptional = routeDao.findById(routeId);
		if (!rOptional.isPresent()) {
			throw new RouteException("The Route you are searching is not present in database.");
		}
		return rOptional.get();
	}

	@Override
	public List<Route> viewRouteList() throws RouteException {
		List<Route> lRoute = routeDao.findAll();
		if (lRoute.isEmpty()) {
			throw new RouteException("No route is there in database to show.");
		}
		return lRoute;
	}

}
