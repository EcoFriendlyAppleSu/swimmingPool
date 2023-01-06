package swimming.pool.infra.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Repository;
import swimming.pool.domain.swimmingpool.SwimmingPool;
import swimming.pool.domain.swimmingpool.SwimmingPoolRepository;
import swimming.pool.infra.exception.DuplicatedPoolInformationException;
import swimming.pool.infra.exception.SwimmingPoolNameNotExistException;

@Repository
public class SwimmingPoolRepositoryInMemoryImpl implements SwimmingPoolRepository {

  private final Map<Long, SwimmingPool> map = new HashMap<>();
  private final AtomicLong id = new AtomicLong();

  @Override
  public SwimmingPool save(SwimmingPool swimmingPool) {
    /*
    * swimmingPool.currentPoolId() == null, 값이 존재하지 않는 신규 데이터를 의미한다.
    * */
    if (swimmingPool.currentPoolId() != null) {
      throw new DuplicatedPoolInformationException("이미 존재하는 수영장입니다.");
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
    throw new SwimmingPoolNameNotExistException("수영장이 존재하지 않습니다.");
  }

  @Override
  public void updateByName(Long poolId, String givenPoolName) {
    SwimmingPool pool = map.get(poolId);
    pool.changePoolName(givenPoolName);
  }

  @Override
  public void deletePool(String poolName) {
    SwimmingPool foundPool = findAll().stream().filter(pool -> pool.getPoolName().equals(poolName))
        .findFirst()
        .orElseThrow(() -> new SwimmingPoolNameNotExistException("수영장이 존재하지 않습니다."));
    map.remove(foundPool.currentPoolId());
  }

  @Override
  public List<SwimmingPool> findAll() {
    return new ArrayList<>(map.values());
  }

  @Override
  public List<SwimmingPool> saveAll(List<SwimmingPool> pools) {
    return null;
  }
}
