package swimming.pool.infra.repository;

import org.springframework.stereotype.Repository;
import swimming.pool.infra.mybatis.CustomerMapper;
import swimming.pool.domain.customer.Customer;
import swimming.pool.infra.mybatis.mappermodel.CustomerInfoModel;

@Repository
public class CustomerRepository {

  private final CustomerMapper customerMapper;

  public CustomerRepository(CustomerMapper customerMapper) {
    this.customerMapper = customerMapper;
  }

  public void save(Customer lee) {
      CustomerInfoModel dao = new CustomerInfoModel(lee.getName(), lee.getAge());
    customerMapper.insert(dao);
  }
}
