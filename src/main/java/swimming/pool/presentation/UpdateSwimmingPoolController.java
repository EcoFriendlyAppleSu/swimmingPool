package swimming.pool.presentation;

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

  @PostMapping("/{id}")
  public ApiResponse<SwimmingUpdateResult> updatePoolName(
      @RequestBody SwimmingPoolUpdateRequest updateRequest,
      @PathVariable Long poolId) {
    var result = service.update(updateRequest.toCommand(), poolId);
    return ApiResponse.success(result);
  }
}

