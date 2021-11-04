package com.example.springbootapp.controller;

import com.example.springbootapp.entity.Person;
import com.example.springbootapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping(path = "/savePerson")
    public ResponseEntity<String> savePerson(@RequestBody Person person){
        personService.savePerson(person);
        return new ResponseEntity<>("Success", HttpStatus.ACCEPTED);
    }

    @GetMapping(path = "/getPerson/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Integer id){
        Person person = personService.getPerson(id);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PutMapping(path = "/updatePerson/{id}")
    public ResponseEntity<String> updatePerson(@PathVariable Integer id, @RequestBody Person person){
        personService.updatePerson(id, person);
        return new ResponseEntity<>("Success", HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = "/deletePerson/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable Integer id) {
        personService.deletePerson(id);
        return new ResponseEntity<>("Success", HttpStatus.ACCEPTED);
    }
}
