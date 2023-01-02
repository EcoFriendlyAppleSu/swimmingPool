package swimming.pool.application;

import org.springframework.stereotype.Service;
import swimming.pool.application.result.SwimmingPoolResult;
import swimming.pool.domain.SwimmingPool;
import swimming.pool.domain.SwimmingPoolRepository;

@Service
public class QuerySwimmingPoolService {

  private final SwimmingPoolRepository repository;

  public QuerySwimmingPoolService(SwimmingPoolRepository repository) {
    this.repository = repository;
  }

  public SwimmingPoolResult findSwimmingPool(String poolName) {
    SwimmingPool swimmingPool = repository.findByName(poolName);
    return new SwimmingPoolResult(
        swimmingPool.getPoolName(),
        swimmingPool.getState(),
        swimmingPool.getLotNumberAddress(),
        swimmingPool.getStreetNameAddress()
    );
  }
}
