package com.restwithspringbootawsdocker.person.repository;


import com.restwithspringbootawsdocker.person.data.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
