package com.swszz.cookbooks.mappingstrategy.adapter.out.persistence.jpa

import com.swszz.cookbooks.mappingstrategy.adapter.out.persistence.entity.ProductDetail
import com.swszz.cookbooks.mappingstrategy.adapter.out.persistence.entity.ProductDetailId
import org.springframework.data.jpa.repository.JpaRepository

/**
 * @author: swszz
 */
interface ProductDetailJpaRepository : JpaRepository<ProductDetail, ProductDetailId>