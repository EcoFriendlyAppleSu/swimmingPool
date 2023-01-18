package swimming.pool.domain.swimmingpool;

import swimming.pool.domain.swimmingpool.vo.PositionVO;

public interface AddressToPosition {

  PositionVO toPosition(String lotAddress, String streetAddress);

}
