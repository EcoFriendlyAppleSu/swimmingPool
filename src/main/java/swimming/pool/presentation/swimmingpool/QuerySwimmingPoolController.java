package swimming.pool.presentation.swimmingpool;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import swimming.pool.application.swimmingpool.QuerySwimmingPoolService;
import swimming.pool.application.swimmingpool.result.SwimmingPoolResult;
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
    var swimmingPool = service.findSwimmingPool(poolName);
    return ApiResponse.success(swimmingPool);
  }

}
