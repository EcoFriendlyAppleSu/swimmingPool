package swimming.pool.infra.common.exception;

import java.time.Instant;
import org.springframework.http.ResponseEntity;

public class ErrorResponse {

  private final Instant timeStamp;
  private final int status; // httpStatus integer value property
  private final String message;

  public ErrorResponse(Instant timeStamp, int status, String message) {
    this.timeStamp = timeStamp;
    this.status = status;
    this.message = message;
  }

  public static ResponseEntity<ErrorResponse> toResponseEntity(ErrorCode errorCode) {
    return ResponseEntity
        .status(errorCode.getHttpStatus())
        .body(new ErrorResponse(
                Instant.now(),
                errorCode.getHttpStatus().value(),
                errorCode.getMessage()
            )
        );
  }

  public Instant getTimeStamp() {
    return timeStamp;
  }

  public int getStatus() {
    return status;
  }

  public String getMessage() {
    return message;
  }
}
