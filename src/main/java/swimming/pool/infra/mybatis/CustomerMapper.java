package swimming.pool.infra.mybatis;

import org.apache.ibatis.annotations.Mapper;
import swimming.pool.infra.mybatis.mappermodel.CustomerInfoDao;

@Mapper
public interface CustomerMapper {

  void insert(CustomerInfoDao customer);

}
