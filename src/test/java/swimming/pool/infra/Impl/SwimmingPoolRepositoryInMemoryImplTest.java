package swimming.pool.infra.Impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import swimming.pool.domain.SwimmingPool;

class SwimmingPoolRepositoryInMemoryImplTest {



  @Test
  public void swimmingPoolRegisterTest() throws Exception {
    var pool = SwimmingPool.mock();
    var repository = new SwimmingPoolRepositoryInMemoryImpl();
    var savePool = repository.save(pool);
    assertThat(savePool.currentPoolId()).isEqualTo(1L);

  }

}
