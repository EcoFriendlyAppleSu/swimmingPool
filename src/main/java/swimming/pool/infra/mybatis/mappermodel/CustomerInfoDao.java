package swimming.pool.infra.mybatis.mappermodel;

public class CustomerInfoDao {

  private Long customerId;
  private String name;
  private int age;

  public CustomerInfoDao(String name, int age) {
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
