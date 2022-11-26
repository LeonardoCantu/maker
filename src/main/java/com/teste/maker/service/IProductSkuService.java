package com.teste.maker.service;

import com.teste.maker.model.Product;
import com.teste.maker.model.ProductSku;

import java.util.List;

public interface IProductSkuService {

    void save (Integer idProduct, ProductSku productSku);

    void save (Integer idProduct, List<ProductSku> productSkus);

    void save(Product product, ProductSku productSku);

}
