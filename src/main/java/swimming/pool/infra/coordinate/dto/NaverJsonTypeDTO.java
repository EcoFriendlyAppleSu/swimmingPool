package swimming.pool.infra.coordinate.dto;

import java.util.ArrayList;
import java.util.List;

public class NaverJsonTypeDTO {

  private List<NaverJsonAddressDTO> addresses = new ArrayList<>();

  public NaverJsonTypeDTO() {
  }

  public NaverJsonTypeDTO(List<NaverJsonAddressDTO> addresses) {
    this.addresses = addresses;
  }

  public List<NaverJsonAddressDTO> getAddresses() {
    return addresses;
  }
}
