package swimming.pool.domain.swimmingpool;

import swimming.pool.infra.common.enums.PoolState;

public class SwimmingPool {

  private Long poolId; // auto increment 식별자 값이 필요합니다.
  private PoolName poolName; // 수영장 업체 이름
  private PoolState state; // 폐업, 영업 관리
  private LotAddress lotNumberAddress; // 지번 주소
  private StreetAddress streetNameAddress; // 도로명 주소

  protected SwimmingPool() {
  }

  private SwimmingPool(String poolName, String state, String lotNumberAddress,
      String streetNameAddress) {
    this.poolName = PoolName.from(poolName);
    this.lotNumberAddress = LotAddress.from(lotNumberAddress);
    this.streetNameAddress = StreetAddress.from(streetNameAddress);
    this.state = formState(state);
  }

  public static SwimmingPool register(String poolName, String state, String lotNumberAddress,
      String streetNameAddress) {

    return new SwimmingPool(poolName, state, lotNumberAddress, streetNameAddress);
  }

  private PoolState formState(String state) {
    if (PoolState.OPEN.getMessage().equals(state)) {
      return PoolState.OPEN;
    }
    if (PoolState.CLOSE.getMessage().equals(state)) {
      return PoolState.CLOSE;
    }
    return PoolState.ETC;
  }


  public boolean canChangePoolName(String poolName) {
    if (!this.poolName.canPoolName(poolName)) {
      return false;
    }
    return true;
  }

  public void changePoolName(String poolName) {
    this.poolName.changeName(poolName);
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
    return this.poolName.currentPoolName();
  }

  public String getState() {
    return state.getMessage();
  }

  public String getLotNumberAddress() {
    return lotNumberAddress.currentLotAddress();
//    return this.lotNumberAddress;
  }

  public String getStreetNameAddress() {
    return streetNameAddress.currentStreetAddress();
//    return this.streetNameAddress;
  }
}
