package swimming.pool.infra.common.exception;

public class SwimmingPoolException extends RuntimeException {

  private final ErrorCode errorCode;

  public SwimmingPoolException(ErrorCode errorCode) {
    this.errorCode = errorCode;
  }

  public ErrorCode getErrorCode() {
    return errorCode;
  }
}
