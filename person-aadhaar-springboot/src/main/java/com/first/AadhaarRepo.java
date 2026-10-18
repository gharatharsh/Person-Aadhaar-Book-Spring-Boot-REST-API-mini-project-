package com.first;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AadhaarRepo extends JpaRepository<Aadhaar, Integer> {

    Aadhaar findByAnum(long anum);

    List<Aadhaar> findByAddress(String address);

}
