package swimming.pool.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import swimming.pool.application.result.SwimmingPoolDeleteResult;
import swimming.pool.domain.swimmingpool.SwimmingPoolRepository;
import swimming.pool.infra.common.exception.ErrorCode;
import swimming.pool.infra.common.exception.SwimmingPoolException;

@Service
public class DeleteSwimmingPoolService {

  private final SwimmingPoolRepository repository;

  public DeleteSwimmingPoolService(SwimmingPoolRepository repository) {
    this.repository = repository;
  }

  @Transactional
  public SwimmingPoolDeleteResult deletePool(Long poolId) {
    if (!repository.existById(poolId)) {
      throw new SwimmingPoolException(ErrorCode.DOES_NOT_EXIST);
    }
    repository.softDeletePool(poolId);
    return new SwimmingPoolDeleteResult(poolId);
  }
}
