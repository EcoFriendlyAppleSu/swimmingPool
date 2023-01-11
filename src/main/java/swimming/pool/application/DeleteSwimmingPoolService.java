package swimming.pool.application;

import org.springframework.stereotype.Service;
import swimming.pool.domain.swimmingpool.SwimmingPool;
import swimming.pool.domain.swimmingpool.SwimmingPoolRepository;

@Service
public class DeleteSwimmingPoolService {

  private final SwimmingPoolRepository repository;

  public DeleteSwimmingPoolService(SwimmingPoolRepository repository) {
    this.repository = repository;
  }

  public void deletePool(String poolName) {
    repository.deletePool(poolName);
  }
}
