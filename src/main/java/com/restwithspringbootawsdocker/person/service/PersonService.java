package com.restwithspringbootawsdocker.person.service;

import com.restwithspringbootawsdocker.person.entity.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonService {
    private final AtomicLong counter = new AtomicLong();

    public Person create(Person person){
        return person;
    }
    public Person update(Person person){
        return person;
    }

    public void delete(Long id){

    }

    public List<Person> findByAll(){
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            persons.add(mockPerson(i));
        }
        return persons;
    }
    public Person findById(Long id){
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Gleides");
        person.setLastName("Vinente");
        person.setAddress("Manaus/Am - Brazil");
        person.setGender("Male");
        return person;
    }

    private Person mockPerson(long id) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person name" + id);
        person.setLastName("Last name" + id);
        person.setAddress("Some address in Brazil" + id);
        person.setGender("Male" + id);
        return person;
    }
}
