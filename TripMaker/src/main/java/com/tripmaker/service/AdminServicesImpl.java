package com.tripmaker.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tripmaker.exception.AdminException;
import com.tripmaker.model.Admin;
import com.tripmaker.model.AdminDTO;
import com.tripmaker.model.User;
import com.tripmaker.repository.AdminRepository;
import com.tripmaker.repository.UserDao;

//Yedhu Nanthan.S
@Service
public class AdminServicesImpl implements AdminServices{
	
	@Autowired
	private AdminRepository adminDao;

	@Autowired
	private UserDao userRepository;
	
	@Override
	public Admin addAdmin(AdminDTO admin) throws AdminException {
		Admin newAdmin = adminDao.save(new Admin(admin.getAdminName(), admin.getEmail(), admin.getPassword(), admin.getMobial()) );
		if(newAdmin == null)
			throw new AdminException("cannot insert record");
		User newUser = new User();
		newUser.getAdmins().add(newAdmin);
		newUser.setUserEmail(newAdmin.getEmail());
		newUser.setUserPassword(newAdmin.getPassword());
		newUser.setUserMobile(newAdmin.getMobial());
		newUser.setUserType("Admin");
		userRepository.save(newUser);
		return newAdmin;
	}

	@Override
	public Admin deleteAdmin(Integer adminId) throws AdminException {
		Optional<Admin> oA = adminDao.findById(adminId);
		Admin admin = oA.get();
		if(admin == null)
			throw new AdminException("Admin not found by id" +adminId);
		else {
			adminDao.delete(admin);
			return admin;
		}
	}

	@Override
	public Admin viewAdminById(Integer adminId) throws AdminException {
		Optional<Admin> oA = adminDao.findById(adminId);
		Admin admin = oA.get();
		if(admin == null)
			throw new AdminException("Admin not found by id" +adminId);
		else 
			return admin;

	}

	@Override
	public Admin updeteAdmin(Admin admin) throws AdminException {
		Optional<Admin> oA = adminDao.findById(admin.getAdminId());
		Admin oldAdmin = oA.get();
		if(oldAdmin == null)
			throw new AdminException("no Admin found");
		else 
			return adminDao.save(admin);
	}

	@Override
	public List<Admin> viewAdminAll() throws AdminException {
		List<Admin> adminList = adminDao.findAll();
		if(adminList.size() == 0)
			throw new AdminException("no Admin found");
		else
			return adminList;
	}

}
