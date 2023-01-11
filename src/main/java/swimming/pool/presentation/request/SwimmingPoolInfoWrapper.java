package swimming.pool.presentation.request;

import java.util.List;
import java.util.stream.Collectors;
import swimming.pool.application.command.RegisterSwimmingPoolCommand;

public class SwimmingPoolInfoWrapper {

  private List<SwimmingPoolInfoRequest> data;

  protected SwimmingPoolInfoWrapper() {
  }

  public List<SwimmingPoolInfoRequest> getData() {
    return data;
  }

  public List<RegisterSwimmingPoolCommand> toCommands() {
    return data.stream().map(pool -> pool.toCommand())
        .collect(Collectors.toList());
  }
}
