package com.teste.maker.controller.impl;

import com.teste.maker.controller.IProductSkuController;
import com.teste.maker.model.ProductSku;
import com.teste.maker.service.impl.ProductSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductSkuController implements IProductSkuController {

    @Autowired
    private ProductSkuService productSkuService;

    @Override
    public void save(Integer idProduct, ProductSku productSku) {
        productSkuService.save(idProduct, productSku);
    }

    @Override
    public void save(Integer idProduct, List<ProductSku> productSkus) {
        productSkuService.save(idProduct, productSkus);
    }
}
