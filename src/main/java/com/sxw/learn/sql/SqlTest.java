package com.sxw.learn.sql;

import com.google.common.collect.Lists;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.select.*;

import java.util.List;
import java.util.Objects;

public class SqlTest {
    public static void main(String[] args) throws JSQLParserException {
        String sql = "select \n" +
                "formatDateTime(order_time,'%Y-%m-%d') AS date,\n" +
                "count(*) as orderNum,\n" +
                "sum(goods_num) as goodsNum,\n" +
                " toFloat64(sum(gmv)) as gmvcount ,\n" +
                "toFloat64(sumIf(gmv, is_aftersale !=0)) as aftersale_gmv,\n" +
                "countIf(1,is_aftersale !=0) as aftersale_num,\n" +
                "toFloat64(sumIf(gmv, is_aftersale =2)) as no_shipment_refund_only_gmv,\n" +
                "countIf(1,is_aftersale =2) as no_shipment_refund_only_num,\n" +
                "toFloat64(sumIf(gmv, is_aftersale =1)) as shipped_for_refund_only_gmv,\n" +
                "countIf(1,is_aftersale =1) as shipped_for_refund_only_num,\n" +
                "if(gmvcount=0,0,no_shipment_refund_only_gmv/gmvcount) as no_shipment_refund_only_gmv_rate,\n" +
                "if(gmvcount=0,0,shipped_for_refund_only_gmv/gmvcount) as shipped_for_refund_only_gmv_rate,\n" +
                "if(orderNum=0,0,no_shipment_refund_only_num/orderNum) as no_shipment_refund_only_num_rate,\n" +
                "if(orderNum=0,0,shipped_for_refund_only_num/orderNum) as shipped_for_refund_only_num_rate,\n" +
                "if(orderNum=0,0,aftersale_num/orderNum) as aftersale_gmv_rate,\n" +
                "if(goodsNum=0,0,gmvcount/goodsNum) as unit_price,\n" +
                "if(orderNum=0,0,gmvcount/orderNum) as order_unit_price\n" +
                "\n" +
                "from dwd_sub_opr_order_detail_di where ods_table_name= 'douyin_operating_order' \n" +
                "group by date \n" +
                "\n";


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
