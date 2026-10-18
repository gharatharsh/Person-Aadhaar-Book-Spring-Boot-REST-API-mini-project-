package com.first;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AadhaarController {

	@Autowired
	AadhaarRepo db;

	// Save Aadhaar
	@PostMapping("/aadhaar/save")
	public String saveAadhaar(@RequestBody Aadhaar a) {

		db.save(a);

		return "Aadhaar Data Saved";
	}

	// Get Aadhaar By ID
	@GetMapping("/aadhaar/{aid}")
	public Aadhaar getAadhaarById(@PathVariable int aid) {

		return db.findById(aid).get();
	}

	// Get All Aadhaar
	@GetMapping("/aadhaar/all")
	public List<Aadhaar> getAllAadhaar() {

		return db.findAll();
	}

	// Update Aadhaar
	@PutMapping("/aadhaar/update")
	public String updateAadhaar(@RequestBody Aadhaar a) {

		db.save(a);

		return "Aadhaar Data Updated";
	}

	// Delete Aadhaar
	@DeleteMapping("/aadhaar/delete/{aid}")
	public String deleteAadhaar(@PathVariable int aid) {

		db.deleteById(aid);

		return "Aadhaar Data Deleted";
	}

	// Find Aadhaar By Aadhaar Number
	@GetMapping("/aadhaar/anum/{anum}")
	public Aadhaar findByAnum(@PathVariable long anum) {

		return db.findByAnum(anum);
	}

	// Find Aadhaar By Address
	@GetMapping("/aadhaar/address/{address}")
	public List<Aadhaar> findByAddress(@PathVariable String address) {

		return db.findByAddress(address);
	}
}
