package com.yzb.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * ClassName: MyHealth
 * Description:
 * date: 2021/9/9 20:04
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
@Component
public class MyHealth implements HealthIndicator {
    @Override
    public Health health() {
        int ServiceErrorCode = 300;
        if (ServiceErrorCode != 0) {
            return Health.down().withDetail("ServiceErrorCode", ServiceErrorCode)
                    .withException(new Exception("我这边的微服务状态不健康了")).build();
        }
        return Health.up().build();
    }
}
