package swimming.pool.application.result;

import swimming.pool.domain.enums.CurrentState;

public class RegisterResult {

  private String poolName; // 수영장 업체 이름
  private CurrentState state; // 폐업, 영업 관리
  private String LotNumberAddress; // 지번 주소
  private String StreetNameAddress; // 도로명 주소

  public RegisterResult(String poolName, CurrentState state, String lotNumberAddress,
      String streetNameAddress) {
    this.poolName = poolName;
    this.state = state;
    LotNumberAddress = lotNumberAddress;
    StreetNameAddress = streetNameAddress;
  }

  @Override
  public String toString() {
    return "RegisterResult{" +
        "poolName='" + poolName + '\'' +
        ", state=" + state +
        ", LotNumberAddress='" + LotNumberAddress + '\'' +
        ", StreetNameAddress='" + StreetNameAddress + '\'' +
        '}';
  }
}
