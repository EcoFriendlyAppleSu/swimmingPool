package swimming.pool.infra.coordinate;

import swimming.pool.domain.swimmingpool.vo.PositionVO;

public class LocationTranslator {

  public static PositionVO doTranslate(String point) {
    String[] location = point.toLowerCase().replaceAll("point\\(", "").replaceAll("\\)", "")
        .split(" ");
    return PositionVO.LocationMapping(location);
  }

}
