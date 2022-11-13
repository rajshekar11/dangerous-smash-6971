package com.tripmaker.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tripmaker.exception.RouteException;
import com.tripmaker.model.Customer;
import com.tripmaker.model.CustomerSigninDTO;
import com.tripmaker.model.Route;
import com.tripmaker.service.CustomerLoginService;
import com.tripmaker.service.CustomerService;
import com.tripmaker.service.RouteService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	@Autowired
	CustomerLoginService customerLoginService;
	@Autowired 
	RouteService routeService;

	@PostMapping("/")
	public Customer saveCustomer(@Valid @RequestBody CustomerSigninDTO customer) {
		return customerService.createCustomer(customer);
	}

	// to update customer by passing key
	@PutMapping("/update")
	public Customer updateCustomer(@RequestBody CustomerSigninDTO customer,
			@RequestParam(required = false) String key) {
		customerLoginService.isLoggedInByUUID(key);
		return customerService.updateCustomer(customer, key);
	}

	@GetMapping("/routes")
	public ResponseEntity<List<Route>> getAllRoutes() throws RouteException{
		List<Route> routeList = routeService.viewRouteList();
		return new ResponseEntity<List<Route>>(routeList,HttpStatus.OK);
	}

}