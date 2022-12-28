package swimming.pool.infra.Impl;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;
import swimming.pool.domain.SwimmingPool;
import swimming.pool.domain.SwimmingPoolRepository;

@Repository
public class SwimmingPoolRepositoryInMemoryImpl implements SwimmingPoolRepository {

  private final Map<Long, SwimmingPool> map = new HashMap<>();

  @Override
  public SwimmingPool save(SwimmingPool swimmingPool) {
    return null;
  }
}
