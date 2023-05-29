package com.swszz.cookbooks.mappingstrategy.adapter.out.persistence.jpa

import com.swszz.cookbooks.mappingstrategy.adapter.out.persistence.entity.Product
import com.swszz.cookbooks.mappingstrategy.adapter.out.persistence.entity.ProductId
import org.springframework.data.jpa.repository.JpaRepository

/**
 * @author: swszz
 */
interface ProductJpaRepository : JpaRepository<Product, ProductId>