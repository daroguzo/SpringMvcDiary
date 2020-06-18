package spring.diary.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.diary.dao.AccountDao;
import spring.diary.dao.DiaryDao;

@Configuration
public class JavaConfig {
    @Bean(destroyMethod = "close")
    public DataSource dataSource(){
        DataSource ds = new DataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost/diary?characterEncoding=utf8&serverTimezone=UTC");
        ds.setUsername("spring5");
        ds.setPassword("spring5");
        ds.setInitialSize(2);
        ds.setMaxActive(10);
        ds.setTestWhileIdle(true);
        ds.setMinEvictableIdleTimeMillis(60000 * 3);
        ds.setTimeBetweenEvictionRunsMillis(10 * 1000);
        return ds;

    }

    @Bean
    public AccountDao memberDao(){
        return new AccountDao(dataSource());
    }
    @Bean
    public DiaryDao diaryDao(){
        return new DiaryDao(dataSource());
    }
}