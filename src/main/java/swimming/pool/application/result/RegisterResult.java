package swimming.pool.application.result;

public class RegisterResult {

  private String poolName; // 수영장 업체 이름
  private String state; // 폐업, 영업 관리
  private String LotNumberAddress; // 지번 주소
  private String StreetNameAddress; // 도로명 주소

  public RegisterResult(String poolName, String state, String lotNumberAddress,
      String streetNameAddress) {
    this.poolName = poolName;
    this.state = state;
    this.LotNumberAddress = lotNumberAddress;
    this.StreetNameAddress = streetNameAddress;
  }
}
