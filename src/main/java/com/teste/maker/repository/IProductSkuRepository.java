package com.teste.maker.repository;

import com.teste.maker.model.ProductSku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductSkuRepository extends JpaRepository<ProductSku, Integer> {

    ProductSku findFirstByBarCode(String barCode);

}
