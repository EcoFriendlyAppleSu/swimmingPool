package swimming.pool.infra.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import swimming.pool.domain.swimmingpool.SwimmingPool;
import swimming.pool.infra.mybatis.mapperdto.SwimmingPoolFindDto;
import swimming.pool.infra.mybatis.mappermodel.SwimmingPoolRegisterModel;


@Mapper
public interface SwimmingPoolMapper {

  void insert(SwimmingPoolRegisterModel swimmingPoolRegisterModel);

  SwimmingPoolFindDto findByName(@Param("poolName") String poolName);

  void update(SwimmingPool swimmingPool);

  boolean existById(Long poolId);
  void changeStateToCLOSE(Long poolId);

  SwimmingPoolFindDto findById(Long poolId);
}
