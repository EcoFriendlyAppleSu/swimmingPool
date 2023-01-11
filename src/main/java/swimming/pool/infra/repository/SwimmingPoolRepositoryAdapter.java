package swimming.pool.infra.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import swimming.pool.domain.swimmingpool.SwimmingPool;
import swimming.pool.domain.swimmingpool.SwimmingPoolRepository;
import swimming.pool.domain.swimmingpool.dao.SwimmingPoolDAO;
import swimming.pool.infra.mybatis.SwimmingPoolMapper;

@Repository
public class SwimmingPoolRepositoryAdapter implements SwimmingPoolRepository {

  private final SwimmingPoolMapper swimmingPoolMapper;

  public SwimmingPoolRepositoryAdapter(SwimmingPoolMapper swimmingPoolMapper) {
    this.swimmingPoolMapper = swimmingPoolMapper;
  }

  @Override
  public SwimmingPool save(SwimmingPool swimmingPool) {
    if (swimmingPool.getPoolId() == null || swimmingPool.getPoolId() <= 0L) {
      swimmingPoolMapper.insert(swimmingPool);
      return swimmingPool;
    }
    return null;
  }

  @Override
  public SwimmingPool findByName(String poolName) {
    SwimmingPoolDAO swimmingPoolDAO = swimmingPoolMapper.findByName(poolName);
    return swimmingPoolDAO.toEntity();
  }

  @Override
  public void update(SwimmingPool swimmingPool) {
    swimmingPoolMapper.update(swimmingPool);
  }

  @Override
  public List<SwimmingPool> findAll() {
    return null;
  }

  @Override
  public void deletePool(String poolName) {
  }
}
