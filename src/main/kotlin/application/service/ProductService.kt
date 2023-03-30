package application.service

import adapter.parameter.`in`.BizmallInPortParameter
import adapter.parameter.out.BizmallOutPortParameter
import adapter.out.store.ElasticsearchRepository
import adapter.out.store.R2dbcRepository
import domain.Product

/*
MEMO
    Domain과 Service를 분리 해야한다.
    이유 : 하나의 Domain에 여러개의 Use Case가 있을 수 있기 때문이다.
 */
/*
TODO
    ProductService 하나에 여러 Business에 대한 처리를 넣을 것인지
    Business 별로 Service를 나눠서 갈 것인지
 */
class ProductService(
    val r2DbcRepository: R2dbcRepository,
    val elasticsearchRepository: ElasticsearchRepository,

    ) {
    fun getBizmall(fromInPortParam: BizmallInPortParameter) : List<Product> {
        val toOutPortParam = BizmallOutPortParameter(
            linkInfo = fromInPortParam.linkInfo
        )
        return elasticsearchRepository.getBizmall(toOutPortParam)
    }

}