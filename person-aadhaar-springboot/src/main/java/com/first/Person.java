package com.first;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "person_id")
    @SequenceGenerator(name = "person_id", initialValue = 10, allocationSize = 1)
//    @Column(name = "person_pid")
    private int pid;

    private String name;
    private short age;
    private String gender;
    private long phonoNo;

    @OneToOne
    private Aadhaar aadhaar;

    @OneToMany
    private List<Book> books = new ArrayList<>();

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getPhonoNo() {
        return phonoNo;
    }

    public void setPhonoNo(long phonoNo) {
        this.phonoNo = phonoNo;
    }

    public Aadhaar getAadhaar() {
        return aadhaar;
    }

    public void setAadhaar(Aadhaar aadhaar) {
        this.aadhaar = aadhaar;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
