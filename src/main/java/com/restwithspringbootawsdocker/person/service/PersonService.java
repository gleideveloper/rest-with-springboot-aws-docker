package com.restwithspringbootawsdocker.person.service;

import com.restwithspringbootawsdocker.calculator.exception.ResourceNotFoundException;
import com.restwithspringbootawsdocker.person.adapter.DozerConverter;
import com.restwithspringbootawsdocker.person.adapter.PersonConverter;
import com.restwithspringbootawsdocker.person.data.model.Person;
import com.restwithspringbootawsdocker.person.data.vo.PersonVO;
import com.restwithspringbootawsdocker.person.data.vo.PersonVOV2;
import com.restwithspringbootawsdocker.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository repository;
    @Autowired
    private PersonConverter personConverter;

    public PersonVO create(PersonVO personVO) {
        var entity = DozerConverter.parseObject(personVO, Person.class);
        return DozerConverter.parseObject(repository.save(entity),PersonVO.class);
    }

    public PersonVOV2 createV2(PersonVOV2 personVO) {
        var entity = personConverter.convertVoToEntity(personVO);
        return personConverter.convertEntityToVo(repository.save(entity));
    }

    public List<PersonVO> findByAll() {
        return DozerConverter.parseListObjects(repository.findAll(), PersonVO.class);
    }

    public PersonVO findById(Long id) {
        var entity = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No records found for this ID"));
        return DozerConverter.parseObject(repository.save(entity),PersonVO.class);
    }

    public PersonVO update(PersonVO personVO) {
        var entity = repository.findById(personVO.getId()).orElseThrow(
                () -> new ResourceNotFoundException("No records found for this ID"));
        entity.setFirstName(personVO.getFirstName());
        entity.setLastName(personVO.getLastName());
        entity.setAddress(personVO.getAddress());
        entity.setGender(personVO.getGender());
        return DozerConverter.parseObject(repository.save(entity), PersonVO.class);
    }

    public void delete(Long id) {
        var p = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No records found for this ID"));
        repository.delete(p);
    }

}
