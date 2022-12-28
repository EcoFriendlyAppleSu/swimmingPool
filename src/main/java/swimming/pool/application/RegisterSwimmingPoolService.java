package swimming.pool.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import swimming.pool.application.command.RegisterSwimmingPoolCommand;
import swimming.pool.domain.SwimmingPoolRepository;

@Service
public class RegisterSwimmingPoolService {

  Logger logger = LoggerFactory.getLogger(this.getClass());
  private final SwimmingPoolRepository repository;

  public RegisterSwimmingPoolService(SwimmingPoolRepository repository) {
    this.repository = repository;
  }

  public void register(RegisterSwimmingPoolCommand registerCommand) {
    logger.info("RegisterSwimmingPoolService works");
  }
}
