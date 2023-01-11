package swimming.pool.infra.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SwimmingPoolExceptionAdvice {

  Logger logger = LoggerFactory.getLogger(this.getClass());

  @ExceptionHandler(value = SwimmingPoolException.class)
  protected ResponseEntity<ErrorResponse> handleSwimmingPoolException(SwimmingPoolException e) {
    logger.error("SwimmingPoolException Code : {}, Message : {}",
        e.getErrorCode().getHttpStatus(),
        e.getErrorCode().getMessage());
    return ErrorResponse.toResponseEntity(e.getErrorCode());
  }
}
