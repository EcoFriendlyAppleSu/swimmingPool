package swimming.pool.presentation.swimmingpool;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import swimming.pool.application.swimmingpool.DeleteSwimmingPoolService;
import swimming.pool.application.swimmingpool.result.SwimmingPoolDeleteResult;
import swimming.pool.infra.common.ApiResponse;

@RequestMapping("/swimmingpool/delete")
@RestController
public class DeleteSwimmingPoolController {

  private final DeleteSwimmingPoolService service;

  public DeleteSwimmingPoolController(DeleteSwimmingPoolService service) {
    this.service = service;
  }

  @PostMapping("/{id}")
  public ApiResponse<SwimmingPoolDeleteResult> delete(@PathVariable("id") Long poolId) {
    var deletePool = service.deletePool(poolId);
    return ApiResponse.success(deletePool);
  }
}
