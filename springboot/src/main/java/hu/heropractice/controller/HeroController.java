package hu.heropractice.controller;

import hu.heropractice.dto.CreateHero;
import hu.heropractice.dto.ListHero;
import hu.heropractice.dto.ReadHero;
import hu.heropractice.dto.UpdateHero;
import hu.heropractice.service.HeroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hero")
@Tag(name = "Hero operations")
public class HeroController {

    @Autowired
    HeroService service;

    @GetMapping
    @Operation(summary = "List all heros")
    public List<ListHero> list() {
        return service.list();
    }

    @GetMapping("{id}")
    @Operation(summary = "Get hero")
    public ReadHero get(@PathVariable int id) {
        return service.get(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create hero")
    public ReadHero create(@RequestBody @Valid CreateHero newHero) {
        return service.create(newHero);
    }

    @PutMapping("{id}")
    @Operation(summary = "Update Hero")
    public ReadHero update(@RequestBody @Valid UpdateHero updateHero, @PathVariable int id) {
        return service.update(updateHero, id);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Delete hero by Id")
    public ReadHero delete(@PathVariable int id) {
        return service.delete(id);
    }

}
