package swimming.pool.infra.Impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import swimming.pool.domain.swimmingpool.SwimmingPool;

class SwimmingPoolRepositoryInMemoryImplTest {



  @Test
  public void swimmingPoolRegisterTest() throws Exception {
    var pool = SwimmingPool.mock();
    var repository = new SwimmingPoolRepositoryInMemoryImpl();
    var savePool = repository.save(pool);
    assertThat(savePool.getPoolId()).isEqualTo(1L);

  }

  @Test
  public void swimmingPoolEnumTypeCheckTest() throws Exception {
    // given
    SwimmingPool register = SwimmingPool.register("lee", "영업중", "서울", "영등포");

    // then
    System.out.println(register.toString());
  }

}
