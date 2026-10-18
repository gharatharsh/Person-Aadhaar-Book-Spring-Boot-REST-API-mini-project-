package com.first;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<Person, Integer> {

    // Find by Name
    List<Person> findByName(String name);

    // Find by Age
    List<Person> findByAge(short age);

    // Find by Phone Number
    Optional<Person> findByPhonoNo(long phonoNo);

    // Find by Gender
    Optional<Person> findByGender(String gender);

    // Find by Name and Gender
    List<Person> findByNameAndGender(String name, String gender);

    // Find by PID and Name
    Optional<Person> findByPidAndName(int pid, String name);
    
    Optional<Person> findByPidAndBooks_Bid(int pid, int bid);

}
