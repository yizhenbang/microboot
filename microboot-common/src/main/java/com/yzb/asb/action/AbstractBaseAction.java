package com.yzb.asb.action;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * ClassName: BaseAction
 * Description:
 * date: 2021/8/27 10:35
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */

public abstract class AbstractBaseAction {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @InitBinder
    public void initDateBinder(WebDataBinder binder){

        binder.registerCustomEditor(java.util.Date.class,new PropertyEditorSupport(){
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                LocalDate localDate = LocalDate.parse(text, DATE_TIME_FORMATTER);
                Instant instant = localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
                super.setValue(java.util.Date.from(instant));
            }
        });
    }

}
