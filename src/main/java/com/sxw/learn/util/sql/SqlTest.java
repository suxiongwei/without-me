package com.sxw.learn.util.sql;

import com.google.common.collect.Lists;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.select.*;

import java.util.List;
import java.util.Objects;

public class SqlTest {
    public static void main(String[] args) throws JSQLParserException {
        String sql = "SELECT month,\n" +
                "         toFloat64(sumIf(gmv,\n" +
                "        platform ='taobao')) AS taobao_gmv, toFloat64(sumIf(service_fee,platform ='taobao')) AS taobao_fee, toUInt64(sumIf(order_num,platform ='taobao')) AS taobao_order_num, toFloat64(sumIf(gmv,platform ='jingdong')) AS jingdong_gmv, toFloat64(sumIf(service_fee,platform ='jingdong')) AS jingdong_fee, toUInt64(sumIf(order_num,platform ='jingdong')) AS jingdong_order_num, toFloat64(sumIf(gmv,platform ='suning')) AS suning_gmv, toFloat64(sumIf(service_fee,platform ='suning')) AS suning_fee, toUInt64(sumIf(order_num,platform ='suning')) AS suning_order_num, toFloat64(sumIf(gmv,platform ='pinduoduo')) AS pinduoduo_gmv, toFloat64(sumIf(service_fee,platform ='pinduoduo')) AS pinduoduo_fee, toUInt64(sumIf(order_num,platform ='pinduoduo')) AS pinduoduo_order_num, toFloat64(sumIf(gmv,platform ='douyin')) AS douyin_gmv, toFloat64(sumIf(service_fee,platform ='douyin')) AS douyin_fee, toUInt64(sumIf(order_num,platform ='douyin')) AS douyin_order_num, toFloat64(sumIf(gmv,platform ='kuaishou')) AS kuaishou_gmv, toFloat64(sumIf(service_fee,platform ='kuaishou')) AS kuaishou_fee, toUInt64(sumIf(order_num,platform ='kuaishou')) AS kuaishou_order_num\n" +
                "    FROM dws_order_detail_di AS di\n" +
                "    WHERE 1 = 1\n" +
                "            AND day >= '2021-09-01'\n" +
                "            AND day <= '2021-11-31'\n" +
                "    GROUP BY  formatDateTime(day, '%Y-%m')";

        Select stmt = (Select) CCJSqlParserUtil.parse(sql);

        List<String> list = Lists.newArrayList();
        for (SelectItem selectItem : ((PlainSelect)stmt.getSelectBody()).getSelectItems()) {
            selectItem.accept(new SelectItemVisitorAdapter() {
                @Override
                public void visit(SelectExpressionItem item) {
                    if (Objects.nonNull(item.getAlias()) && Objects.nonNull(item.getAlias().getName())){
                        list.add(item.getAlias().getName().replaceAll("`",""));
                    }
                }
            });
        }
        System.out.println(list);
    }
}
