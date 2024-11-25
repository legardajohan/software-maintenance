package com.ibero.crudmongo.service;

import com.ibero.crudmongo.model.Person;
import java.util.List;
import java.util.Optional;

public interface PersonService {

    List<Person> getAllPeople();
    Optional<Person> getPersonById(Long id);
    Person savePerson(Person person);
    void deletePersonById(Long id);

}
