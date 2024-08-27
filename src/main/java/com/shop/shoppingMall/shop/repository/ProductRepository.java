package com.shop.shoppingMall.shop.repository;

import com.shop.shoppingMall.shop.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    ProductEntity save(ProductEntity productEntity);

    List<ProductEntity> findAll();

    Optional<ProductEntity> findById(Long productId);

}
