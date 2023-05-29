package com.swszz.cookbooks.mappingstrategy.domain

import com.swszz.cookbooks.mappingstrategy.adapter.out.persistence.model.ProductData
import com.swszz.cookbooks.mappingstrategy.domain.model.Product
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

/**
 * @author: swszz
 */

@Mapper
interface ProductDataMapper {

    fun toProduct(productData: ProductData): Product


    companion object {
        val INSTANCE: ProductDataMapper = Mappers.getMapper(ProductDataMapper::class.java)
    }
}