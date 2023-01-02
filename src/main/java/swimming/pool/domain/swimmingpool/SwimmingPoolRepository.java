package swimming.pool.domain.swimmingpool;

import java.util.List;

public interface SwimmingPoolRepository {

  SwimmingPool save(SwimmingPool swimmingPool);

  SwimmingPool findByName(String poolName);

  void updateByName(SwimmingPool swimmingPool);

  List<SwimmingPool> findAll();
}
