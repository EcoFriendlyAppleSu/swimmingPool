package swimming.pool.application;

import org.springframework.stereotype.Service;
import swimming.pool.application.command.RegisterSwimmingPoolCommand;
import swimming.pool.application.result.SwimmingPoolResult;
import swimming.pool.domain.SwimmingPool;
import swimming.pool.domain.SwimmingPoolRepository;

@Service
public class RegisterSwimmingPoolService {

  private final SwimmingPoolRepository repository;

  public RegisterSwimmingPoolService(SwimmingPoolRepository repository) {
    this.repository = repository;
  }

  public SwimmingPoolResult register(RegisterSwimmingPoolCommand registerCommand) {
    SwimmingPool swimmingPool = repository.save(registerCommand.toEntity());
    return new SwimmingPoolResult(
        swimmingPool.getPoolName(),
        swimmingPool.getState(),
        swimmingPool.getLotNumberAddress(),
        swimmingPool.getStreetNameAddress()
    );
  }
}
