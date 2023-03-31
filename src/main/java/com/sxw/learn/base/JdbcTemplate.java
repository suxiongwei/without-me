package com.sxw.learn.base;

public class JdbcTemplate {
    public void query(String sql, RowCallbackHandler rch) {
        rch.processRow(sql);
    }
}
