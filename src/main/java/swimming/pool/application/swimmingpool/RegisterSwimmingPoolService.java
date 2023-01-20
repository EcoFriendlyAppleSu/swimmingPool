package swimming.pool.application.swimmingpool;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import swimming.pool.application.swimmingpool.command.RegisterSwimmingPoolCommand;
import swimming.pool.application.swimmingpool.result.SwimmingPoolResult;
import swimming.pool.domain.swimmingpool.AddressToPosition;
import swimming.pool.domain.swimmingpool.SwimmingPool;
import swimming.pool.domain.swimmingpool.SwimmingPoolRepository;
import swimming.pool.domain.swimmingpool.vo.PositionVO;

@Service
public class RegisterSwimmingPoolService {

  private final SwimmingPoolRepository repository;
  private final AddressToPosition addressToPosition;

  public RegisterSwimmingPoolService(SwimmingPoolRepository repository,
      AddressToPosition addressToPosition) {
    this.repository = repository;
    this.addressToPosition = addressToPosition;
  }

  @Transactional
  public SwimmingPoolResult register(RegisterSwimmingPoolCommand registerCommand) {
    PositionVO positionVO = addressToPosition.toPosition(registerCommand.getLotNumberAddress(),
        registerCommand.getStreetNameAddress());
    SwimmingPool swimmingPool = repository.save(registerCommand.toEntity(positionVO.getXpos(), positionVO.getYpos()));
    return new SwimmingPoolResult(
        swimmingPool.getPoolName(),
        swimmingPool.getState(),
        swimmingPool.getLotNumberAddress(),
        swimmingPool.getStreetNameAddress(),
        swimmingPool.getxPosition(),
        swimmingPool.getyPosition()
    );
  }

  @Transactional
  public List<SwimmingPoolResult> registerMultiData(List<RegisterSwimmingPoolCommand> poolCommands) {

    List<SwimmingPool> swimmingPools = new ArrayList<>();

    for (RegisterSwimmingPoolCommand poolCommand : poolCommands) {
      PositionVO positionVO = addressToPosition.toPosition(poolCommand.getLotNumberAddress(),
          poolCommand.getStreetNameAddress());
      swimmingPools.add(repository.save(poolCommand.toEntity(positionVO.getXpos(), positionVO.getYpos())));
    }

    return swimmingPools.stream().map(swimmingPool -> new SwimmingPoolResult(
        swimmingPool.getPoolName(),
        swimmingPool.getState(),
        swimmingPool.getLotNumberAddress(),
        swimmingPool.getStreetNameAddress(),
        swimmingPool.getxPosition(),
        swimmingPool.getyPosition()
    )).collect(Collectors.toList());

    /*
    아래와 같이 만들어서 다량의 데이터를 적재하는 saveAll을 만들어보려고 처음에 생각했으나
    Stream을 사용하면 불필요한 과정 없이 일련의 처리을 save 함수 하나로 처리할 수 있습니다.
    repository.saveAll(poolCommands.stream().map(command -> command.toEntity())
        .collect(Collectors.toList()));
    */

  }

}
