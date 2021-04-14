package com.game.royal.config.mysql;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.google.common.collect.Lists;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class DruidConfig {
    @ConfigurationProperties(prefix = "spring.druid")
    @Bean("druidDataSource")
    public DruidDataSource dataSource(Filter propertyFilter) {
        DruidDataSource dataSource = new DruidDataSource();
        //  添加慢日志功能Lists.newArrayList添加guava工具集
        dataSource.setProxyFilters(Lists.newArrayList(propertyFilter));
        return dataSource;
    }

    @Bean
    public Filter propertyFilter() {
        StatFilter filter = new StatFilter();
        filter.setSlowSqlMillis(3000);
        filter.setLogSlowSql(true);
        filter.setMergeSql(true);
        return filter;
    }


    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
    }
}
