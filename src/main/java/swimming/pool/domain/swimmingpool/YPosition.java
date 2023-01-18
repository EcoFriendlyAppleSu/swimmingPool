package swimming.pool.domain.swimmingpool;

public class YPosition {

  private double yPos;

  private YPosition(double yPos) {
    this.yPos = yPos;
  }

  public static YPosition from(double position) {
    return new YPosition(position);
  }

  public double getyPos() {
    return yPos;
  }
}
