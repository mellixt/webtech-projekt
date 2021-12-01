package htw.berlin.webtech.service;

import htw.berlin.webtech.persistence.PollEntity;
import htw.berlin.webtech.persistence.PollRepository;
import htw.berlin.webtech.web.api.Poll;
import htw.berlin.webtech.web.api.PollManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PollService {

    private final PollRepository pollRepository;

    public PollService(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }

    public List<Poll> findAll() {
        List<PollEntity> polls = pollRepository.findAll();
        return polls.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Poll findById(Long id) {
        var personEntity = pollRepository.findById(id);
        return personEntity.map(this::transformEntity).orElse(null);
    }

    public Poll update(Long id, PollManipulationRequest request) {
        var personEntityOptional = pollRepository.findById(id);
        if (personEntityOptional.isEmpty()) {
            return null;
        }

        var pollEntity = personEntityOptional.get();
        pollEntity.setTitle(request.getTitle());
        pollEntity.setUsername(request.getUsername());
        pollEntity.setCreationDate(request.getCreationDate());
        pollEntity.setEndDate(request.getEndDate());
        pollEntity.setOptions(request.getOptions());
        pollEntity = pollRepository.save(pollEntity);

        return transformEntity(pollEntity);

    }

    public Poll create(PollManipulationRequest request) {
        var pollEntity = new PollEntity(request.getTitle(),request.getUsername(), request.getCreationDate(), request.getEndDate(), request.getOptions());
        pollEntity = pollRepository.save(pollEntity);
        return transformEntity(pollEntity);
    }

    public boolean deleteById(Long id) {
        if (!pollRepository.existsById(id)) {
            return false;
        }

        pollRepository.deleteById(id);
        return true;
    }

    private Poll transformEntity(PollEntity pollEntity) {
        return new Poll(
                pollEntity.getId(),
                pollEntity.getTitle(),
                pollEntity.getUsername(),
                pollEntity.getCreationDate(),
                pollEntity.getEndDate(),
                pollEntity.getOptions()
        );
                
    }

}
