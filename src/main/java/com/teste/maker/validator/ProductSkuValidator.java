package com.teste.maker.validator;

import com.teste.maker.model.Product;
import com.teste.maker.model.ProductSku;
import com.teste.maker.pattern.validator.IValidator;
import com.teste.maker.pattern.validator.ValidateFields;

public class ProductSkuValidator implements IValidator<ProductSku> {

    @Override
    public void validateRequiredFields(ProductSku productSku) {
        ValidateFields validateFields = new ValidateFields();

        validateFields.add(productSku.getDescription(), "Description");
        validateFields.add(productSku.getName(), "Name");
        validateFields.add(productSku.getBarCode(), "Bar Code");
        validateFields.add(productSku.getPrice(), "Price");
        validateFields.add(productSku.getProduct(), "Product");

        validateFields.validate();
    }

    public void validateBarCodeIsPresent(ProductSku productSku) {
        if (productSku == null) {
            return;
        }
        if (productSku.getBarCode() != null) {
            throw new RuntimeException("Codigo de barras ja é usado por outro produto");
        }
    }

    public void validateBarCodeIsPresentInProduct(Product product, ProductSku productSku) {
        for (ProductSku sku : product.getProductSkuList()) {
            if (productSku.equals(sku)) {
                continue;
            }
            if (productSku.getBarCode().trim().equals(sku.getBarCode().trim())) {
                throw new RuntimeException("Codigo de barras ja é usado por outro produto");
            }
        }
    }
}
