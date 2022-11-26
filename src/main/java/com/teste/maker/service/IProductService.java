package com.teste.maker.service;

import com.teste.maker.model.Product;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;

public interface IProductService {

    void save(Product product);

    Product update(String url);

}
