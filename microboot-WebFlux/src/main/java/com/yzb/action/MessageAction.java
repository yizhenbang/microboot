package com.yzb.action;

import com.yzb.handler.MessageWebFluxHandler;
import com.yzb.vo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.beans.PropertyEditorSupport;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * ClassName: MessageAction
 * Description:
 * date: 2021/9/24 1:03
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */

@RestController
public class MessageAction {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @InitBinder
    public void initDateBinder(WebDataBinder binder) {

        binder.registerCustomEditor(java.util.Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                LocalDate localDate = LocalDate.parse(text, DATE_TIME_FORMATTER);
                Instant instant = localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
                super.setValue(java.util.Date.from(instant));
            }
        });
    }


    @Autowired
    private MessageWebFluxHandler messageWebFluxHandler;

    @RequestMapping("/echo")
    public Object echo(Message message) {
        return messageWebFluxHandler.executeSpringBoot(message);
    }
}
