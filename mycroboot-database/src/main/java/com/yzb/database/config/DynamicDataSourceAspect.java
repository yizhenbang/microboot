package com.yzb.database.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * ClassName: DynamicDataSourceAspect
 * Description:
 * date: 2021/10/6 19:35
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
@Component
@Aspect //定义为一个切面
@Slf4j
@Order(-100) //尽量让该配置提前生效
public class DynamicDataSourceAspect {

    //访问yzb包下的数据路径的时候将数据源切换成yzb
    @Before("(execution(* com.yzb.database.dao.yzb.*.*(..)))")
    public void setYZBDataSource() {
        DynamicDataSource.setDataSource(DynamicDataSource.DataSourceNames.YZB_DATASOURCE);
        log.info("【切换数据源】{}", DynamicDataSource.DataSourceNames.YZB_DATASOURCE);
    }

    //访问test包下的数据路径的时候将数据源切换成test
    @Before("(execution(* com.yzb.database.dao.yzhenb.*.*(..)))")
    public void setTESTDataSource() {
        DynamicDataSource.setDataSource(DynamicDataSource.DataSourceNames.TEST_DATASOURCE);
        log.info("【切换数据源】{}", DynamicDataSource.DataSourceNames.TEST_DATASOURCE);
    }
}
