package com.tripmaker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripmaker.exception.LoginException;
import com.tripmaker.exception.PackageException;
import com.tripmaker.model.CurrentCustomerSession;
import com.tripmaker.model.Package;
import com.tripmaker.model.User;
import com.tripmaker.repository.CustomerSessionDAO;
import com.tripmaker.repository.PackageDAO;
import com.tripmaker.repository.UserDao;

@Service
public class PackageServiceImpl implements PackageService{
	
	@Autowired
	private CustomerSessionDAO CustomerSessionDAO;
	
	@Autowired
	private PackageDAO packageDAO;
	
	@Autowired
	private UserDao userDao;

	@Override
	public Package addPackage(Package packages, String key) throws PackageException, LoginException {
		// TODO Auto-generated method stub
		Optional<CurrentCustomerSession> currUserOpt = CustomerSessionDAO.findByUuid(key);

		if (currUserOpt.isPresent()) {
			CurrentCustomerSession currUser1 = currUserOpt.get();
			Optional<User> loggedInUser = userDao.findById(currUser1.getId());
			
			Package addedPackage = packageDAO.save(packages);
			
			if(addedPackage != null) {
				return addedPackage;
			}
			else {
				throw new PackageException("Package cannot be added.");
			}
		}
		else {
			throw new LoginException("Please login to your account");
		}
	}

	

	@Override
	public Package searchPackage(Integer packageId, String key)throws LoginException, PackageException{
		// TODO Auto-generated method stub
		Optional<CurrentCustomerSession> currUserOpt = CustomerSessionDAO.findByUuid(key);

		if (currUserOpt.isPresent()) {
			CurrentCustomerSession currUser1 = currUserOpt.get();
			
			
			Optional<Package> packages = packageDAO.findById(packageId);
			
			return packages.get();
		}
		throw new LoginException("Please login to your account");
	
	}

	@Override
	public List<Package> viewAllPackage(String key) throws LoginException{
		// TODO Auto-generated method stub
		Optional<CurrentCustomerSession> currUserOpt = CustomerSessionDAO.findByUuid(key);

		if (currUserOpt.isPresent()) {
			CurrentCustomerSession currUser1 = currUserOpt.get();
			
			
			List<Package> packages = packageDAO.findAll();
			
			return packages;
		}
		throw new LoginException("Please login to your account");
	}



	@Override
	public String deletePackage(Integer packageId, String key) throws LoginException {
		Optional<CurrentCustomerSession> currUserOpt = CustomerSessionDAO.findByUuid(key);

		if (currUserOpt.isPresent()) {
			CurrentCustomerSession currUser1 = currUserOpt.get();
			Optional<User> loggedInUser = userDao.findById(currUser1.getId());
			
			Optional<Package> Deletepackage = packageDAO.findById(packageId);
			
			packageDAO.delete(Deletepackage.get());
			return "Travel is remove successfully";
		}
		else {
			throw new LoginException("Please login to your account");
		}
	}

}
