package org.example;

import org.example.Service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan({"org.example.Service", "org.example.Controller"})
@EntityScan("org.example.Entity")
@EnableJpaRepositories("org.example.DAO")
public class Main implements CommandLineRunner {
/*
    @Autowired
    NoteService service;
    @Autowired
    JdbcTemplate jdbcTemplate;
*/
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    public void run(String... args) {
    }
/*
        service.createNode("My first note", "Hi I'm Himanshu and this is my first note.");
        service.createNode("Shopping", "Paneer, Tofu, Capsicum");
        Map<String, String> ret = service.allNotes();
        printNote(ret);

        service.updateNote("Shopping", "Paneer, Tofu, Capsicum, Milk, Tomato");
        ret = service.allNotes();
        printNote(ret);
        service.deleteNode("Shopping");
        ret = service.allNotes();
        printNote(ret);
    }

    public static void printNote(Map<String, String> map) {
        map.forEach((k, v) -> {
            System.out.println("Title:" + k + "\nContent:" + v);
        });
        System.out.println();
    }
*/
}