package swimming.pool.infra.mybatis.mappermodel;

public class CustomerInfoModel {

  private Long customerId;
  private String name;
  private int age;

  public CustomerInfoModel(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public Long getCustomerId() {
    return customerId;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }
}
