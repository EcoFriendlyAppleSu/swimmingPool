package swimming.pool.infra.common.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode {

  /*
   * SwimmingPool Exception Line
   * */
  DOES_NOT_EXIST(HttpStatus.NOT_FOUND, "찾고자 하는 수영장이 존재하지 않습니다."),
  DUPLICATE_POOL_NAME(HttpStatus.FORBIDDEN, "이미 존재하는 수영장입니다."),
  ;

  private final HttpStatus httpStatus;
  private final String message;

  ErrorCode(HttpStatus httpStatus, String message) {
    this.httpStatus = httpStatus;
    this.message = message;
  }

  public HttpStatus getHttpStatus() {
    return httpStatus;
  }

  public String getMessage() {
    return message;
  }
}
