package com.workintech.s17d2.DependencyInjection.controller;

import com.workintech.s17d2.DependencyInjection.model.Developer;
import com.workintech.s17d2.DependencyInjection.model.DeveloperFactory;
import com.workintech.s17d2.DependencyInjection.tax.Taxable;
import com.workintech.s17d2.dto.DeveloperResponse;

import jakarta.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path = "/developers")
public class DeveloperController {

    private Map<Integer, Developer> developers;
    private Taxable developerTax;

    public DeveloperController(Taxable developerTax) {
        this.developerTax = developerTax;
    }

    @PostConstruct
    public void init() {
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
    @ResponseStatus(HttpStatus.CREATED)
    public DeveloperResponse addDeveloper(@RequestBody Developer developer) {
        Developer createdDev = DeveloperFactory.createDeveloper(developer, developerTax);

        if (Objects.nonNull(createdDev)) {
            developers.put(createdDev.getId(), createdDev);
        }

        return new DeveloperResponse(createdDev.getId(), createdDev.getName(), createdDev.getSalary(),
                createdDev.getExperience());
    }

    @PutMapping("/{id}")
    public Developer addDeveloper(@PathVariable Integer id, @RequestBody Developer developer) {
        Developer dev = developers.get(id);
        if (Objects.isNull(dev)) {
            return null;
        }

        Developer updatedDev = DeveloperFactory.createDeveloper(developer, developerTax);
        this.developers.put(id, updatedDev);
        return developers.get(id);
    }

    @DeleteMapping
    public Developer removeDeveloper(@RequestBody Developer developer) {
        return developers.remove(developer.getId());
    }

}
