package swimming.pool.infra.mybatis.mappermodel;

public class SwimmingPoolUpdateModel {

  private Long poolId;
  private String poolName;
  private String state;
  private String lotNumberAddress;
  private String streetNameAddress;
  private double xPosition;
  private double yPosition;

  public SwimmingPoolUpdateModel(Long poolId, String poolName, String state,
      String lotNumberAddress,
      String streetNameAddress, double xPosition, double yPosition) {
    this.poolId = poolId;
    this.poolName = poolName;
    this.state = state;
    this.lotNumberAddress = lotNumberAddress;
    this.streetNameAddress = streetNameAddress;
    this.xPosition = xPosition;
    this.yPosition = yPosition;
  }

  public Long getPoolId() {
    return poolId;
  }

  public String getPoolName() {
    return poolName;
  }

  public String getState() {
    return state;
  }

  public String getLotNumberAddress() {
    return lotNumberAddress;
  }

  public String getStreetNameAddress() {
    return streetNameAddress;
  }

  public double getxPosition() {
    return xPosition;
  }

  public double getyPosition() {
    return yPosition;
  }
}
