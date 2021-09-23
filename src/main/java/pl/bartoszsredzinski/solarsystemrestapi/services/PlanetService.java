package pl.bartoszsredzinski.solarsystemrestapi.services;

import org.springframework.stereotype.Service;
import pl.bartoszsredzinski.solarsystemrestapi.model.Planet;
import pl.bartoszsredzinski.solarsystemrestapi.repositories.PlanetRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlanetService {

    private PlanetRepository repository;

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

    public void save(Planet planet) {
        if(repository.findByName(planet.getName()) == null)
            repository.save(planet);
    }

    public void delete(Planet planet) {
        repository.delete(planet);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
