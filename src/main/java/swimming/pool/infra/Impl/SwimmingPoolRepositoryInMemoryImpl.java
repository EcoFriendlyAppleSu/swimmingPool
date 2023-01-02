package swimming.pool.infra.Impl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import swimming.pool.domain.SwimmingPool;
import swimming.pool.domain.SwimmingPoolRepository;
import swimming.pool.infra.exception.DuplicatedPoolInformationException;

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
    return null;
  }
}
