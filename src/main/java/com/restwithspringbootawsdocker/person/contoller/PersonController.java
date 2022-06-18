package com.restwithspringbootawsdocker.person.contoller;

import com.restwithspringbootawsdocker.person.entity.Person;
import com.restwithspringbootawsdocker.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping(value = "/persons")
    public List<Person> findByAll(){
        return personService.findByAll();
    }

    @GetMapping(value = "/{id}")
    public Person findById(@PathVariable("id") Long id){
        return personService.findById(id);
    }

    @PostMapping()
    public Person create(@RequestBody Person person){
        return personService.create(person);
    }

    @PutMapping()
    public Person update(@RequestBody Person person){
        return personService.update(person);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        personService.delete(id);
        return ResponseEntity.ok().build();
    }
}
