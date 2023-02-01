package swimming.pool.infra.mybatis;

import org.apache.ibatis.annotations.Mapper;
import swimming.pool.infra.mybatis.mappermodel.CustomerInfoModel;

@Mapper
public interface CustomerMapper {

  void insert(CustomerInfoModel customer);

}
