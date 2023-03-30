package adapter.`in`.web.handler

import adapter.`in`.web.handler.aggregator.BizmallAggregator
import adapter.`in`.web.handler.aggregator.BundleAggregator
import adapter.`in`.web.handler.aggregator.DealAggregator
import adapter.`in`.web.handler.dto.BizmallRequestDto
import mapper.product.ProductMapper
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

/*
 MEMO
    Router와 비슷한 구조로 모든 Handler 여기에 구현. Interface화 해도 괜찮을 듯.
 */
class HttpHandler(
    val bizmallAggregator: BizmallAggregator,
    val bundleAggregator: BundleAggregator,
    val dealAggregator: DealAggregator,
    val productMapper: ProductMapper,
) {
    fun bizmall(serverReq: ServerRequest): Mono<ServerResponse> {
        /*
         MEMO [RequestDto라고 네이밍 한 이유]
            Handler에서 Aggregator로 넘어갈때는 Http Input이 확정된 상태..?
         */
        val bizmallReqeustDto = BizmallRequestDto(
            linkInfo = serverReq.attribute("linkInfo").toString()
        )

        val bizmallPdo = bizmallAggregator.getBizmall(bizmallReqeustDto)

        // TODO productMapper.mapTOBizmallResponse(bizmallPdo)

        return ServerResponse.ok().bodyValue("bizmall")
    }
}