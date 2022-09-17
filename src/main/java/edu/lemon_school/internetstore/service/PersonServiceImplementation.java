package edu.lemon_school.internetstore.service;

import edu.lemon_school.internetstore.entity.Person;
import edu.lemon_school.internetstore.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImplementation implements PersonService{

    @Autowired
    PersonRepository personRepository;

    @Override
    public List<Person> personList() {
        return personRepository.findAll();
    }
}
