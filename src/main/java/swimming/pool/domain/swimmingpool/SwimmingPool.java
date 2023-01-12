package swimming.pool.domain.swimmingpool;

import swimming.pool.domain.swimmingpool.exception.AddressNotAllowException;
import swimming.pool.infra.common.enums.PoolState;

public class SwimmingPool {

  private Long poolId; // auto increment 식별자 값이 필요합니다.
  private PoolName poolName; // 수영장 업체 이름
  private PoolState state; // 폐업, 영업 관리
  private LotAddress lotNumberAddress; // 지번 주소
  private StreetAddress streetNameAddress; // 도로명 주소

  public SwimmingPool() {
  }

  private SwimmingPool(String poolName, String state, String lotNumberAddress,
      String streetNameAddress) {
    addressValidation(lotNumberAddress, streetNameAddress);

    this.poolName = PoolName.from(poolName);
    this.lotNumberAddress = LotAddress.from(lotNumberAddress);
    this.streetNameAddress = StreetAddress.from(streetNameAddress);
    this.state = messageForState(state);
    this.state = messageForState(state);
  }

  public static SwimmingPool register(String poolName, String state, String lotNumberAddress,
      String streetNameAddress) {
    return new SwimmingPool(poolName, state, lotNumberAddress, streetNameAddress);
  }

  public SwimmingPool(Long poolId, String poolName, String state, String lotNumberAddress,
      String streetNameAddress) {
    this.poolId = poolId;
    this.poolName = PoolName.from(poolName);
    this.state = messageForState(state);
    addressValidation(lotNumberAddress, streetNameAddress);
    this.lotNumberAddress = LotAddress.from(lotNumberAddress);
    this.streetNameAddress = StreetAddress.from(streetNameAddress);
  }

  private void addressValidation(String lotNumberAddress, String streetNameAddress) {
    if (lotNumberAddress.isEmpty() && streetNameAddress.isEmpty()) {
      throw new AddressNotAllowException();
    }
  }

  private PoolState messageForState(String state) {
    if (PoolState.OPEN.getMessage().equals(state)) {
      return PoolState.OPEN;
    }
    if (PoolState.CLOSE.getMessage().equals(state)) {
      return PoolState.CLOSE;
    }
    return PoolState.ETC;
  }

  private PoolState nameForState(String state) {
    if (PoolState.OPEN.name().equals(state)) {
      return PoolState.OPEN;
    }
    if (PoolState.CLOSE.name().equals(state)) {
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
  public Long getPoolId() {
    return this.poolId;
  }


  public String getPoolName() {
    return poolName.getPoolName();
  }

  public PoolState getState() {
    return state;
  }

  public String  getLotNumberAddress() {
    return lotNumberAddress.getAddress();
  }

  public String getStreetNameAddress() {
    return streetNameAddress.getAddress();
  }

  @Override
  public String toString() {
    return "SwimmingPool{" +
        "poolId=" + poolId +
        ", poolName=" + poolName.getPoolName() +
        ", state=" + getState() +
        ", lotNumberAddress=" + lotNumberAddress.getAddress() +
        ", streetNameAddress=" + streetNameAddress.getAddress() +
        '}';
  }
}
