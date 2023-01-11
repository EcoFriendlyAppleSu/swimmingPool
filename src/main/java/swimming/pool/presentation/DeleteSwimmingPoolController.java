package swimming.pool.presentation;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import swimming.pool.application.DeleteSwimmingPoolService;

@RequestMapping("/swimmingpool/delete")
@RestController
public class DeleteSwimmingPoolController {

  private final DeleteSwimmingPoolService service;

  public DeleteSwimmingPoolController(DeleteSwimmingPoolService service) {
    this.service = service;
  }

  @DeleteMapping("/{poolName}")
  public void delete(@PathVariable String poolName) {
    service.deletePool(poolName);
  }
}
