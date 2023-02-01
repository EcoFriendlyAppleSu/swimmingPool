package swimming.pool.infra.common.enums;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PoolStateTest {


  @Test
  public void testEnumTypePoolStateNamesMethodTest() throws Exception {
    List<String> enumStringValue = List.of("영업중", "폐업", "휴업/직권말소/등록취소");
    PoolState[] poolStates = PoolState.values();
    for (PoolState poolState : poolStates) {
      assertThat(enumStringValue).contains(poolState.getMessage());
    }

    // 저장 시 getMessage가 들어가고 name은 들어가지 않는다.
  }

  @Test
  public void poolStateGetMessageTest() throws Exception {
    String message = PoolState.OPEN.getMessage();
    assertThat(message).isEqualTo("영업중");
  }

  @Test
  public void poolStateGetNameTest() throws Exception {
    String name = PoolState.OPEN.name();
    assertThat(name).isEqualTo("OPEN");
  }
}
