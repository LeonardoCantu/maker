package com.teste.maker.service.impl;

import com.teste.maker.model.Brand;
import com.teste.maker.repository.BrandRepository;
import com.teste.maker.service.IBrandService;
import com.teste.maker.validator.BrandValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandService implements IBrandService {

    private static final BrandValidator brandValidator = new BrandValidator();

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public void save(Brand brand) {
        brandValidator.validateRequiredFields(brand);

        brandRepository.save(brand);
    }
}
