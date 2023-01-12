package swimming.pool.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import swimming.pool.application.command.UpdateSwimmingPoolCommand;
import swimming.pool.application.result.SwimmingUpdateResult;
import swimming.pool.domain.swimmingpool.SwimmingPool;
import swimming.pool.domain.swimmingpool.SwimmingPoolRepository;
import swimming.pool.infra.common.exception.ErrorCode;
import swimming.pool.infra.common.exception.SwimmingPoolException;

@Service
public class UpdateSwimmingPoolService {

  private final SwimmingPoolRepository repository;

  public UpdateSwimmingPoolService(SwimmingPoolRepository repository) {
    this.repository = repository;
  }

  @Transactional
  public SwimmingUpdateResult update(UpdateSwimmingPoolCommand updateCommand, Long poolId) {
    if (!repository.existById(poolId)) { // return true or false
      throw new SwimmingPoolException(ErrorCode.DOES_NOT_EXIST);
    }
    updateCommand.initPoolId(poolId);
    repository.update(updateCommand.toEntity());
    return new SwimmingUpdateResult(poolId);
  }
}
