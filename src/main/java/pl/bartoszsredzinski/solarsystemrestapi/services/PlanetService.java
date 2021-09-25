package pl.bartoszsredzinski.solarsystemrestapi.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.bartoszsredzinski.solarsystemrestapi.model.Planet;
import pl.bartoszsredzinski.solarsystemrestapi.repositories.PlanetRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlanetService {

    private final PlanetRepository repository;

    public PlanetService(PlanetRepository repository) {
        this.repository = repository;
    }

    public List<Planet> findAll() {
        List<Planet> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return list;
    }

    public Planet findByName(String name) {
        return repository.findByName(name);
    }

    public Planet findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public ResponseEntity<Planet> save(Planet planet) {
        if(repository.findByName(planet.getName()) == null) {
            repository.save(planet);
            return new ResponseEntity<>(planet, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public void delete(Planet planet) {
        repository.delete(planet);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
