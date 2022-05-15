package com.sxw.learn.spi;

import lombok.SneakyThrows;

import java.sql.DriverManager;
import java.util.Iterator;
import java.util.ServiceLoader;

public class TestCase {
    @SneakyThrows
    public static void main(String[] args) {
        ServiceLoader<Search> s = ServiceLoader.load(Search.class);
        Iterator<Search> iterator = s.iterator();
        while (iterator.hasNext()) {
            Search search =  iterator.next();
            search.searchDoc("hello world");
        }
        DriverManager.getConnection("jdbc:mysql://localhost:3306/seata_account", "root", "12345678");
    }
}
