package com.teste.maker.validator;

import com.teste.maker.model.Brand;
import com.teste.maker.pattern.validator.IValidator;
import com.teste.maker.pattern.validator.ValidateFields;

public class BrandValidator implements IValidator<Brand> {

    @Override
    public void validateRequiredFields(Brand brand) {
        ValidateFields validateFields = new ValidateFields();

        validateFields.add(brand.getName(), "Name");
        validateFields.add(brand.getDescription(), "Description");

        validateFields.validate();
    }
}
