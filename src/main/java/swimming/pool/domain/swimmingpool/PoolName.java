package swimming.pool.domain.swimmingpool;

import swimming.pool.domain.exception.PoolNameOutOfLengthException;

public class PoolName {

  private String poolName;

  private PoolName(String poolName) {
    if (canPoolName(poolName)) {
      this.poolName = poolName;
    }
  }

  public static PoolName from(String poolName) {
    return new PoolName(poolName);
  }

  public boolean canPoolName(String poolName) {
    if (!(poolName.length() >= 0 || poolName.length() < 15)) {
      throw new PoolNameOutOfLengthException("수영장 이름으로 적합한 값이 아닙니다.");
    }
    return true;
  }

  public String currentPoolName() {
    return poolName;
  }

  public void changeName(String poolName) {
    this.poolName = poolName;
  }
}
