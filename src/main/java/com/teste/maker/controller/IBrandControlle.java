package com.teste.maker.controller;

import com.teste.maker.model.Brand;
import com.teste.maker.model.Product;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(IBrandControlle.PATH)
public interface IBrandControlle {

    public static String PATH = "/brand";

    @PostMapping
    @CacheEvict
    @ResponseStatus(HttpStatus.CREATED)
    void save(@RequestBody Brand brand);

}
