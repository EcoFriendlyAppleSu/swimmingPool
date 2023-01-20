package swimming.pool.application.swimmingpool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import swimming.pool.application.swimmingpool.result.SwimmingPoolResult;
import swimming.pool.domain.swimmingpool.SwimmingPool;
import swimming.pool.domain.swimmingpool.SwimmingPoolRepository;

@Transactional(readOnly = true)
@Service
public class QuerySwimmingPoolService {

  private final SwimmingPoolRepository repository;
  Logger logger = LoggerFactory.getLogger(this.getClass());

  public QuerySwimmingPoolService(SwimmingPoolRepository repository) {
    this.repository = repository;
  }

  public SwimmingPoolResult findSwimmingPool(String poolName) {
    SwimmingPool swimmingPool = repository.findByName(poolName);
    return new SwimmingPoolResult(
        swimmingPool.getPoolName(),
        swimmingPool.getState(),
        swimmingPool.getLotNumberAddress(),
        swimmingPool.getLotNumberAddress(),
        swimmingPool.getxPosition(),
        swimmingPool.getyPosition()
    );
  }


}
