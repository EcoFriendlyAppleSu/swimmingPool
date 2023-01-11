package swimming.pool.domain.swimmingpool;

public class StreetAddress {

  private String address;

  protected StreetAddress() {
  }

  private StreetAddress(String address) {
    this.address = address;
  }

  public static StreetAddress from(String address) {
    return new StreetAddress(address);
  }

  public String getAddress() {
    return address;
  }
}
