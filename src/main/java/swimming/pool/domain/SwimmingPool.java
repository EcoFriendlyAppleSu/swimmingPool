package swimming.pool.domain;

import swimming.pool.domain.enums.CurrentState;

public class SwimmingPool {

  private Long poolId;
  private String poolName; // 수영장 업체 이름
  private CurrentState state; // 폐업, 영업 관리
  private String LotNumberAddress; // 지번 주소
  private String StreetNameAddress; // 도로명 주소

  protected SwimmingPool() {
  }



}
