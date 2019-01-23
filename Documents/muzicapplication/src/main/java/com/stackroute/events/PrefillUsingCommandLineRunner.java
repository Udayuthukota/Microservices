package com.stackroute.events;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@Component
@PropertySource(value = "classpath:application.properties")
public class PrefillUsingCommandLineRunner implements CommandLineRunner, ApplicationRunner, ApplicationListener<ContextRefreshedEvent> {
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.url}")
    private String h2Url;
    @Value("${spring.datasource.driver-class-name}")
    private String h2Driver;
    @Override
    public void run(String... args) throws SQLException {
        Connection connection= DriverManager.getConnection(h2Url,username,password);
        Statement statement=connection.createStatement();
        statement.executeUpdate("insert into track(track_id,track_comments,track_name) values(1,'ed shareen','perfect')");
        System.out.println("command line runner executed");

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Connection connection= DriverManager.getConnection(h2Url,username,password);
        Statement statement=connection.createStatement();
        statement.executeUpdate("insert into track(track_id,track_comments,track_name) values(2,'lol','lol')");
        System.out.println("application line runner executed");

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Connection connection= null;
        try {
            connection = DriverManager.getConnection(h2Url,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Statement statement= null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.executeUpdate("insert into track(track_id,track_comments,track_name) values(3,'lolll','lolll')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("context refreshed executed");

    }
}
