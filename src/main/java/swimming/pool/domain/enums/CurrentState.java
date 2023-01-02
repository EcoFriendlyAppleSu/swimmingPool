package swimming.pool.domain.enums;

public enum CurrentState {
  OPEN("영업중"), CLOSE("폐업"), ETC("휴업/직권말소/등록취소");

  private String message;
  CurrentState(String message) {
    this.message = message;
  }

  public String stateMessage() {
    return this.message;
  }
}
