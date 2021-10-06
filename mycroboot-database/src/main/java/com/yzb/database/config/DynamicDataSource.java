package com.yzb.database.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.Map;

/**
 * ClassName: DynamicDataSourceConfiguration
 * Description:
 * date: 2021/10/6 16:58
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    //会根据不同的线程去切换不同的数据源
    private static final ThreadLocal<String> DATASOURCE_CONTEXT_HOLDER = new ThreadLocal<>();

    @Override
    protected Object determineCurrentLookupKey() {//获取一个当前可以使用的数据源
        return getDataSource();
    }

    static interface DataSourceNames {
        String YZB_DATASOURCE = "yzb";
        String TEST_DATASOURCE = "test";
    }

    public DynamicDataSource(Object defaultTargetDataSource, Map<Object, Object> targetDataSources) {
        super.setDefaultTargetDataSource(defaultTargetDataSource);//设置默认的数据源
        super.setTargetDataSources(targetDataSources);//设置所有已存在的目标数据源
        super.afterPropertiesSet();//设置属性
    }

    public static void setDataSource(String datasourceName) {
        DATASOURCE_CONTEXT_HOLDER.set(datasourceName);
    }

    public static String getDataSource() {
        return DATASOURCE_CONTEXT_HOLDER.get();
    }

    public static void clear() {
        DATASOURCE_CONTEXT_HOLDER.remove();
    }
}
