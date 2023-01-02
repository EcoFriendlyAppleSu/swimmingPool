package swimming.pool.domain;

public interface SwimmingPoolRepository {

  SwimmingPool save(SwimmingPool swimmingPool);

  SwimmingPool findByName(String poolName);
}
