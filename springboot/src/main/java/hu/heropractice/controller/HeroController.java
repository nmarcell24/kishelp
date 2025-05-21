package hu.heropractice.controller;

import hu.heropractice.dto.HeroCreate;
import hu.heropractice.dto.HeroRead;
import hu.heropractice.dto.HeroUpdate;
import hu.heropractice.service.HeroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.processing.Generated;

@RestController
@RequestMapping("/hero")
@Tag(name = "Hero API")
public class HeroController {

    @Autowired
    HeroService service;


    @GetMapping("{id}")
    @Operation(summary = "Get a hero")
    public HeroRead get(@PathVariable int id) {
        return service.get(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a hero")
    public HeroRead create(@RequestBody @Valid HeroCreate newHero) {
        return service.create(newHero);
    }

    @PutMapping("{id}")
    @Operation(summary = "Update a hero")
    public HeroRead update(@RequestBody @Valid HeroUpdate updateHero, @PathVariable int id) {
        return service.update(updateHero, id);
    }
}
