package com.swszz.cookbooks.mappingstrategy.domain

import com.swszz.cookbooks.mappingstrategy.adapter.out.persistence.model.ProductResult
import com.swszz.cookbooks.mappingstrategy.domain.model.ProductData
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import org.mapstruct.factory.Mappers

/**
 * @author: swszz
 */

@Mapper
interface ProductDataMapper {
    @Mappings(
        Mapping(source = "result.id", target = "id"),
        Mapping(source = "result.createdAt", target = "createdAt"),
        Mapping(source = "result.updatedAt", target = "updatedAt")
    )
    fun toProductData(result: ProductResult): ProductData


    companion object {
        val INSTANCE: ProductDataMapper = Mappers.getMapper(ProductDataMapper::class.java)
    }
}