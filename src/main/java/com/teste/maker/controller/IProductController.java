package com.teste.maker.controller;

import com.teste.maker.model.Product;
import org.json.JSONObject;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(IProductController.PATH)
public interface IProductController {
    public static String PATH = "/product";

    @PostMapping
    @CacheEvict
    @ResponseStatus(HttpStatus.CREATED)
    void save(@RequestBody Product product);

    @PutMapping
    @CacheEvict
    @ResponseStatus(HttpStatus.OK)
    Product update(@RequestParam(name = "url") String url);
}
