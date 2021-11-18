package htw.berlin.webtech.web;

import htw.berlin.webtech.service.PollService;
import htw.berlin.webtech.web.api.Poll;
import htw.berlin.webtech.web.api.PollManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/*
 * Für später:
 * - GetMapping Pfad ändern
 * - Klasse "Person" zu Umfrage (?) ändern
 * - Postman Collection anpassen
 */

@RestController
public class PollRestController {

    private final PollService pollService;

    public PollRestController(PollService pollService) {
        this.pollService = pollService;
    }


    @GetMapping(path = "/api/v1/polls")
    public ResponseEntity<List<Poll>> fetchPolls() {
            return ResponseEntity.ok(pollService.findAll());
    }

    @PostMapping(path = "/api/v1/polls")
    public ResponseEntity<Void> createPolls(@RequestBody PollManipulationRequest request) throws URISyntaxException {
        var poll = pollService.create(request);
        URI uri = new URI("/api/v1/polls/"+poll.getId());
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(path = "/api/v1/polls/{id}")
    public ResponseEntity<Poll> fetchPersonId(@PathVariable Long id) {
        var person = pollService.findById(id);
        return person != null? ResponseEntity.ok(person) : ResponseEntity.notFound().build();
    }

    @PutMapping(path = "/api/v1/polls/{id}")
    public ResponseEntity<Poll> updatePerson(@PathVariable Long id, @RequestBody PollManipulationRequest request) {
        var person = pollService.update(id, request);
        return person != null? ResponseEntity.ok(person) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/polls/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        boolean successful = pollService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
