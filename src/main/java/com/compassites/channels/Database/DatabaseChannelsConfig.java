package com.compassites.channels.Database;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration 
public class DatabaseChannelsConfig {
	@Bean(name = "channelsdb")
	@ConfigurationProperties(prefix = "spring.ds_channels")
    public DataSource channelsDataSource() { 
		return DataSourceBuilder.create().build(); 
    } 

    @Bean(name = "channelsJdbcTemplate") 
    public JdbcTemplate channelsJdbcTemplate(@Qualifier("channelsdb") DataSource channelsdb) { 
        return new JdbcTemplate(channelsdb); 
    } 
    
    @Bean(name = "bushfiredb")
	@ConfigurationProperties(prefix = "spring.ds_bushfire")
    public DataSource bushfireDataSource() { 
		return DataSourceBuilder.create().build(); 
    } 

    @Bean(name = "bushfireJdbcTemplate") 
    public JdbcTemplate bushfireJdbcTemplate(@Qualifier("bushfiredb") DataSource bushfiredb) { 
        return new JdbcTemplate(bushfiredb); 
    } 
}
