package swimming.pool.domain.swimmingpool.dao;

import swimming.pool.domain.swimmingpool.SwimmingPool;

public class SwimmingPoolDAO {

  private Long poolId;
  private String poolName;
  private String poolState;
  private String lotAddress;
  private String streetAddress;

  protected SwimmingPoolDAO() {
  }

  public SwimmingPoolDAO(Long poolId, String poolName, String poolState, String lotAddress,
      String streetAddress) {
    this.poolId = poolId;
    this.poolName = poolName;
    this.poolState = poolState;
    this.lotAddress = lotAddress;
    this.streetAddress = streetAddress;
  }

  public Long getPoolId() {
    return poolId;
  }

  public String getPoolName() {
    return poolName;
  }

  public String getPoolState() {
    return poolState;
  }

  public String getLotAddress() {
    return lotAddress;
  }

  public String getStreetAddress() {
    return streetAddress;
  }

  public SwimmingPool toService() {
    return new SwimmingPool(
        this.poolId,
        this.poolName,
        this.poolState,
        this.lotAddress,
        this.streetAddress
    );
  }

  @Override
  public String toString() {
    return "SwimmingPoolDAO{" +
        "poolId=" + poolId +
        ", poolName='" + poolName + '\'' +
        ", poolState='" + poolState + '\'' +
        ", lotNumberAddress='" + lotAddress + '\'' +
        ", streetNameAddress='" + streetAddress + '\'' +
        '}';
  }
}
