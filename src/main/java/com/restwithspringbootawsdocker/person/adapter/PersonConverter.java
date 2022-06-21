package com.restwithspringbootawsdocker.person.adapter;

import com.restwithspringbootawsdocker.person.data.model.Person;
import com.restwithspringbootawsdocker.person.data.vo.PersonVOV2;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonConverter {

    public PersonVOV2 convertEntityToVo(Person person){
        PersonVOV2 pVOV2 = new PersonVOV2();
        pVOV2.setId(person.getId());
        pVOV2.setFirstName(person.getFirstName());
        pVOV2.setLastName(person.getLastName());
        pVOV2.setBirthday(new Date());
        pVOV2.setGender(person.getGender());
        pVOV2.setAddress(person.getAddress());
        return pVOV2;
    }

    public Person convertVoToEntity(PersonVOV2 personVOV2){
        Person person = new Person();
        person.setId(personVOV2.getId());
        person.setFirstName(personVOV2.getFirstName());
        person.setLastName(personVOV2.getLastName());
        person.setGender(personVOV2.getGender());
        person.setAddress(personVOV2.getAddress());
        return person;
    }

}
