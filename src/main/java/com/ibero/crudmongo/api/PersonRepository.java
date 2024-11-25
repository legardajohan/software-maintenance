package com.ibero.crudmongo.api;

import com.ibero.crudmongo.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, Long> {


}
