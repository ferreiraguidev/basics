package com.example.basics.service;

import com.example.basics.model.DTO.PersonPostRequestBody;
import com.example.basics.model.DTO.PersonPutReqBody;
import com.example.basics.model.Person;
import com.example.basics.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person save(PersonPostRequestBody personPostRequestBody) {

        Person person = Person.builder()
                        .document(personPostRequestBody.getDocument())
                        .email(personPostRequestBody.getEmail())
                        .genero(personPostRequestBody.getGenero())
                        .name(personPostRequestBody.getName())
                        .age(personPostRequestBody.getAge())
                        .build();

        return personRepository.save(person);
    }
    public Person findByDocument(String document){
        return personRepository.findByDocument(document);
    }

    public void deleteByDocument(String document){
        personRepository.deleteByDocument(document);
    }

    public Person update(PersonPutReqBody personPutReqBody) {
        var byDocument = personRepository.findByDocument(personPutReqBody.getDocument());

        if(byDocument == null){
            throw new IllegalArgumentException("could not find correspondent document");
        }
        byDocument.setDocument(personPutReqBody.getDocument());
        byDocument.setAge(personPutReqBody.getAge());
        byDocument.setGenero(personPutReqBody.getGenero());
        byDocument.setEmail(personPutReqBody.getEmail());
        byDocument.setName(personPutReqBody.getName());

        return byDocument;
    }

    public List<Person> listAll(){
       return personRepository.findAll();
    }

}
