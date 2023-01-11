package swimming.pool.presentation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import swimming.pool.application.QuerySwimmingPoolService;
import swimming.pool.application.result.SwimmingPoolResult;
import swimming.pool.infra.common.ApiResponse;

/*
* 조회와 관련된 일을 수행합니다.
* */
@RestController
@RequestMapping("/swimmingpool")
public class QuerySwimmingPoolController {

  private final QuerySwimmingPoolService service;

  public QuerySwimmingPoolController(QuerySwimmingPoolService service) {
    this.service = service;
  }

  @GetMapping("/{poolName}")
  public ApiResponse<SwimmingPoolResult> findSwimmingPool(@PathVariable String poolName) {
    SwimmingPoolResult swimmingPool = service.findSwimmingPool(poolName);
    if (!swimmingPool.equals(null)) return ApiResponse.success(swimmingPool);
    else return ApiResponse.fail("500", "Can't Find SwimmingPool Info");
  }

}
