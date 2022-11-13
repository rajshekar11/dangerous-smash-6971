package com.tripmaker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tripmaker.exception.AdminException;
import com.tripmaker.model.Admin;
import com.tripmaker.model.AdminDTO;
import com.tripmaker.service.AdminServices;

//Yedhu Nanthan.S
@RestController
public class AdminController {
	
	@Autowired
	private AdminServices adminServices;

	@PostMapping("/Admins")
	public ResponseEntity<Admin> addAdminHandler(@RequestBody AdminDTO admin) throws AdminException{
		Admin newAdmin = adminServices.addAdmin(admin);
		return new ResponseEntity<Admin>(newAdmin,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/Admins/{id}")
	public ResponseEntity<Admin> deleteAdminHandler(@PathVariable("id") Integer adminId) throws AdminException{
		Admin deletedAdmin = adminServices.deleteAdmin(adminId);
		return new ResponseEntity<Admin>(deletedAdmin,HttpStatus.OK);
	}
	
	@GetMapping("/Admins/{id}")
	public ResponseEntity<Admin> ViewAdminByIdHandler(@PathVariable("id") Integer adminId) throws AdminException{
		Admin admin = adminServices.viewAdminById(adminId);
		return new ResponseEntity<Admin>(admin,HttpStatus.FOUND);
	}
	
	@PutMapping("/Customers")
	public ResponseEntity<Admin> updateAdminHandler(@RequestBody Admin admin) throws AdminException{
		Admin updatedAdmin = adminServices.updeteAdmin(admin);
		return new ResponseEntity<Admin>(updatedAdmin,HttpStatus.OK);
	}
	
	@GetMapping("/Customers")
	public ResponseEntity<List<Admin>> viewAllAdminHandler() throws AdminException{
		List<Admin> adminList = adminServices.viewAdminAll();
		return new ResponseEntity<List<Admin>>(adminList,HttpStatus.FOUND);
	}
}
