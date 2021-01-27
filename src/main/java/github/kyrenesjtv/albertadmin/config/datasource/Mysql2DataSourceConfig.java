//package github.kyrenesjtv.albertadmin.config.datasource;
//
//import com.alibaba.druid.filter.Filter;
//import com.alibaba.druid.pool.DruidDataSource;
//import com.alibaba.druid.wall.WallFilter;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.EnvironmentAware;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.env.Environment;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.sql.DataSource;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @ProjectName: dingDang - 副本
// * @Author: AlbertW
// * @CreateDate: 2019/3/4 16:47
// */
//@Configuration
//@MapperScan(basePackages = Mysql2DataSourceConfig.PACKAGE, sqlSessionFactoryRef = "mysqlSqlSessionFactory2")
////开启事务注解
//@EnableTransactionManagement
//public class Mysql2DataSourceConfig implements EnvironmentAware {
//    // mysqldao扫描路径
//    static final String PACKAGE = "github.kyrenesjtv.albertadmin.dao";
//    // mybatis mapper扫描路径
//    static final String MAPPER_LOCATION = "github.kyrenesjtv.albertadmin.dao.*.xml";
//    //2.0之后用这种方法，直接getProperty
//    private Environment environment;
//
//    @Autowired
//    WallFilter wallFilter;
//
//    @Override
//    public void setEnvironment(Environment environment) {
//        this.environment=environment;
//    }
//
//
//    @Bean(name = "mysqlDatasource2")
//    public DataSource mysqlDataSource() {
//        DruidDataSource datasource = new DruidDataSource();
//        datasource.setUrl(environment.getProperty("spring.read.mysql2.datasource.url"));
//        datasource.setDriverClassName(environment.getProperty("spring.read.mysql2.datasource.driverClassName"));
//        datasource.setUsername(environment.getProperty("spring.read.mysql2.datasource.username"));
//        datasource.setPassword(environment.getProperty("spring.read.mysql2.datasource.password"));
//
//        datasource.setInitialSize(Integer.valueOf(environment.getProperty("spring.mysql2.datasource.initialSize")));
//        datasource.setMinIdle(Integer.valueOf(environment.getProperty("spring.mysql2.datasource.minIdle")));
//        datasource.setMaxWait(Long.valueOf(environment.getProperty("spring.mysql2.datasource.maxWait")));
//        datasource.setMaxActive(Integer.valueOf(environment.getProperty("spring.mysql2.datasource.maxActive")));
//        datasource.setTimeBetweenEvictionRunsMillis(Long.valueOf(environment.getProperty("spring.mysql2.datasource.timeBetweenEvictionRunsMillis")));
//        datasource.setMinEvictableIdleTimeMillis(Long.valueOf(environment.getProperty("spring.mysql2.datasource.minEvictableIdleTimeMillis")));
//        datasource.setTestWhileIdle(Boolean.parseBoolean(environment.getProperty("spring.mysql2.datasource.testWhileIdle")));
//        datasource.setTestOnBorrow(Boolean.parseBoolean(environment.getProperty("spring.mysql2.datasource.testOnBorrow")));
//        datasource.setTestOnReturn(Boolean.parseBoolean(environment.getProperty("spring.mysql2.datasource.testOnReturn")));
//        datasource.setPoolPreparedStatements(Boolean.parseBoolean(environment.getProperty("spring.mysql2.datasource.poolPreparedStatements")));
//        List<Filter> filters = new ArrayList<>();
//        filters.add(wallFilter);
//        datasource.setProxyFilters(filters);
//        try {
//            datasource.setFilters("stat,wall");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return datasource;
//    }
//
//    @Bean(name = "mysqlTransactionManager2")
//    @Primary
//    public DataSourceTransactionManager mysqlTransactionManager() {
//        return new DataSourceTransactionManager(mysqlDataSource());
//    }
//
//    @Bean(name = "mysqlSqlSessionFactory2")
//    @Primary
//    public SqlSessionFactory mysqlSqlSessionFactory(@Qualifier("mysqlDatasource2") DataSource dataSource)
//            throws Exception {
//        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource);
//        //如果不使用xml的方式配置mapper，则可以省去下面这行mapper location的配置。
//        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
//                .getResources(Mysql2DataSourceConfig.MAPPER_LOCATION));
//        //开启驼峰
//        sessionFactory.getObject().getConfiguration().setMapUnderscoreToCamelCase(false);
//        return sessionFactory.getObject();
//    }
//
//
//
//}
