package com.sxw.learn.util.sql;

import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.BinaryExpression;
import net.sf.jsqlparser.expression.ExpressionVisitorAdapter;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.expression.operators.relational.EqualsTo;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.*;

@Slf4j
public class SqlTest {
    public static void main(String[] args) throws JSQLParserException {
        String sql = "SELECT \n" +
                "cates.name as `主营类目`,\n" +
                "sum(total_money)/100 AS `GMV`,\n" +
                "sum(predict_serve_rate)/100 as `服务费`,\n" +
                "count(DISTINCT run_num) as `订单量`\n" +
                "from dwd_order_detail_di di inner join dim_smzdm_goods_category_itm cates\n" +
                "on di.dim_smzdm_category_id = cates.smgscyid\n" +
                "where if_valid=1 and platform_flag='值得买'\n" +
                "    and order_time >= concat($start_time$,' 00:00:00')\n" +
                "    and order_time <= concat($end_time$,' 23:59:59')\n" +
                "    and platform in ($platform$)\n" +
                "    and andtid in ($andtid$)\n" +
                "    and store_type in ($store_type$)\n" +
                "group by `主营类目`;";
//
//        Select stmt = (Select) CCJSqlParserUtil.parse(sql);
//
//        List<String> list = Lists.newArrayList();
//        for (SelectItem selectItem : ((PlainSelect)stmt.getSelectBody()).getSelectItems()) {
//            selectItem.accept(new SelectItemVisitorAdapter() {
//                @Override
//                public void visit(SelectExpressionItem item) {
//                    if (Objects.nonNull(item.getAlias()) && Objects.nonNull(item.getAlias().getName())){
//                        list.add(item.getAlias().getName().replaceAll("`",""));
//                    }
//                }
//            });
//        }
//        System.out.println(list);

//        String sqlStr="select 1 from dual where a=b";
//
//        Statement statement = CCJSqlParserUtil.parse(sql);
//        if (statement instanceof Select) {
//            Select select = (Select) statement;
//            PlainSelect plainSelect = (PlainSelect)  select.getSelectBody();
//
//            SelectExpressionItem selectExpressionItem = (SelectExpressionItem) plainSelect.getSelectItems().get(0);
//            System.out.println(selectExpressionItem.getExpression());
//
//            Table table = (Table) plainSelect.getFromItem();
//            System.out.println(table.getName());
//
//            EqualsTo equalsTo = (EqualsTo) plainSelect.getWhere();
//            Column a = (Column) equalsTo.getLeftExpression();
//            Column b = (Column) equalsTo.getRightExpression();
//            System.out.println(a.getColumnName());
//            System.out.println(b.getColumnName());
//        }


        String sqlStr = "SELECT\n" +
                "\tsu.dept_id `deptId`,\n" +
                "\tsu.user_id,\n" +
                "\tsr.role_id,\n" +
                "\tsu.user_name,\n" +
                "\tsd.dept_name,\n" +
                "\tsr.role_name\n" +
                "FROM\n" +
                "\tsys_user AS su\n" +
                "JOIN sys_dept sd ON su.dept_id = sd.dept_id\n" +
                "JOIN sys_user_role sur ON sur.user_id = su.user_id\n" +
                "JOIN sys_role sr ON sur.role_id = sr.role_id\n" +
                "WHERE\n" +
                "\tsd.dept_name = '研发部门'\n" +
                "\tand su.user_name = 'admin'\n" +
                "\tand su.dept_id = 103\n" +
                "\tor sr.role_name = '超级管理员'\n" +
                "ORDER BY\n" +
                "\tsd.create_time DESC";
        Select querySql = (Select) CCJSqlParserUtil.parse(sql);
        querySql.getSelectBody().accept(new SelectVisitorAdapter() {
            @Override
            public void visit(PlainSelect plainSelect) {
                log.info("--------------查询列名----------------------------------------");
                plainSelect.getSelectItems().stream().forEach(selectItem -> {
                    selectItem.accept(new SelectItemVisitorAdapter() {
                        @Override
                        public void visit(SelectExpressionItem selectExpressionItem) {
                            String columnName = selectExpressionItem.getExpression().toString();
                            if (selectExpressionItem.getAlias() != null) {
                                columnName = columnName + ", 列别名: " + selectExpressionItem.getAlias().getName();
                            }
                            log.info(columnName);
                        }
                    });
                });
                log.info("--------------From Table Info----------------------------------------");
                String tableName = plainSelect.getFromItem().toString();
                if (plainSelect.getFromItem().getAlias() != null) {
                    tableName = tableName + "表别名:" + plainSelect.getFromItem().getAlias().getName();
                }
                log.info(tableName);
                log.info("--------------Join Table Info----------------------------------------");
                plainSelect.getJoins().stream().forEach(join -> {
                    log.info(join.toString());
                    log.info("关联表：{} ", join.getRightItem());
                    if (join.getRightItem().getAlias() != null) {
                        log.info("关联表别名：{}", join.getRightItem().getAlias().getName());
                    }
                    log.info("关联条件：{}", join.getOnExpression().toString());
                });
                log.info("--------------Where  Info----------------------------------------");
                plainSelect.getWhere().accept(new ExpressionVisitorAdapter() {
                    @Override
                    public void visitBinaryExpression(BinaryExpression expr) {
                        log.info("表达式：{}", expr.toString());
                        log.info("表达式左侧：{}", expr.getLeftExpression().toString());
                        log.info("表达式右侧：{}", expr.getRightExpression().toString());
                    }
                });
                log.info("--------------增加查询条件----------------------------------------");
                try {
                    plainSelect.setWhere(new AndExpression(CCJSqlParserUtil.parseCondExpression("1=1"), plainSelect.getWhere()));
                } catch (JSQLParserException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        log.info("语句：{}", querySql);
    }
}
