package swimming.pool.presentation;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import swimming.pool.application.RegisterSwimmingPoolService;
import swimming.pool.application.result.SwimmingPoolResult;
import swimming.pool.domain.swimmingpool.SwimmingPool;
import swimming.pool.infra.common.ApiResponse;
import swimming.pool.presentation.request.SwimmingPoolInfoRequest;
import swimming.pool.presentation.request.SwimmingPoolInfoWrapper;

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
