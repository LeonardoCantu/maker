package com.teste.maker.controller.impl;

import com.teste.maker.controller.IProductController;
import com.teste.maker.model.Product;
import com.teste.maker.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController implements IProductController {

    @Autowired
    private IProductService productService;

    @Override
    public void save(Product product) {
        productService.save(product);
    }

    @Override
    public Product update(String url) {
       return productService.update(url);
    }
}
