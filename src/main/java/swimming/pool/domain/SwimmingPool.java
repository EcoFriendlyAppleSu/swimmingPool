package swimming.pool.domain;

import swimming.pool.domain.enums.CurrentState;

public class SwimmingPool {

  private Long poolId; // auto increment 식별자 값이 필요합니다.
  private String poolName; // 수영장 업체 이름
  private CurrentState state; // 폐업, 영업 관리
  private String LotNumberAddress; // 지번 주소
  private String StreetNameAddress; // 도로명 주소

  protected SwimmingPool() {
  }

  private SwimmingPool(String poolName, String state, String lotNumberAddress,
      String streetNameAddress) {
    // TODO: 2022/12/28 각 entity에 데이터 전달 필요

  }
  public static SwimmingPool register(String poolName, String state, String lotNumberAddress,
      String streetNameAddress) {
    return new SwimmingPool(poolName, state, lotNumberAddress, streetNameAddress);
  }

  /*
  * Auto Increment를 위한 식별자 값 Setter
  * */
  public void setIdentifier(Long poolId) {
    this.poolId = poolId;
  }
}
