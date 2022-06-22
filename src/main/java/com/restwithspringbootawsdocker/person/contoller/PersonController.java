package com.restwithspringbootawsdocker.person.contoller;

import com.restwithspringbootawsdocker.person.data.vo.PersonVO;
import com.restwithspringbootawsdocker.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/person/v1")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping(produces = {"application/json", "application/xml", "application/x-yaml"})
    public List<PersonVO> findByAll() {
        List<PersonVO> personVOList = personService.findByAll();
        personVOList
                .forEach(p -> p.add(
                        linkTo(methodOn(PersonController.class).findById(p.getKey())).withSelfRel()
                        )
                );
        return personVOList;
    }

    @GetMapping(value = "/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
    public PersonVO findById(@PathVariable("id") Long id) {
        PersonVO personVO = personService.findById(id);
        personVO.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
        return personVO;
    }

    @PostMapping(produces = {"application/json", "application/xml", "application/x-yaml"},
            consumes = {"application/json", "application/xml"})
    public PersonVO create(@RequestBody PersonVO personVO) {
        PersonVO pVO = personService.create(personVO);
        pVO.add(linkTo(methodOn(PersonController.class).findById(pVO.getKey())).withSelfRel());
        return pVO;
    }

    @PutMapping(produces = {"application/json", "application/xml", "application/x-yaml"},
            consumes = {"application/json", "application/xml", "application/x-yaml"})
    public PersonVO update(@RequestBody PersonVO personVO) {
        PersonVO pVO = personService.update(personVO);
        pVO.add(linkTo(methodOn(PersonController.class).findById(pVO.getKey())).withSelfRel());
        return pVO;
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        personService.delete(id);
        return ResponseEntity.ok().build();
    }
}
