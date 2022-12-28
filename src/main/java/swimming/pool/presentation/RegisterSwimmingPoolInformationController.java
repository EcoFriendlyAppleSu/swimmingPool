package swimming.pool.presentation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import swimming.pool.application.RegisterSwimmingPoolService;
import swimming.pool.application.result.RegisterResult;
import swimming.pool.presentation.request.SwimmingPoolInfoRequest;

@RestController
@RequestMapping("/swimmingpool")
public class RegisterSwimmingPoolInformationController {

  Logger logger = LoggerFactory.getLogger(this.getClass());

  private final RegisterSwimmingPoolService service;
  @Autowired
  public RegisterSwimmingPoolInformationController(RegisterSwimmingPoolService service) {
    this.service = service;
  }

  @PostMapping("/register/single")
  public String singleInformation(@RequestBody SwimmingPoolInfoRequest request) {
    RegisterResult registerResult = service.register(request.toCommand());
    return "response 200 OK";
  }

}
