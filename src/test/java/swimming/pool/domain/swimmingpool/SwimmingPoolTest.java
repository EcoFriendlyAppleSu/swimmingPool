package swimming.pool.domain.swimmingpool;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import swimming.pool.domain.swimmingpool.exception.AddressNotAllowException;
import swimming.pool.infra.common.enums.PoolState;

class SwimmingPoolTest {

  @Test
  public void swimmingPoolAddressExceptionTest() throws Exception {
    Assertions.assertThatThrownBy(() -> SwimmingPool.register("Lee", "영업중", "", "", 0, 0))
        .isInstanceOf(AddressNotAllowException.class);
  }

  @DisplayName("MessageForState Test")
  @Test
  public void swimmingPoolMessageForStateMethodTest() throws Exception {
    // Using MessageForState
    SwimmingPool pool = SwimmingPool.register("Lee", "영업중", "서울", "서울", 12, 37);
    assertThat(pool.getState()).isEqualTo(PoolState.OPEN);
  }

  @DisplayName("NameForState Test")
  @Test
  public void swimmingPoolPoolStateEnumTypeSettingMethodTest() throws Exception {
    // DB에 들어간 데이터는 Enum Type의 Name으로 저장됩니다.
    // DB 에서 값을 꺼내올 때, nameForState를 사용해야 합니다.
    SwimmingPool pool = SwimmingPool.getInstance(1L, "Lee", "OPEN", "서울", "서울", 12, 37);
    assertThat(pool.getState().name()).isEqualTo(PoolState.OPEN.name());
  }

  @Test
  public void EnumTypePoolStateMessageAndNameMethodTest() throws Exception {
    PoolState open = PoolState.OPEN;
    assertThat(open.getMessage()).isNotEqualTo(open.name());
    assertThat(open.getMessage()).isEqualTo("영업중");
    /*
    * open.getMessage() return Actual   :"영업중",
    * open.name() return Expected :"OPEN"
     * */
  }

}
