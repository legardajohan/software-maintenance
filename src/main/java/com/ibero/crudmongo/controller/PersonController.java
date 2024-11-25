package com.ibero.crudmongo.controller;

import com.ibero.crudmongo.model.Person;
import com.ibero.crudmongo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/people")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/all")
    public ResponseEntity<List<Person>> getAllPeople() {

        List<Person> people = personService.getAllPeople();
        return ResponseEntity.ok().body(people);

    }

    @GetMapping("/by_id/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {

        Optional<Person> person = personService.getPersonById(id);
        if (person.isPresent()) {
            return ResponseEntity.ok().body(person.get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/save")
    public ResponseEntity<Person> savePerson(@RequestBody @Validated Person person) {

        Person savedPerson = personService.savePerson(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPerson);
    }

}
