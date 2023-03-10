package swimming.pool.domain.swimmingpool;

public class LotAddress {

  private String address;

  protected LotAddress() {
  }

  private LotAddress(String address) {
    this.address = address;
  }

  public static LotAddress from(String address) {
    return new LotAddress(address);
  }

  public String getAddress() {
    return this.address;
  }
}
