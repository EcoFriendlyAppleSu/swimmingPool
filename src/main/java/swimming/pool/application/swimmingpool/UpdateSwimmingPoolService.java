package swimming.pool.application.swimmingpool;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import swimming.pool.application.swimmingpool.command.UpdateSwimmingPoolCommand;
import swimming.pool.application.swimmingpool.result.SwimmingPoolUpdateResult;
import swimming.pool.domain.swimmingpool.AddressToPosition;
import swimming.pool.domain.swimmingpool.SwimmingPoolRepository;
import swimming.pool.infra.common.exception.ErrorCode;
import swimming.pool.infra.common.exception.SwimmingPoolException;

@Service
public class UpdateSwimmingPoolService {

  private final SwimmingPoolRepository repository;
  private final AddressToPosition addressToPosition;

  public UpdateSwimmingPoolService(SwimmingPoolRepository repository,
      AddressToPosition addressToPosition) {
    this.repository = repository;
    this.addressToPosition = addressToPosition;
  }

  @Transactional
  public SwimmingPoolUpdateResult update(UpdateSwimmingPoolCommand updateCommand, Long poolId) {
    if (!repository.existById(poolId)) { // return true or false
      throw new SwimmingPoolException(ErrorCode.DOES_NOT_EXIST);
    }
    updateCommand.initPoolId(poolId);

    repository.update(updateCommand.toEntity());
    return new SwimmingPoolUpdateResult(updateCommand.getPoolId());
  }
}
