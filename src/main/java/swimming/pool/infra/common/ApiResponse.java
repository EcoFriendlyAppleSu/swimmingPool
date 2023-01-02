package swimming.pool.infra.common;

public class ApiResponse<T> {

  private final boolean success;
  private final T body;
  private final Error error;

  private ApiResponse(boolean success, T body, Error error) {
    this.success = success;
    this.body = body;
    this.error = error;
  }

  /*
  * Generic Type T를 사용하기 위해선 Param으로 T를 가지고 있어야합니다.
  * */
  public static <T> ApiResponse success(T data) {
    return new ApiResponse(true, data, null);
  }

  public static <T> ApiResponse fail(String code, String message) {
    return new ApiResponse(false, null, new Error(code, message));
  }

  public boolean isSuccess() {
    return success;
  }

  public T getBody() {
    return body;
  }

  public Error getError() {
    return error;
  }

  public static class Error {

    private final String code;
    private final String message;

    public Error(String code, String message) {
      this.code = code;
      this.message = message;
    }

    public String getCode() {
      return code;
    }

    public String getMessage() {
      return message;
    }
  }

}
