package swimming.pool.domain.swimmingpool;

public class XPosition {

  private double xPos;

  private XPosition(double xPos) {
    this.xPos = xPos;
  }

  public static XPosition from(double position) {
    return new XPosition(position);
  }

  public double getxPos() {
    return xPos;
  }
}
