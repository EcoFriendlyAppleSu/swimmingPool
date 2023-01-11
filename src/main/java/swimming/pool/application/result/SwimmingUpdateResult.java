package swimming.pool.application.result;

import swimming.pool.domain.swimmingpool.SwimmingPool;

public class SwimmingUpdateResult {

  private String poolName;

  protected SwimmingUpdateResult() {
  }

  public SwimmingUpdateResult(String poolName) {
    this.poolName = poolName;
  }

  public String getPoolName() {
    return poolName;
  }
}
