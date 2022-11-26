package com.teste.maker.controller.impl;

import com.teste.maker.controller.IBrandControlle;
import com.teste.maker.model.Brand;
import com.teste.maker.service.impl.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BrandController implements IBrandControlle {

    @Autowired
    private BrandService brandService;

    @Override
    public void save(Brand brand) {
        brandService.save(brand);
    }
}
