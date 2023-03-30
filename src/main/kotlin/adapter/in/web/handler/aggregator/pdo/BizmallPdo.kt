package adapter.`in`.web.handler.aggregator.pdo

import domain.BusinessDay
import domain.Product

/*
TODO
    PDO들의 위치 고민 해보기
 */
data class BizmallPdo(
    val products: List<Product>,
    val businessday: BusinessDay,
)
