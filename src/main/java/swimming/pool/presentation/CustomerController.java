package swimming.pool.presentation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import swimming.pool.infra.repository.CustomerRepository;
import swimming.pool.domain.customer.Customer;

@RestController
@RequestMapping("/test")
public class CustomerController {

  private final CustomerRepository repository;

  public CustomerController(CustomerRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/1")
  public String customerSaveTest() {
    Customer lee = new Customer("Lee", 28);
    repository.save(lee);
    return "hello world";
  }
}
