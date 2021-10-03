package com.yzb;

import com.alibaba.druid.pool.DruidDataSource;
import com.yzb.database.StarterDruidApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * ClassName: TestDruidDatabSource
 * Description:
 * date: 2021/10/3 14:44
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@SpringBootTest(classes = StarterDruidApplication.class)
public class TestDruidDataSource {

    @Autowired
    @Qualifier("yzbDriDruidDataSource")
    private DataSource dataSource;

    @Test
    void getConn() throws SQLException {
        System.out.println(dataSource.getConnection());
    }
}
