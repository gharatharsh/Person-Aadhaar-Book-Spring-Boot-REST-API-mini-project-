package com.first;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    PersonRepo db;

    @Autowired
    BookRepo bookRepo;

    @Autowired
    AadhaarRepo aadhaarRepo;


    //  Saving Person with their Aadhaar
    @PostMapping("/person/save/{aid}")
    public String savePerson(@RequestBody Person p,
                             @PathVariable int aid) {

        Aadhaar aadhaar = aadhaarRepo.findById(aid).get();
        p.setAadhaar(aadhaar);
        db.save(p);

        return "Person Data Saved";
    }


    // Adding Book to Person
    @PostMapping("/person/{pid}/book/{bid}")
    public String addBookToPerson(@PathVariable int pid,
                                  @PathVariable int bid) {

        Person person = db.findById(pid).get();

        Book book = bookRepo.findById(bid).get();

        person.getBooks().add(book);

        db.save(person);

        return "Book Added To Person";
    }


    //  Updating Person
    @PutMapping("/person/update")
    public String updatePerson(@RequestBody Person p) {

        db.save(p);

        return "Person Data Updated";
    }


    //  Deleting Person
    @DeleteMapping("/person/delete/{pid}")
    public String deletePerson(@PathVariable int pid) {

        db.deleteById(pid);

        return "Person Data Deleted";
    }


    //  Get Person By ID
    @GetMapping("/person/{pid}")
    public Optional<Person> getPersonById(@PathVariable int pid) {

        return db.findById(pid);
    }


    //  Get All Persons
    @GetMapping("/person/all")
    public List<Person> getAllPersons() {

        return db.findAll();
    }


    //  Find Person By PhoneNo
    @GetMapping("/person/phono/{phonoNo}")
    public Optional<Person> findByPhonoNo(@PathVariable long phonoNo) {

        return db.findByPhonoNo(phonoNo);
    }


    // Find Person By Name
    @GetMapping("/person/name/{name}")
    public List<Person> findByName(@PathVariable String name) {

        return db.findByName(name);
    }


    // Find Person By Age
    @GetMapping("/person/age/{age}")
    public List<Person> findByAge(@PathVariable short age) {

        return db.findByAge(age);
    }


    // Find Person By Gender
    @GetMapping("/person/gender/{gender}")
    public Optional<Person> findByGender(@PathVariable String gender) {

        return db.findByGender(gender);
    }


    // Find Person By Name And Gender
    @GetMapping("/person/name/{name}/gender/{gender}")
    public List<Person> findByNameAndGender(
            @PathVariable String name,
            @PathVariable String gender) {

        return db.findByNameAndGender(name, gender);
    }


    // Find Person By PID And Name
    @GetMapping("/findByPidAndName/{pid}/{name}")
    public Optional<Person> findByPidAndName(
            @PathVariable int pid,
            @PathVariable String name) {

        return db.findByPidAndName(pid, name);
    }
    
    // Find  person By PID And BID
    @GetMapping("/person/{pid}/book/{bid}")
    public Optional<Person> findPersonByPidAndBookId(
            @PathVariable int pid,
            @PathVariable int bid) {

        return db.findByPidAndBooks_Bid(pid, bid);
    }

}
