package swimming.pool.domain.swimmingpool.exception;

public class AddressNotAllowException extends IllegalArgumentException {

  public AddressNotAllowException() {
    super();
  }

  public AddressNotAllowException(String s) {
    super(s);
  }
}
