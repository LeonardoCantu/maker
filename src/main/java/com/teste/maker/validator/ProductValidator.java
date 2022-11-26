package com.teste.maker.validator;

import com.teste.maker.model.Product;
import com.teste.maker.pattern.validator.IValidator;
import com.teste.maker.pattern.validator.ValidateFields;

public class ProductValidator implements IValidator<Product> {

    @Override
    public void validateRequiredFields(Product product) {
        ValidateFields validateFields = new ValidateFields();

        validateFields.add(product.getBrand(), "Brand");
        validateFields.add(product.getDescription(), "Description");
        validateFields.add(product.getProductSkuList(), "Products Sku");
        validateFields.add(product.getName(), "Name");

        validateFields.validate();
    }
}
