package swimming.pool.application.result;

public class SwimmingPoolDeleteResult {

  private Long poolId;

  protected SwimmingPoolDeleteResult() {
  }

  public SwimmingPoolDeleteResult(Long poolId) {
    this.poolId = poolId;
  }

  public Long getPoolId() {
    return poolId;
  }
}
