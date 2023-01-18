package swimming.pool.domain.swimmingpool;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import swimming.pool.domain.swimmingpool.exception.AddressNotAllowException;

class SwimmingPoolTest {

  @Test
  public void swimmingPoolAddressExceptionTest() throws Exception {
    Assertions.assertThatThrownBy(() -> SwimmingPool.register("Lee", "영업중", "", "", 0, 0))
        .isInstanceOf(AddressNotAllowException.class);
  }

}
