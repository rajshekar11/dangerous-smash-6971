package com.tripmaker.services;

import java.util.List;

import com.tripmaker.exception.AdminException;
import com.tripmaker.model.Admin;

public interface AdminServices {

	public Admin addAdmin(Admin admin)throws AdminException;
	public Admin deleteAdmin(Integer adminId)throws AdminException;
	public Admin viewAdminById(Integer adminId)throws AdminException;
	public Admin updeteAdmin(Admin admin)throws AdminException;
	public List<Admin> viewAdminAll()throws AdminException;
}
