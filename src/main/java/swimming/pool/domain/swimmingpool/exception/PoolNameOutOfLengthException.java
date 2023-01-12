package swimming.pool.domain.swimmingpool.exception;

public class PoolNameOutOfLengthException extends StringIndexOutOfBoundsException {

  public PoolNameOutOfLengthException() {
  }

  public PoolNameOutOfLengthException(String s) {
    super(s);
  }
}
