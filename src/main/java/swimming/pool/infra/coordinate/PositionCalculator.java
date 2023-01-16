package swimming.pool.infra.coordinate;

import org.springframework.stereotype.Component;
import swimming.pool.domain.swimmingpool.AddressToPosition;
import swimming.pool.domain.swimmingpool.vo.PositionVO;

/*
* Address to GPS
* 하나만 존재해야 하는 입장에서 ApiKey.class를 Singleton으로 둬서 사용하는게 좋지 않을까?
* */
@Component
public class PositionCalculator implements AddressToPosition {

  NaverApiKey naverApiKey = NaverApiKey.singleton();
  @Override
  public PositionVO toPosition(String lotAddress, String streetAddress) {
    String address = checkAddress(lotAddress, streetAddress);
    return naverApiKey.toPositions(address);
  }

  private String checkAddress(String lotAddress, String streetAddress) {
    if (lotAddress.isEmpty()) {
      return streetAddress;
    }
    if (streetAddress.isEmpty()) {
      return lotAddress;
    }
    return lotAddress; // 지번 주소가 있다면 지번 주소를 기본 값으로 처리할 목적입니다.
  }
}
