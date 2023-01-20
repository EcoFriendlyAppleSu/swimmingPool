package swimming.pool.domain.swimmingpool.dao;

import swimming.pool.domain.swimmingpool.SwimmingPool;

public class SwimmingPoolDAO {

  private Long poolId;
  private String poolName;
  private String poolState;
  private String lotAddress;
  private String streetAddress;

  private double xPos;
  private double yPos;

  protected SwimmingPoolDAO() {
  }

  public SwimmingPoolDAO(Long poolId, String poolName, String poolState, String lotAddress,
      String streetAddress, double xPos, double yPos) {
    this.poolId = poolId;
    this.poolName = poolName;
    this.poolState = poolState;
    this.lotAddress = lotAddress;
    this.streetAddress = streetAddress;
    this.xPos = xPos;
    this.yPos = yPos;
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

  public double getxPos() {
    return xPos;
  }

  public double getyPos() {
    return yPos;
  }

  public SwimmingPool toEntity() {
    return new SwimmingPool(
        this.poolId,
        this.poolName,
        this.poolState,
        this.lotAddress,
        this.streetAddress,
        this.xPos,
        this.yPos
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
