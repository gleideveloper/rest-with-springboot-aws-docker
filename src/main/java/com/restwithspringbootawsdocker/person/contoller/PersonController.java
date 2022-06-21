package com.restwithspringbootawsdocker.person.contoller;

import com.restwithspringbootawsdocker.person.data.vo.PersonVO;
import com.restwithspringbootawsdocker.person.data.vo.PersonVOV2;
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
    public List<PersonVO> findByAll(){
        return personService.findByAll();
    }

    @GetMapping(value = "/{id}")
    public PersonVO findById(@PathVariable("id") Long id){
        return personService.findById(id);
    }

    @PostMapping()
    public PersonVO create(@RequestBody PersonVO personVO){
        return personService.create(personVO);
    }

    @PostMapping("/v2")
    public PersonVOV2 createV2(@RequestBody PersonVOV2 personVOV2){
        return personService.createV2(personVOV2);
    }


    @PutMapping()
    public PersonVO update(@RequestBody PersonVO personVO){
        return personService.update(personVO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        personService.delete(id);
        return ResponseEntity.ok().build();
    }
}
