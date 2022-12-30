package swimming.pool.infra.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "swimming/pool/infra/mybatis")
public class MybatisConfig {

}
