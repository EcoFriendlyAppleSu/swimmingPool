package swimming.pool.application.result;

import swimming.pool.domain.swimmingpool.SwimmingPool;

public class SwimmingUpdateResult {

  private Long poolId;

  protected SwimmingUpdateResult() {
  }

  public SwimmingUpdateResult(Long poolId) {
    this.poolId = poolId;
  }

  public Long getPoolId() {
    return poolId;
  }
}
