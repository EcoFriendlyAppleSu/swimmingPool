package swimming.pool.application.command;

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

  public SwimmingPool toEntity() {
    return new SwimmingPool(
        this.poolId,
        this.poolName,
        this.state,
        this.LotNumberAddress,
        this.StreetNameAddress
    );
  }

}
