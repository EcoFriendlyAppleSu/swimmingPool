package swimming.pool.presentation;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/swimmingpool/delete")
@RestController
public class DeleteSwimmingPoolController {

  @DeleteMapping("/{poolName}")
  public String delete(@PathVariable String poolName) {
    return "works well";
  }
}
