package swimming.pool.infra.exception;

public class SwimmingPoolNameNotExistException extends IllegalArgumentException {

  public SwimmingPoolNameNotExistException() {
  }

  public SwimmingPoolNameNotExistException(String s) {
    super(s);
  }
}
