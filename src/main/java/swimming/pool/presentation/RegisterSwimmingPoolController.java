package swimming.pool.presentation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import swimming.pool.application.RegisterSwimmingPoolService;
import swimming.pool.application.result.SwimmingPoolResult;
import swimming.pool.infra.common.ApiResponse;
import swimming.pool.presentation.request.SwimmingPoolInfoRequest;

@RestController
@RequestMapping("/swimmingpool")
public class RegisterSwimmingPoolController {

  Logger logger = LoggerFactory.getLogger(this.getClass());

  private final RegisterSwimmingPoolService service;
  @Autowired
  public RegisterSwimmingPoolController(RegisterSwimmingPoolService service) {
    this.service = service;
  }

  @PostMapping("/register/single")
  public ApiResponse<SwimmingPoolResult> singleInformation(@RequestBody SwimmingPoolInfoRequest request) {
    SwimmingPoolResult swimmingPoolResult = service.register(request.toCommand());
    return ApiResponse.success(swimmingPoolResult);
  }
}
