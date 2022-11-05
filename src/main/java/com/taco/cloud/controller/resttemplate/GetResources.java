package com.taco.cloud.controller.resttemplate;

import com.taco.cloud.model.Taco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class GetResources {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{tacoId}")
    private Taco setTacoId(@PathVariable("tacoId") Long id) {
        return getTacoById(id);
    }

    public Taco getTacoById(Long tacoId) {
//        return restTemplate.getForObject("http://localhost:8080/design/taco/{tacoId}",
//                TacoIngredient.class, ingredientId);

        //we can also use a Map to specify the URL variables
        Map<String, String> variables = new HashMap<>();
        variables.put("tacoId", tacoId.toString());

        return restTemplate.getForObject("http://localhost:8080/design/taco/{tacoId}",
                Taco.class, variables);
    }
}
