package swimming.pool.infra.repository;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import swimming.pool.domain.swimmingpool.SwimmingPool;
import swimming.pool.domain.swimmingpool.SwimmingPoolRepository;
import swimming.pool.infra.common.exception.ErrorCode;
import swimming.pool.infra.common.exception.SwimmingPoolException;
import swimming.pool.infra.mybatis.SwimmingPoolMapper;
import swimming.pool.infra.mybatis.mappermodel.SwimmingPoolRegisterModel;

@Repository
public class SwimmingPoolRepositoryAdapter implements SwimmingPoolRepository {

  private final SwimmingPoolMapper swimmingPoolMapper;
  Logger logger = LoggerFactory.getLogger(this.getClass());

  public SwimmingPoolRepositoryAdapter(SwimmingPoolMapper swimmingPoolMapper) {
    this.swimmingPoolMapper = swimmingPoolMapper;
  }

  @Override
  public SwimmingPool save(SwimmingPool swimmingPool) {
    if (swimmingPool.getPoolId() == null || swimmingPool.getPoolId() <= 0L) {
      var model = new SwimmingPoolRegisterModel(
          swimmingPool.getPoolName(),
          swimmingPool.getState().name(),
          swimmingPool.getLotNumberAddress(),
          swimmingPool.getStreetNameAddress(),
          swimmingPool.getxPosition(),
          swimmingPool.getyPosition()
      );
      swimmingPoolMapper.insert(model);
      return swimmingPool;
    }
    return null;
  }

  @Override
  public SwimmingPool findByName(String poolName) {
    var dto = swimmingPoolMapper.findByName(poolName);
    if (dto == null) {
      throw new SwimmingPoolException(ErrorCode.DOES_NOT_EXIST);
    }
    return dto.toEntity();
  }

  @Override
  public void update(SwimmingPool swimmingPool) {
    swimmingPoolMapper.update(swimmingPool);
  }

  @Override
  public List<SwimmingPool> findAll() {
    return null;
  }

  @Override
  public void softDeletePool(Long poolId) {
    swimmingPoolMapper.changeStateToCLOSE(poolId);
  }

  @Override
  public boolean existById(Long poolId) {
    return swimmingPoolMapper.existById(poolId);
  }

  @Override
  public SwimmingPool findById(Long poolId) {
    var dto = swimmingPoolMapper.findById(poolId);
    if (dto == null) {
      throw new SwimmingPoolException(ErrorCode.DOES_NOT_EXIST);
    }
    return dto.toEntity();
  }
}
