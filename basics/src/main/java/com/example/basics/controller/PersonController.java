package com.example.basics.controller;


import com.example.basics.model.DTO.PersonPostRequestBody;
import com.example.basics.model.DTO.PersonPutReqBody;
import com.example.basics.model.Person;
import com.example.basics.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.*;



@RestController
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("person/new")
    public ResponseEntity<Person> save(@RequestBody @Valid PersonPostRequestBody personPostRequestBody){
        return new ResponseEntity<>(personService.save(personPostRequestBody), CREATED);
//        return ResponseEntity.of(personService.save(personPostRequestBody));

    }
    @PatchMapping("person")
    public ResponseEntity<Person> update(@RequestBody @Valid PersonPutReqBody personPutReqBody){
        return new ResponseEntity<>(personService.update(personPutReqBody), ACCEPTED);
    }

    @GetMapping("people")// CREATE ANOTHER DTO FOR GETMAPPING
    public List<Person> listAll(){
        return personService.listAll();
    }

    @GetMapping("person/{document}")
    public Person findByDocument(@PathVariable String document){
        return personService.findByDocument(document);
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping("p/{document}") // void return statement *
    public void deleteByDocument(@PathVariable String document){
        personService.deleteByDocument(document);
    }
}
