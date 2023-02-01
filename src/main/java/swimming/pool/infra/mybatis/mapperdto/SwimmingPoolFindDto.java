package swimming.pool.infra.mybatis.mapperdto;

import swimming.pool.domain.swimmingpool.SwimmingPool;

public class SwimmingPoolFindDto {

  private Long poolId;
  private String poolName;
  private String poolState;
  private String lotAddress;
  private String streetAddress;
  private String xPos;
  private String yPos;

  public SwimmingPoolFindDto(Long poolId, String poolName, String poolState, String lotAddress,
      String streetAddress, String xPos, String yPos) {
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

  public String getxPos() {
    return xPos;
  }

  public String getyPos() {
    return yPos;
  }

  public SwimmingPool toEntity() {
    return SwimmingPool.getInstance(
        this.poolId,
        this.poolName,
        this.poolState,
        this.lotAddress,
        this.streetAddress,
        Double.valueOf(xPos),
        Double.valueOf(yPos)
    );
  }

  @Override
  public String toString() {
    return "SwimmingPoolFindDto{" +
        "poolId=" + poolId +
        ", poolName='" + poolName + '\'' +
        ", poolState='" + poolState + '\'' +
        ", lotAddress='" + lotAddress + '\'' +
        ", streetAddress='" + streetAddress + '\'' +
        ", xPos='" + xPos + '\'' +
        ", yPos='" + yPos + '\'' +
        '}';
  }
}
