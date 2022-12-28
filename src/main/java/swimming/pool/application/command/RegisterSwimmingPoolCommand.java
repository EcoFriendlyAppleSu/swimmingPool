package swimming.pool.application.command;

import swimming.pool.domain.SwimmingPool;

public class RegisterSwimmingPoolCommand {

  private String poolName; // 수영장 업체 이름
  private String state; // 폐업, 영업 관리
  private String LotNumberAddress; // 지번 주소
  private String StreetNameAddress; // 도로명 주소

  public RegisterSwimmingPoolCommand(String poolName, String state, String lotNumberAddress,
      String streetNameAddress) {
    this.poolName = poolName;
    this.state = state;
    this.LotNumberAddress = lotNumberAddress;
    this.StreetNameAddress = streetNameAddress;
  }

  public SwimmingPool toEntity() {
    return SwimmingPool.register(
        this.poolName,
        this.state,
        this.LotNumberAddress,
        this.StreetNameAddress
    );
  }
}
