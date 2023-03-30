package mapper.product

import mapper.product.`in`.HttpRequestMapper
import mapper.product.`in`.HttpResponseMapper
import mapper.product.out.ElasticsearchMapper

/*
 MEMO
    input, output Adapter에서 사용
    eg)
    productMapper.mapToProduct
    productMapper.mapToBizmallHttpResponse
    productMapper.mapToBizmallRpcResponse
 */

/*
 TODO
    1. bizday 합치는 부분은 어떻게 처리하지?
    2. input이랑 output에 필요한 매퍼를 분리할까?
 */
interface ProductMapper: HttpRequestMapper, HttpResponseMapper, ElasticsearchMapper