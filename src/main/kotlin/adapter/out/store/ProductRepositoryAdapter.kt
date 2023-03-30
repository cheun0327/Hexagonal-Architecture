package adapter.out.store

import application.port.out.ProductRepositoryPort

class ProductRepositoryAdapter(
    val r2dbcRepository: R2dbcRepository,
    val elasticsearchRepository: ElasticsearchRepository,
) : ProductRepositoryPort {
}