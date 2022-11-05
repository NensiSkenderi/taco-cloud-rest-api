package com.taco.cloud.controller.resttemplate;

import com.taco.cloud.model.Taco;
import com.taco.cloud.model.TacoIngredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/get")
public class GetResources {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/taco/{tacoId}")
    private Taco getTacoId(@PathVariable("tacoId") Long id) {
        return getTacoByIdUsingRestTemplate(id);
    }

    @GetMapping("/ingredient/{tacoIngredientId}")
    private TacoIngredient getTacoIngredientById(@PathVariable("tacoIngredientId") Long id) {
        return getTacoIngredientByIdUsingRestTemplate(id);
    }

    public Taco getTacoByIdUsingRestTemplate(Long tacoId) {
        Map<String, String> variables = new HashMap<>();
        variables.put("tacoId", tacoId.toString());

        return restTemplate.getForObject("http://localhost:8080/design/taco/{tacoId}",
                Taco.class, variables);
    }

    public TacoIngredient getTacoIngredientByIdUsingRestTemplate(@PathVariable("id") Long id) {
        ResponseEntity<TacoIngredient> responseEntity =
                restTemplate.getForEntity("http://localhost:8080/ingredients/{id}", TacoIngredient.class, id);
        // getForEntity gives us access to additional response details

        System.out.println(responseEntity.getHeaders());

        return responseEntity.getBody();
    }
}
