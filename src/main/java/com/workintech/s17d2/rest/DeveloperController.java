package com.workintech.s17d2.rest;

import com.workintech.s17d2.model.Developer;
import com.workintech.s17d2.tax.DeveloperTax;
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


    @GetMapping("/developers")
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


}
