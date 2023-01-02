package swimming.pool.infra.repository;

import java.util.List;
import swimming.pool.domain.swimmingpool.SwimmingPool;
import swimming.pool.domain.swimmingpool.SwimmingPoolRepository;
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

  @Override
  public void updateByName(Long Id, String givenPoolName) {
  }

  @Override
  public List<SwimmingPool> findAll() {
    return null;
  }
}
