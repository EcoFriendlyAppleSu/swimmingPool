package swimming.pool.infra.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import swimming.pool.domain.swimmingpool.SwimmingPool;
import swimming.pool.application.swimmingpool.dto.SwimmingPoolFindDto;
import swimming.pool.infra.mybatis.mappermodel.SwimmingPoolRegisterModel;
import swimming.pool.infra.mybatis.mappermodel.SwimmingPoolUpdateModel;


@Mapper
public interface SwimmingPoolMapper {

  void insert(SwimmingPoolRegisterModel registerModel);

  SwimmingPoolFindDto findByName(@Param("poolName") String poolName);

  void update(SwimmingPoolUpdateModel updateModel);

  boolean existById(Long poolId);
  void changeStateToCLOSE(Long poolId);

  SwimmingPoolFindDto findById(Long poolId);
}
