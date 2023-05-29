package com.swszz.cookbooks.mappingstrategy.adapter.out.persistence

import com.swszz.cookbooks.mappingstrategy.adapter.out.persistence.entity.Product
import com.swszz.cookbooks.mappingstrategy.adapter.out.persistence.model.ProductData
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings
import org.mapstruct.factory.Mappers

/**
 * @author: swszz
 */

@Mapper
interface ProductEntityMapper {

    /**
     * 기본적으로 property의 이름과 depth가 일치한다면 자동으로 매핑한다.
     * - 이 외의 경우는 모두 등록해준다.
     * - 자동 매핑을 선택할 경우의 단점은 compile 단계에서 매핑 오류를 찾지 못 하다는 것이다.
     */
    @Mappings(
        Mapping(source = "product.id.id", target = "id"),
        Mapping(source = "product.productDetail.id.id", target = "productDetail.id"),
    )
    fun toProductData(product: Product): ProductData

    companion object {
        val INSTANCE: ProductEntityMapper = Mappers.getMapper(ProductEntityMapper::class.java)
    }
}