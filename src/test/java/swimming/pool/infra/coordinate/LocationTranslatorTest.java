package swimming.pool.infra.coordinate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import swimming.pool.domain.swimmingpool.vo.PositionVO;

class LocationTranslatorTest {

  @Test
  public void locationStringTranslatingTest() throws Exception {
    String point = "point(10.3 23.2)";
    PositionVO positionVO = LocationTranslator.doTranslate(point);

    assertThat(positionVO.getXpos()).isEqualTo(10.3);
    assertThat(positionVO.getYpos()).isEqualTo(23.2);
  }

}
