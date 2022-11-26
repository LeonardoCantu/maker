package com.teste.maker.controller;

import com.teste.maker.model.ProductSku;
import com.teste.maker.pattern.constants.OperationParam;
import com.teste.maker.pattern.constants.OperationPath;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(IProductSkuController.PATH)
public interface IProductSkuController {

    String PATH = IProductController.PATH + OperationPath.PARENT_ID + "/product-sku";

    @PostMapping
    @CacheEvict
    @ResponseStatus(HttpStatus.CREATED)
    void save(@PathVariable(OperationParam.ID) Integer idProduct,
              @RequestBody ProductSku productSku);

    @PostMapping("/all")
    @CacheEvict
    @ResponseStatus(HttpStatus.CREATED)
    void save(@PathVariable(OperationParam.ID) Integer idProduct,
              @RequestBody List<ProductSku> productSkus);
}
