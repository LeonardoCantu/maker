package com.teste.maker.service.impl;

import com.teste.maker.model.Product;
import com.teste.maker.pattern.consumer.APIConsumer;
import com.teste.maker.pattern.convert.Converter;
import com.teste.maker.repository.IProductRepository;
import com.teste.maker.service.IProductService;
import com.teste.maker.validator.ProductValidator;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends Converter<Product> implements IProductService {

    private static final ProductValidator productValidator = new ProductValidator();

    @Autowired
    private ProductSkuService productSkuService;

    @Autowired
    private IProductRepository productRepository;

    @Override
    public void save(Product product) {
        productValidator.validateRequiredFields(product);

        insertProductSkus(product);

        productRepository.save(product);
    }

    private void insertProductSkus(Product product) {
        product.getProductSkuList().stream()
                .forEach(productSku -> productSkuService.save(product, productSku));
    }

    @Override
    public Product update(String url) {
        final JSONObject object = new APIConsumer().execute(url);

        /**
         * Tarefa  5 letra A:
         */
        System.out.println(object);

        /**
         * Tarefa  5 letra B:
         */
        return convertJsonToEntity(object);

    }

}
