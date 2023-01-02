package swimming.pool.infra.repository;

import org.springframework.stereotype.Repository;
import swimming.pool.domain.SwimmingPool;
import swimming.pool.domain.SwimmingPoolRepository;
import swimming.pool.infra.mybatis.SwimmingPoolMapper;

//@Repository
public class SwimmingPoolRepositoryAdapter implements SwimmingPoolRepository {

  private final SwimmingPoolMapper swimmingPoolMapper;

  public SwimmingPoolRepositoryAdapter(SwimmingPoolMapper swimmingPoolMapper) {
    this.swimmingPoolMapper = swimmingPoolMapper;
  }

  @Override
  public SwimmingPool save(SwimmingPool swimmingPool) {
    if (swimmingPool.currentPoolId() == null || swimmingPool.currentPoolId() <= 0L) {
      swimmingPoolMapper.insert(swimmingPool);
      return swimmingPool;
    }
    return null;
  }

  @Override
  public SwimmingPool findByName(String poolName) {
    return null;
  }
}
