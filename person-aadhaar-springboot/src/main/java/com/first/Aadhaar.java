package com.first;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Aadhaar {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "aadhaar_id")
    @SequenceGenerator(name = "aadhaar_id", initialValue = 1, allocationSize = 1)
    private int aid;

    private long anum;
    private String address;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public long getAnum() {
        return anum;
    }

    public void setAnum(long anum) {
        this.anum = anum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
