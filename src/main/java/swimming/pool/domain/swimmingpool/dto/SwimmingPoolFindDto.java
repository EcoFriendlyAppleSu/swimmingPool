package swimming.pool.domain.swimmingpool.dto;

import swimming.pool.domain.swimmingpool.SwimmingPool;

public class SwimmingPoolFindDto {

  private Long poolId;
  private String poolName;
  private String poolState;
  private String lotAddress;
  private String streetAddress;
  private String location;

  public SwimmingPoolFindDto(Long poolId, String poolName, String poolState, String lotAddress,
      String streetAddress, String location) {
    this.poolId = poolId;
    this.poolName = poolName;
    this.poolState = poolState;
    this.lotAddress = lotAddress;
    this.streetAddress = streetAddress;
    this.location = location;
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

  public String getLocation() {
    return location;
  }

  public SwimmingPool toEntity(double xPos, double yPos) {
    return SwimmingPool.getInstance(
        this.poolId,
        this.poolName,
        this.poolState,
        this.lotAddress,
        this.streetAddress,
        xPos,
        yPos
    );
  }
}
