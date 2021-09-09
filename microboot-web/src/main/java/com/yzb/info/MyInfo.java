package com.yzb.info;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

/**
 * ClassName: MyInfo
 * Description:
 * date: 2021/9/9 20:30
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
@Component
public class MyInfo implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("易振邦真帅","是的");
        builder.withDetail("顾飞好gay","是的~我老婆");
    }
}
