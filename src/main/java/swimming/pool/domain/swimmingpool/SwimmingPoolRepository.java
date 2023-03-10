package swimming.pool.domain.swimmingpool;

import java.util.List;

public interface SwimmingPoolRepository {

  SwimmingPool save(SwimmingPool swimmingPool);

  SwimmingPool findByName(String poolName);

  void update(SwimmingPool swimmingPool);

  List<SwimmingPool> findAll();

  void softDeletePool(Long poolId);

  boolean existById(Long poolId);

  SwimmingPool findById(Long poolId);
}
