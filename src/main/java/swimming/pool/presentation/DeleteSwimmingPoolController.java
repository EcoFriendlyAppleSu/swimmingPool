package swimming.pool.presentation;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import swimming.pool.application.DeleteSwimmingPoolService;
import swimming.pool.application.result.SwimmingPoolDeleteResult;
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
