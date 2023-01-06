package swimming.pool.application;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import swimming.pool.application.command.RegisterSwimmingPoolCommand;
import swimming.pool.application.result.SwimmingPoolResult;
import swimming.pool.domain.swimmingpool.SwimmingPool;
import swimming.pool.domain.swimmingpool.SwimmingPoolRepository;

@Service
public class RegisterSwimmingPoolService {

  private final SwimmingPoolRepository repository;

  public RegisterSwimmingPoolService(SwimmingPoolRepository repository) {
    this.repository = repository;
  }

  public SwimmingPoolResult register(RegisterSwimmingPoolCommand registerCommand) {
    SwimmingPool swimmingPool = repository.save(registerCommand.toEntity());
    return new SwimmingPoolResult(
        swimmingPool.getPoolName(),
        swimmingPool.getState(),
        swimmingPool.getLotNumberAddress(),
        swimmingPool.getStreetNameAddress()
    );
  }

  public List<SwimmingPoolResult> registerMultiData(List<RegisterSwimmingPoolCommand> poolCommands) {
    List<SwimmingPool> swimmingPools = poolCommands.stream()
        .map(pool -> repository.save(pool.toEntity()))
        .collect(Collectors.toList());

    return swimmingPools.stream().map(swimmingPool -> new SwimmingPoolResult(
        swimmingPool.getPoolName(),
        swimmingPool.getState(),
        swimmingPool.getLotNumberAddress(),
        swimmingPool.getStreetNameAddress()
    )).collect(Collectors.toList());

    /*
    아래와 같이 만들어서 다량의 데이터를 적재하는 saveAll을 만들어보려고 처음에 생각했으나
    Stream을 사용하면 불필요한 과정 없이 일련의 처리을 save 함수 하나로 처리할 수 있습니다.
    repository.saveAll(poolCommands.stream().map(command -> command.toEntity())
        .collect(Collectors.toList()));
    */

  }

}
