package com.masai.service;

import java.util.List;

import com.masai.exception.RouteException;
import com.masai.model.Route;

public interface RouteService {

	public Route addAnewRoute(Route route) throws RouteException;
	
	public Route updateRoute(Route route) throws RouteException;
	
	public Route deleteRouteById(Integer routeId) throws RouteException;
	
	public Route searchRouteById(Integer routeId) throws RouteException;
	
	public List<Route> getAllRoutes() throws RouteException;
}
