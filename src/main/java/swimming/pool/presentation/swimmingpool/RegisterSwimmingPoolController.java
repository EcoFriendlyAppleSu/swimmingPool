package swimming.pool.presentation.swimmingpool;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import swimming.pool.application.swimmingpool.RegisterSwimmingPoolService;
import swimming.pool.application.swimmingpool.result.SwimmingPoolResult;
import swimming.pool.domain.swimmingpool.SwimmingPool;
import swimming.pool.infra.common.ApiResponse;
import swimming.pool.presentation.swimmingpool.request.SwimmingPoolInfoRequest;
import swimming.pool.presentation.swimmingpool.request.SwimmingPoolInfoWrapper;

@RestController
@RequestMapping("/swimmingpool/register")
public class RegisterSwimmingPoolController {

  private final RegisterSwimmingPoolService service;

  public RegisterSwimmingPoolController(RegisterSwimmingPoolService service) {
    this.service = service;
  }

  @PostMapping("/single")
  public ApiResponse<SwimmingPoolResult> singleInformation(@RequestBody SwimmingPoolInfoRequest request) {
    SwimmingPoolResult swimmingPoolResult = service.register(request.toCommand());
    return ApiResponse.success(swimmingPoolResult);
  }

  @PostMapping("/multi")
  public ApiResponse<List<SwimmingPool>> multiInformation(@RequestBody SwimmingPoolInfoWrapper requests) {
    List<SwimmingPoolResult> swimmingPoolResults = service.registerMultiData(requests.toCommands());
    return ApiResponse.success(swimmingPoolResults);
  }
}
