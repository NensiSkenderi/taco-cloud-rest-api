package com.taco.cloud.controller;

import com.taco.cloud.config.OrderConfigProperties;
import com.taco.cloud.model.Taco;
import com.taco.cloud.repo.JpaTacoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController

/*
RestController tells Spring that all handler methods in the controller
should have their return value written directly to the body of the response,
rather than being carried in the model to a view for rendering.

Alternatively, we can annotatd DesignTacoController with @Controller,
just like with any Spring MVC controller. But then you’d need to also annotate
all the handler methods with @ResponseBody to achieve the same result
 */

@RequestMapping(path = "/design", produces = "application/json") // will only handle requests
// if the request’s Accept header includes “application/json
@CrossOrigin(origins = "*") // allows clients from any domain to consume the API
public class DesignTacoController {

    @Autowired
    private OrderConfigProperties orderConfigProperties;

    private JpaTacoRepository tacoRepository;

    public DesignTacoController(JpaTacoRepository tacoRepository) {
        this.tacoRepository = tacoRepository;
    }

    @GetMapping("/all")
    private Iterable<Taco> getAllTacos() {
        return tacoRepository.findAll();
    }

    @GetMapping("/recent")
    private Iterable<Taco> getRecentTacos() {
        PageRequest pageRequest = PageRequest.of(0, orderConfigProperties.getPageSize(),
                Sort.by("createdAt").descending());

        return tacoRepository.findAll(pageRequest).getContent();
        //to use findAll with PageRequest parameter we have to make JpaTacoRepository extend PagingAndSortingRepository
    }

    @GetMapping("/{tacoId}") // should be same as @PathVariable
    private Taco getTacoById(@PathVariable("tacoId") Long id){
        Optional<Taco> optionalTaco = tacoRepository.findById(id);
        if(optionalTaco.isPresent())
            return optionalTaco.get();
        return null; // this is not good because by returning null, the client received empty body with HTTP 200
    }

    //fix for above method
    @GetMapping("/taco/{id}")
    private ResponseEntity<Taco> getTacoByIdFixed(@PathVariable("id") Long id){
        Optional<Taco> optionalTaco = tacoRepository.findById(id);
        if(optionalTaco.isPresent())
            return ResponseEntity.ok(optionalTaco.get()); // or new ResponseEntity<>(optionalTaco.get(), HttpStatus.OK)
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
