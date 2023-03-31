package com.sxw.learn.base;

public class Main {
    public static void main(String[] args) {
        JdbcTemplate template = new JdbcTemplate();
        template.query("select xxx from xxx", s -> {
            System.out.println("实际的方法实现类");
        });
    }
}
