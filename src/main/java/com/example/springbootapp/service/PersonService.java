package com.example.springbootapp.service;

import com.example.springbootapp.entity.Person;
import com.example.springbootapp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public void savePerson(Person person){
        personRepository.save(person);
    }

    public Person getPerson(Integer id) {
        return personRepository.findById(id).get();
    }

    public void updatePerson(Integer id, Person person){
        person.setPersonId(id);
        personRepository.save(person);
    }

    public void deletePerson(Integer id) {
        personRepository.deleteById(id);
    }
}
