package swimming.pool.presentation.request;

import swimming.pool.application.command.UpdateSwimmingPoolCommand;

public class SwimmingPoolUpdateRequest {

  private String poolName;
  private String poolState;
  private String lotAddress;
  private String streetAddress;

  protected SwimmingPoolUpdateRequest() {
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

  public UpdateSwimmingPoolCommand toCommand() {
    return new UpdateSwimmingPoolCommand(
        this.poolName,
        this.poolState,
        this.lotAddress,
        this.streetAddress
    );
  }

}
