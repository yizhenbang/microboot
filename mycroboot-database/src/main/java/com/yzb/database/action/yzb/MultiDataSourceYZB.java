package com.yzb.database.action.yzb;

import com.yzb.database.config.DynamicDataSource;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

/**
 * ClassName: MultiDataSourceTEST
 * Description:
 * date: 2021/10/6 19:42
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */

@Slf4j
@RestController
public class MultiDataSourceYZB {

    @Autowired
    private DataSource dataSource;

    @SneakyThrows
    @RequestMapping("/yzb")
    public Object show() {
        log.info("【访问数据】{}", dataSource.getConnection().getCatalog());
        return dataSource.getConnection().getCatalog();
    }
}
