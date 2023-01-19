package swimming.pool.application.swimmingpool.result;

public class SwimmingPoolUpdateResult {

  private Long poolId;

  protected SwimmingPoolUpdateResult() {
  }

  public SwimmingPoolUpdateResult(Long poolId) {
    this.poolId = poolId;
  }

  public Long getPoolId() {
    return poolId;
  }
}
