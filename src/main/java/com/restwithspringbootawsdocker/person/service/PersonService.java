package com.restwithspringbootawsdocker.person.service;

import com.restwithspringbootawsdocker.calculator.exception.ResourceNotFoundException;
import com.restwithspringbootawsdocker.person.data.model.Person;
import com.restwithspringbootawsdocker.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository repository;

    public Person create(Person person) {
        return repository.save(person);
    }

    public List<Person> findByAll() {
        return repository.findAll();
    }

    public Person findById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No records found for this ID"));
    }

    public Person update(Person person) {
        Person p = repository.findById(person.getId()).orElseThrow(
                () -> new ResourceNotFoundException("No records found for this ID"));
        p.setFirstName(person.getFirstName());
        p.setLastName(person.getLastName());
        p.setAddress(person.getAddress());
        p.setGender(person.getGender());
        return repository.save(p);
    }

    public void delete(Long id) {
        Person p = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No records found for this ID"));
        repository.delete(p);
    }

}
