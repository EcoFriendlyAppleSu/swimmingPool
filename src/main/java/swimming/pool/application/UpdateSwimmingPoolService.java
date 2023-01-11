package swimming.pool.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import swimming.pool.application.result.SwimmingUpdateResult;
import swimming.pool.domain.swimmingpool.SwimmingPool;
import swimming.pool.domain.swimmingpool.SwimmingPoolRepository;

@Service
public class UpdateSwimmingPoolService {

  private final SwimmingPoolRepository repository;

  public UpdateSwimmingPoolService(SwimmingPoolRepository repository) {
    this.repository = repository;
  }

  @Transactional
  public SwimmingUpdateResult update(String poolName, String givenName) {
    SwimmingPool swimmingPool = repository.findByName(poolName);
    if (swimmingPool.canChangePoolName(givenName)) {
      swimmingPool.changePoolName(givenName);
      repository.update(swimmingPool);
      return new SwimmingUpdateResult(swimmingPool.getPoolName());
    }
    return null;
  }
}
