package com.workintech.s17d2.DependecyInjection.rest;

import com.workintech.s17d2.DependecyInjection.model.Developer;
import com.workintech.s17d2.DependecyInjection.tax.DeveloperTax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path = "/developers")
public class DeveloperController {

    Map<Integer, Developer> developers;
    DeveloperTax developerTax;

    @Autowired
    public DeveloperController(DeveloperTax developerTax) {
        this.developerTax = developerTax;
        this.developers = new HashMap<>();
    }

    @GetMapping
    public List<Developer> getDevelopers() {
        return developers.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Developer getDeveloper(@PathVariable int id) {
        return developers.get(id);
    }

    @PostMapping
    public Developer addDeveloper(@RequestBody Developer developer) {
        developers.put(developer.getId(), developer);
        return developers.get(developer.getId());
    }

    @PutMapping("/{id}")
    public Developer addDeveloper(@PathVariable Integer id, @RequestBody Developer developer) {
        developers.put(id, developer);
        return developers.get(id);
    }

    @DeleteMapping
    public Developer removeDeveloper(@RequestBody Developer developer) {
        return developers.remove(developer.getId());
    }

}
