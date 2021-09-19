package com.yzb.event.listener;

import com.yzb.event.YzhenEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * ClassName: YzhenbListener
 * Description:
 * date: 2021/9/19 19:31
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */

@Slf4j
public class YzhenbListener implements ApplicationListener<YzhenEvent> {
    @Override
    public void onApplicationEvent(YzhenEvent event) {
        log.info("【YzhenbListener】");
        event.show();
    }
}
