package swimming.pool.infra.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import swimming.pool.domain.swimmingpool.SwimmingPool;
import swimming.pool.domain.swimmingpool.dao.SwimmingPoolDAO;


@Mapper
public interface SwimmingPoolMapper {

  void insert(SwimmingPool swimmingPool);

  SwimmingPoolDAO findByName(@Param("poolName") String poolName);

  void update(SwimmingPool swimmingPool);

  boolean existById(Long poolId);
  void changeStateToCLOSE(Long poolId);

  SwimmingPoolDAO findById(Long poolId);
}
