package swimming.pool.infra.mybatis;

import org.apache.ibatis.annotations.Mapper;
import swimming.pool.domain.customer.Customer;

@Mapper
public interface CustomerMapper {

  void insert(Customer customer);

}
