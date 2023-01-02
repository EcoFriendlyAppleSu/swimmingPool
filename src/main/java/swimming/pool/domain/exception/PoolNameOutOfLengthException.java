package swimming.pool.domain.exception;

public class PoolNameOutOfLengthException extends StringIndexOutOfBoundsException {

  public PoolNameOutOfLengthException() {
  }

  public PoolNameOutOfLengthException(String s) {
    super(s);
  }
}
