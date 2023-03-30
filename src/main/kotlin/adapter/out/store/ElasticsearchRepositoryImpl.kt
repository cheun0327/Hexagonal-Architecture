package adapter.out.store

import adapter.parameter.out.BizmallOutPortParameter
import domain.Product
import mapper.product.ProductMapper
import java.util.Objects

class ElasticsearchRepositoryImpl(
    val productMapper: ProductMapper,
    val elasticsearchRepository: Objects,
) : ElasticsearchRepository {

    override fun getBizmall(toOutPortParameter: BizmallOutPortParameter): List<Product> {
        /*
        TODO
            1. ES Query로 ProductDocument 조회
               : elasticsearchRepository.getBizmall
            2. ProductDocument to Product mapping
               : productMapper.mapToProduct(ProductDocument)
         */
        return listOf(Product("123"))
    }

}