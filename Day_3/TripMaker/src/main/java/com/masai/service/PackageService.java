package com.masai.service;

import java.util.List;

import com.masai.exception.PackageException;

public interface PackageService {

	public Package addAnewPackage(Package pkg) throws PackageException;
	
	public Package deletePackageById(Integer packageId) throws PackageException;
	
	public Package searchPackageById(Integer packageId) throws PackageException;
	
	public List<Package> getAllPackages() throws PackageException;
	
}
