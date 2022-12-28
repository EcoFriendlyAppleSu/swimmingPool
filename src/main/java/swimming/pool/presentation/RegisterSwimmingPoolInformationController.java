package swimming.pool.presentation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import swimming.pool.presentation.request.SwimmingPoolInfoRequest;

@RestController
@RequestMapping("/swimmingpool")
public class RegisterSwimmingPoolInformationController {

  Logger logger = LoggerFactory.getLogger(this.getClass());

  @PostMapping("/register/single")
  public String singleInformation(@RequestBody SwimmingPoolInfoRequest request) {
    logger.info("RegisterSwimmingPoolInformationController works well");
    return "response 200 OK";
  }

}
