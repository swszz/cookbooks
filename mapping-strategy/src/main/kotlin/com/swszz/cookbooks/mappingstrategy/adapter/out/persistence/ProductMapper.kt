package com.swszz.cookbooks.mappingstrategy.adapter.out.persistence

import com.swszz.cookbooks.mappingstrategy.adapter.out.persistence.entity.Product
import com.swszz.cookbooks.mappingstrategy.adapter.out.persistence.model.ProductResult
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import org.mapstruct.factory.Mappers

/**
 * @author: swszz
 */

@Mapper
interface ProductMapper {
    @Mappings(
        Mapping(source = "product.id.id", target = "id"),
        Mapping(source = "product.createdAt", target = "createdAt"),
        Mapping(source = "product.updatedAt", target = "updatedAt")
    )
    fun toProductResult(product: Product): ProductResult


    companion object {
        val INSTANCE: ProductMapper = Mappers.getMapper(ProductMapper::class.java)
    }
}