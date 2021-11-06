package htw.berlin.webtech.web;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import htw.berlin.webtech.web.api.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/*
 * Für später:
 * - GetMapping Pfad ändern
 * - Klasse "Person" zu Umfrage (?) ändern
 */

@RestController
public class PersonRestController {

    private List<Person> persons;

    public PersonRestController() {
        persons = new ArrayList<>();
        persons.add(new Person(1, "Max", "Mustermann", false));
        persons.add(new Person(2, "Maxima", "Meier", true));
    }


    @GetMapping(path = "/api/v1/persons")
    public ResponseEntity<List<Person>> fetchPersons() {
            return ResponseEntity.ok(persons);
    }

}
