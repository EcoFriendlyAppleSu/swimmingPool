package swimming.pool.infra.mybatis;

import org.apache.ibatis.annotations.Mapper;
import swimming.pool.domain.SwimmingPool;


@Mapper
public interface SwimmingPoolMapper {

  void insert(SwimmingPool swimmingPool);
}