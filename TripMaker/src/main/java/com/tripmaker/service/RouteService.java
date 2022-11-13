
package com.tripmaker.service;

import java.util.List;

import com.tripmaker.exception.BusException;
import com.tripmaker.exception.RouteException;
import com.tripmaker.model.Route;

public interface RouteService {

	Route addRoute(Route route);

	Route updateRoute(Integer routeId, Integer busId) throws RouteException, BusException;

	public Route removeRoute(int routeId) throws RouteException;

	public Route searchRoute(int routeId) throws RouteException;

	public List<Route> viewRouteList() throws RouteException;
}