package swimming.pool.application;

import org.springframework.stereotype.Service;
import swimming.pool.application.result.SwimmingUpdateResult;
import swimming.pool.domain.swimmingpool.SwimmingPool;
import swimming.pool.domain.swimmingpool.SwimmingPoolRepository;

@Service
public class UpdateSwimmingPoolService {

  private final SwimmingPoolRepository repository;

  public UpdateSwimmingPoolService(SwimmingPoolRepository repository) {
    this.repository = repository;
  }

  public SwimmingUpdateResult updatePoolName(String poolName, String givenName) {
    SwimmingPool swimmingPool = repository.findByName(poolName);
    if (swimmingPool.canChangePoolName(givenName)) {
      repository.updateByName(swimmingPool.currentPoolId(), givenName);
      return new SwimmingUpdateResult(swimmingPool.getPoolName());
    }
    return null;
  }
}
