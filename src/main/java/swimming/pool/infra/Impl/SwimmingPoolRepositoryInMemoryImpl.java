package swimming.pool.infra.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import swimming.pool.domain.swimmingpool.SwimmingPool;
import swimming.pool.domain.swimmingpool.SwimmingPoolRepository;
import swimming.pool.infra.common.exception.ErrorCode;
import swimming.pool.infra.common.exception.SwimmingPoolException;

//@Repository
public class SwimmingPoolRepositoryInMemoryImpl implements SwimmingPoolRepository {

  private final Map<Long, SwimmingPool> map = new HashMap<>();
  private final AtomicLong id = new AtomicLong();

  @Override
  public SwimmingPool save(SwimmingPool swimmingPool) {
    /*
    * swimmingPool.currentPoolId() == null, 값이 존재하지 않는 신규 데이터를 의미한다.
    * */
    if (swimmingPool.getPoolId() != null) {
      throw new SwimmingPoolException(ErrorCode.DUPLICATE_POOL_NAME);
    }
    Long poolId = id.incrementAndGet();
    swimmingPool.setIdentifier(poolId);
    map.put(poolId, swimmingPool);

    return swimmingPool;
  }

  @Override
  public SwimmingPool findByName(String poolName) {
    for (SwimmingPool pool : map.values()) {
      if (pool.getPoolName().equals(poolName)) {
        return pool;
      }
    }
    throw new SwimmingPoolException(ErrorCode.DOES_NOT_EXIST);
  }

  @Override
  public void update(SwimmingPool swimmingPool) {
    SwimmingPool pool = map.get(swimmingPool.getPoolId());
    map.put(pool.getPoolId(), pool);
  }

  @Override
  public void deletePool(String poolName) {
    SwimmingPool foundPool = findAll().stream().filter(pool -> pool.getPoolName().equals(poolName))
        .findFirst()
        .orElseThrow(() -> new SwimmingPoolException(ErrorCode.DOES_NOT_EXIST));
    map.remove(foundPool.getPoolId());
  }

  @Override
  public List<SwimmingPool> findAll() {
    return new ArrayList<>(map.values());
  }
}
