package org.sangaizhi.blog.portal.config.datasource;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author sangaizhi
 * @date 2017/8/23
 */
@Configuration
@MapperScan(basePackages = {"org.sangaizhi.blog.dao"})
public class DataSourceConfig {

    @Autowired
    private Environment environment;

    private static final String MYBATIS_CONFIG = "mybatis-config.xml";

    /**
     * 创建数据源
     * @return
     * @throws Exception
     */
    @Bean
    public DataSource dataSource() throws Exception{
        Properties properties = new Properties();
        properties.put("driverClassName", environment.getProperty("jdbc.driver"));
        properties.put("url", environment.getProperty("jdbc.url"));
        properties.put("username", environment.getProperty("jdbc.username"));
        properties.put("password", environment.getProperty("jdbc.password"));
        return DruidDataSourceFactory.createDataSource(properties);
    }

    /**
     * 创建 SqlSessionFactory
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(MYBATIS_CONFIG));
        sqlSessionFactoryBean.setTypeAliasesPackage(environment.getProperty("mybatis.typeAliasesPackage"));
        PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(
                pathMatchingResourcePatternResolver.getResources(environment.getProperty("mybatis.mapperLocations")));
        return sqlSessionFactoryBean.getObject();
    }
    /**
     * 配置事务管理器
     *
     * @param dataSource
     * @return
     */
    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }



}
