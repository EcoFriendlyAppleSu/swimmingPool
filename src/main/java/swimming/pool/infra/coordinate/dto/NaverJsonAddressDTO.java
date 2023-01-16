package swimming.pool.infra.coordinate.dto;

public class NaverJsonAddressDTO {

  private Double x;
  private Double y;

  protected NaverJsonAddressDTO() {
  }

  public NaverJsonAddressDTO(String x, String y) {
    this.x = Double.valueOf(x);
    this.y = Double.valueOf(y);
  }

  public Double getX() {
    return x;
  }

  public Double getY() {
    return y;
  }
}
