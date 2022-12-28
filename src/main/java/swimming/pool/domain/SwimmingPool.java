package swimming.pool.domain;

import swimming.pool.domain.enums.CurrentState;

public class SwimmingPool {

  private Long poolId; // auto increment 식별자 값이 필요합니다.
  private String poolName; // 수영장 업체 이름
  private CurrentState state; // 폐업, 영업 관리
  private LotAddress lotNumberAddress; // 지번 주소
  private StreetAddress streetNameAddress; // 도로명 주소

  protected SwimmingPool() {
  }

  private SwimmingPool(String poolName, String state, String lotNumberAddress,
      String streetNameAddress) {
    this.poolName = poolName;
    this.lotNumberAddress = LotAddress.from(lotNumberAddress);
    this.streetNameAddress = StreetAddress.from(streetNameAddress);
    this.state = changeState(state);
  }

  public static SwimmingPool register(String poolName, String state, String lotNumberAddress,
      String streetNameAddress) {

    return new SwimmingPool(poolName, state, lotNumberAddress, streetNameAddress);
  }

  private CurrentState changeState(String state) {
    if (CurrentState.OPEN.stateMessage().equals(state)) {
      return CurrentState.OPEN;
    }
    if (CurrentState.CLOSE.stateMessage().equals(state)) {
      return CurrentState.CLOSE;
    }
    return CurrentState.ETC;
  }

  /*
  * mocking Constructor
  * */
  public static SwimmingPool mock() {
    return new SwimmingPool();
  }

  /*
  * Auto Increment를 위한 식별자 값 Setter
  * */
  public void setIdentifier(Long poolId) {
    this.poolId = poolId;
  }

  /*
  * create 동작 시 검증할 때 사용할 method
  * */
  public Long currentPoolId() {
    return this.poolId;
  }

  public String getPoolName() {
    return poolName;
  }

  public String getState() {
    return state.stateMessage();
  }

  public String getLotNumberAddress() {
    return lotNumberAddress.currentLotAddress();
  }

  public String getStreetNameAddress() {
    return streetNameAddress.currentStreetAddress();
  }
}
