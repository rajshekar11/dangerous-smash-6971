package com.tripmaker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tripmaker.exception.LoginException;
import com.tripmaker.exception.PackageException;
import com.tripmaker.model.Package;
import com.tripmaker.service.CustomerLoginService;
import com.tripmaker.service.PackageService;

@RestController
@RequestMapping("/package")
public class PackageController {
	
	@Autowired
	CustomerLoginService customerLoginService;
	
	@Autowired
	PackageService packageService;

	@PostMapping("/package")
	public Package addPacakge(@RequestBody Package packages, @RequestParam String key) throws LoginException, PackageException {
		
		Package addedpackage =  packageService.addPackage(packages, key);
		
		if(addedpackage != null) {
			return addedpackage;
		}
		else {
			throw new PackageException("Package cannot be added");
		}
	}
	
	@DeleteMapping("/packagedelete")
	public String deletePacakge(Integer packageId, @RequestParam String key) throws LoginException, PackageException {
		
		String message =  packageService.deletePackage(packageId, key);
		
			return message;
	}

	@PostMapping("/packagesearch")
	public Package searchPacakge(@RequestParam Integer packageId, @RequestParam String key) throws LoginException, PackageException {
	
		Package searchedpackage =  packageService.searchPackage(packageId, key);
	
		if(searchedpackage != null) {
			return searchedpackage;
		}
		else {
			throw new PackageException("No package is present");
		}
	}

	@PostMapping("/packageview")
	public List<Package> viewAllPacakge(@RequestParam String key) throws LoginException, PackageException {
	
		List<Package> packageResult =  packageService.viewAllPackage(key);
	
		if(!packageResult.isEmpty()) {
			return packageResult;
		}
		else {
			throw new PackageException("No package is present");
		}
	}
}
