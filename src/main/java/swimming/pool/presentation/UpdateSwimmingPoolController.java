package swimming.pool.presentation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import swimming.pool.application.UpdateSwimmingPoolService;
import swimming.pool.application.result.SwimmingUpdateResult;
import swimming.pool.infra.common.ApiResponse;
import swimming.pool.presentation.request.SwimmingPoolUpdateRequest;

@RestController
@RequestMapping("/swimmingpool/update")
public class UpdateSwimmingPoolController {

  private final UpdateSwimmingPoolService service;

  public UpdateSwimmingPoolController(UpdateSwimmingPoolService service) {
    this.service = service;
  }

  @PostMapping("/{poolName}")
  public ApiResponse<SwimmingUpdateResult> update(
      @RequestBody SwimmingPoolUpdateRequest poolUpdateRequest,
      @PathVariable String poolName) {
    var result = service.updatePoolName(poolUpdateRequest.getPoolName(), poolName);
    if (!result.equals(null)) {
      return ApiResponse.success(result);
    }
    return ApiResponse.fail("0003", "수영장 이름 변경에 실패했습니다.");
  }
}

