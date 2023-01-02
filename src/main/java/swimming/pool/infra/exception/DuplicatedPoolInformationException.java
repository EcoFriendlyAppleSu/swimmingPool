package swimming.pool.infra.exception;

public class DuplicatedPoolInformationException extends IllegalArgumentException {

  public DuplicatedPoolInformationException() {
  }

  public DuplicatedPoolInformationException(String s) {
    super(s);
  }
}
