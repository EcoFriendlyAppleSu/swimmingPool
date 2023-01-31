package swimming.pool.infra.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import swimming.pool.domain.swimmingpool.SwimmingPool;
import swimming.pool.domain.swimmingpool.dto.SwimmingPoolFindDto;


@Mapper
public interface SwimmingPoolMapper {

  void insert(SwimmingPool swimmingPool);

  SwimmingPoolFindDto findByName(@Param("poolName") String poolName);

  void update(SwimmingPool swimmingPool);

  boolean existById(Long poolId);
  void changeStateToCLOSE(Long poolId);

  SwimmingPoolFindDto findById(Long poolId);
}
