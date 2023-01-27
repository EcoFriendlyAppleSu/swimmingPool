package swimming.pool.application.swimmingpool.result;

import swimming.pool.infra.common.enums.PoolState;

public class SwimmingPoolQueryResult {

  private String poolName;
  private String state;
  private String LotNumberAddress;
  private String StreetNameAddress;

  protected SwimmingPoolQueryResult() {
  }

  public SwimmingPoolQueryResult(String poolName, PoolState state, String lotNumberAddress,
      String streetNameAddress) {
    this.poolName = poolName;
    this.state = state.getMessage();
    LotNumberAddress = lotNumberAddress;
    StreetNameAddress = streetNameAddress;
  }

  public String getPoolName() {
    return poolName;
  }

  public String getState() {
    return state;
  }

  public String getLotNumberAddress() {
    return LotNumberAddress;
  }

  public String getStreetNameAddress() {
    return StreetNameAddress;
  }
}
