package adapter.`in`.web.handler.aggregator

import adapter.`in`.web.handler.dto.BizmallRequestDto
import adapter.parameter.`in`.BizmallInPortParameter
import adapter.`in`.web.handler.aggregator.pdo.BizmallPdo
import application.service.BusinessDayService
import application.service.ProductService
import domain.BusinessDay


/*
 MEMO
  [ROLE] : 각 도메인 별 service를 모아서 최종 Response에 필요한 객체들의 ZIP 객체를 만들어 준다.
  * zip은 mapping이랑 다른 개념으로 가져간다.
  * BizmallHttpAggregator 라고 네이밍 하는 것이 더 낫지 않을까?!? / 그런데 굳이 Http 명시 해주어야하나?!
 */
/*
 TODO
    Handler에서 변환한 DTO를 어디까지 매개변수로 전달 해야 할까? -> 모든 계층간 단절.
 */
class BizmallAggregator(
    val productService: ProductService,
    val businessDayService: BusinessDayService,
) {
    fun getBizmall(requestDto: BizmallRequestDto) : BizmallPdo {
        // MEMO service 계층에 전달할 parameter(DTO) setting -> 네이밍과 패키징 고민 필요
        val param = BizmallInPortParameter(
            linkInfo = requestDto.linkInfo
        )

        return BizmallPdo(
            productService.getBizmall(param),
            BusinessDay()   // businessDayService.getBusinessDay(param)
        )
    }
}