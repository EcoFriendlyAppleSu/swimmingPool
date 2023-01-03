package swimming.pool.infra.common.enums;

public enum PoolState {
  OPEN("영업중"), CLOSE("폐업"), ETC("휴업/직권말소/등록취소");

  private String message;
  PoolState(String message) {
    this.message = message;
  }

  public String stateMessage() {
    return this.message;
  }
}
