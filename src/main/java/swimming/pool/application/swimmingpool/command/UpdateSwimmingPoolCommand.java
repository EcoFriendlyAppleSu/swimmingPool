package swimming.pool.application.swimmingpool.command;

import swimming.pool.domain.swimmingpool.SwimmingPool;

public class UpdateSwimmingPoolCommand {

  private Long poolId;

  private String poolName;
  private String state;
  private String LotNumberAddress;
  private String StreetNameAddress;

  protected UpdateSwimmingPoolCommand() {
  }

  public UpdateSwimmingPoolCommand(String poolName, String state, String lotNumberAddress,
      String streetNameAddress) {
    this.poolName = poolName;
    this.state = state;
    LotNumberAddress = lotNumberAddress;
    StreetNameAddress = streetNameAddress;
  }

  public void initPoolId(Long poolId) {
    this.poolId = poolId;
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
    return LotNumberAddress;
  }

  public String getStreetNameAddress() {
    return StreetNameAddress;
  }

  // TODO: 2023/01/19 변경된 주소에 맞게 좌표 값이 변경되는 로직을 만들어야 합니다.
  public SwimmingPool toEntity(double xPos, double yPos) {
    return SwimmingPool.getInstance(
        this.poolId,
        this.poolName,
        this.state,
        this.LotNumberAddress,
        this.StreetNameAddress,
        xPos,
        yPos
    );
  }

}
