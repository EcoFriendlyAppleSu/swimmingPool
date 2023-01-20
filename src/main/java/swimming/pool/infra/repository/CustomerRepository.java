package swimming.pool.infra.repository;

import org.springframework.stereotype.Repository;
import swimming.pool.infra.mybatis.CustomerMapper;
import swimming.pool.domain.customer.Customer;

@Repository
public class CustomerRepository {

  private final CustomerMapper customerMapper;

  public CustomerRepository(CustomerMapper customerMapper) {
    this.customerMapper = customerMapper;
  }

  public void save(Customer lee) {
    customerMapper.insert(lee);
  }
}
