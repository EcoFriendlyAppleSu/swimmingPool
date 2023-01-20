package swimming.pool.application.swimmingpool.result;

import swimming.pool.infra.common.enums.PoolState;

public class SwimmingPoolResult {

  private String poolName; // 수영장 업체 이름
  private String state; // 폐업, 영업 관리
  private String LotNumberAddress; // 지번 주소
  private String StreetNameAddress; // 도로명 주소

  private double xpos;
  private double ypos;

  protected SwimmingPoolResult() {

  }

  public SwimmingPoolResult(String poolName, PoolState state, String lotNumberAddress,
      String streetNameAddress, double xpos, double ypos) {
    this.poolName = poolName;
    this.state = state.getMessage();
    this.LotNumberAddress = lotNumberAddress;
    this.StreetNameAddress = streetNameAddress;
    this.xpos = xpos;
    this.ypos = ypos;
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
