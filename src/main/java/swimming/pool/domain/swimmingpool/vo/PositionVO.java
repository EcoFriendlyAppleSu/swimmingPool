package swimming.pool.domain.swimmingpool.vo;

public class PositionVO {

  private double xpos;
  private double ypos;

  private PositionVO(double xpos, double ypos) {
    this.xpos = xpos;
    this.ypos = ypos;
  }

  public static PositionVO of(double xpos, double ypos) {
    return new PositionVO(xpos, ypos);
  }

  public double getXpos() {
    return xpos;
  }

  public double getYpos() {
    return ypos;
  }
}

