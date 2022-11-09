package com.masai.service;

import com.masai.exception.PackageException;

public interface PackageService {

	public Package addAnewPackage(Package pkg) throws PackageException;
	
	public Package deletePackageById(Integer packageId) throws PackageException;
	
}
