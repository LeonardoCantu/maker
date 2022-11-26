package com.teste.maker.service.impl;

import com.teste.maker.model.Product;
import com.teste.maker.model.ProductSku;
import com.teste.maker.repository.IProductRepository;
import com.teste.maker.repository.IProductSkuRepository;
import com.teste.maker.service.IProductSkuService;
import com.teste.maker.validator.ProductSkuValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductSkuService implements IProductSkuService {

    private static final ProductSkuValidator productSkuValidator = new ProductSkuValidator();

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private IProductSkuRepository productSkuRepository;

    @Override
    public void save(Integer idProduct, List<ProductSku> productSkus) {
        productSkus.forEach(productSku -> save(productSku.getId(), productSku));
    }

    @Override
    public void save(Integer idProduct, ProductSku productSku) {
        prepareInsert(idProduct, productSku);

        productSkuValidator.validateRequiredFields(productSku);

        productSkuRepository.save(productSku);
    }

    @Override
    public void save(Product product, ProductSku productSku) {
        productSku.setProduct(product);

        productSkuValidator.validateRequiredFields(productSku);

        productSkuValidator.validateBarCodeIsPresentInProduct(product, productSku);

        verifySkuIsUnique(productSku);
    }

    private void prepareInsert(Integer idProduct, ProductSku productSku) {
        if (idProduct != null) {
            final Optional<Product> product = productRepository.findById(idProduct);
            productSku.setProduct(product.get());
        }

        if (productSku.getBarCode() != null) {
            verifySkuIsUnique(productSku);
        }
    }

    private void verifySkuIsUnique(ProductSku productSku) {
        ProductSku productSKU = productSkuRepository.findFirstByBarCode(productSku.getBarCode());
        productSkuValidator.validateBarCodeIsPresent(productSKU);
    }
}
