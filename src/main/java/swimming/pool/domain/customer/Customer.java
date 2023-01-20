package swimming.pool.domain.customer;

public class Customer {

  private Long id;

  private String name;
  private int age;

  protected Customer() {
  }

  public Customer(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }
}
