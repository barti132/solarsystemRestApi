package pl.bartoszsredzinski.solarsystemrestapi.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.bartoszsredzinski.solarsystemrestapi.model.Planet;
import pl.bartoszsredzinski.solarsystemrestapi.services.PlanetService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/planet/")
public class PlanetRestController{

    private final PlanetService planetService;

    public PlanetRestController(PlanetService planetService) {
        this.planetService = planetService;
    }


    @GetMapping("getByName/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Planet getPlanetByName(@PathVariable String name) {
        return planetService.findByName(name);
    }

    @GetMapping("getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<Planet> getAllTask() {
        return planetService.findAll();
    }

    @PostMapping("add")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Planet> addTask(@RequestBody Planet planet) {
        return planetService.save(planet);
    }


    @DeleteMapping("deleteById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTaskById(@PathVariable String id) {
        planetService.deleteById(Long.parseLong(id));
    }

}
