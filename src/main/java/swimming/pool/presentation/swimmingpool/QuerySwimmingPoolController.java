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
@RequestMapping("/swimmingpool/query")
public class QuerySwimmingPoolController {

  private final QuerySwimmingPoolService service;

  public QuerySwimmingPoolController(QuerySwimmingPoolService service) {
    this.service = service;
  }

  @GetMapping("/name/{poolName}")
  public ApiResponse<SwimmingPoolResult> findSwimmingPoolByName(@PathVariable String poolName) {
    var swimmingPool = service.findSwimmingPoolByName(poolName);
    return ApiResponse.success(swimmingPool);
  }

  @GetMapping("/id/{poolId}")
  public ApiResponse<SwimmingPoolResult> findSwimmingPoolById(@PathVariable Long poolId) {
    var swimmingPool = service.findSwimmingPoolById(poolId);
    return ApiResponse.success(swimmingPool);
  }
}
