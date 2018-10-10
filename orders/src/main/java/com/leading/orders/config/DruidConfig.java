package com.leading.orders.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    @Autowired
    private Environment env;

    //@ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));//用户名
        dataSource.setPassword(env.getProperty("spring.datasource.password"));//密码
        dataSource.setInitialSize(10);
        dataSource.setMaxActive(50);
        dataSource.setMinIdle(0);
        dataSource.setMaxWait(60000);
        dataSource.setValidationQuery("SELECT 1");
        dataSource.setTestOnBorrow(false);
        dataSource.setTestWhileIdle(true);
        dataSource.setPoolPreparedStatements(false);
        return dataSource;
    }

    @Bean
    public ServletRegistrationBean<StatViewServlet> statViewServletServlet(){
        ServletRegistrationBean<StatViewServlet> servletRegistrationBean = new ServletRegistrationBean<>(new StatViewServlet());
        servletRegistrationBean.addUrlMappings("/druid/*");
        Map<String,String> initParams = new HashMap<>();
        initParams.put("loginUsername","admin"  );
        initParams.put("loginPassword","admin");
        //默认允许所有
        initParams.put("allow","");
        initParams.put("deny","192.168.1.12");

        servletRegistrationBean.setInitParameters(initParams);

        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean<WebStatFilter> webStatFilter(){
        FilterRegistrationBean<WebStatFilter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new WebStatFilter());

        Map<String,String> initParams = new HashMap<>();
        initParams.put("exclusions","*.js,*.css,/druid/*");
        filterFilterRegistrationBean.setInitParameters(initParams);

        filterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));

        return filterFilterRegistrationBean;
    }
}
