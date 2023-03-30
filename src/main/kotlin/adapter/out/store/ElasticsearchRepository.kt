package adapter.out.store

import adapter.parameter.out.BizmallOutPortParameter
import domain.Product

interface ElasticsearchRepository {
    fun getBizmall(toOutPortParameter: BizmallOutPortParameter): List<Product>
}