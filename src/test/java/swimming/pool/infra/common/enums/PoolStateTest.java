package swimming.pool.infra.common.enums;

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
      Assertions.assertThat(enumStringValue).contains(poolState.name());
    }

    // 저장 시 getMessage가 들어가고 name은 들어가지 않는다.
  }

  @Test
  public void poolStateTest() throws Exception {
    // given

    // when

    // then
    System.out.println(PoolState.OPEN.getMessage());
  }
}
