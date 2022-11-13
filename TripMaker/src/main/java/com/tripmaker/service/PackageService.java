package com.tripmaker.service;

import java.util.List;

import com.tripmaker.exception.LoginException;
import com.tripmaker.exception.PackageException;
import com.tripmaker.model.Package;

public interface PackageService {
	
	public Package addPackage(Package packages, String key)throws PackageException, LoginException;
	public String deletePackage(Integer packageId, String key)throws LoginException;
	public Package searchPackage(Integer packageId, String key)throws LoginException, PackageException;
	public List<Package> viewAllPackage(String key)throws LoginException;

}
