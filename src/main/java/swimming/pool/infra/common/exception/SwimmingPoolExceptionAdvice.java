package swimming.pool.infra.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import swimming.pool.infra.common.ApiResponse;

@RestControllerAdvice
public class SwimmingPoolExceptionAdvice {

  Logger logger = LoggerFactory.getLogger(this.getClass());

  @ExceptionHandler(value = SwimmingPoolException.class)
  protected ApiResponse<ErrorCode> handleSwimmingPoolException(SwimmingPoolException e) {
    logger.error("SwimmingPoolException Code : {}, Message : {}",
        e.getErrorCode().getHttpStatus(),
        e.getErrorCode().getMessage());
    return ApiResponse.fail(e.getErrorCode().getHttpStatus().value(),
        e.getErrorCode().getMessage());
  }
}
