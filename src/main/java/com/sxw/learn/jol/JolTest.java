package com.sxw.learn.jol;
import java.time.LocalDateTime;
import java.util.Date;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.openjdk.jol.info.GraphLayout;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class JolTest {
    public static void main(String[] args) {
        System.out.println("----------test list-------------");
        /**
         * 测试10亿个数字的list占用内存空间
         */
        List<Integer> list = Lists.newArrayList();
        for (int i = 0; i < 1000000; i++) {
            list.add(i);
        }

        Long totalByte = GraphLayout.parseInstance(list).totalSize();
        // 40000032Byte 大概是39062k
        System.out.println("1000000个数字占用空间" + totalByte + "Byte" );
        System.out.println("1000000个数字占用空间" + totalByte / 1024 / 1024 + "m" );

        // 10亿个数字占用空间 大概就是 100000 * 390 / 1024 -> 37G
        System.out.println("10亿个数字占用空间:" + 1000 * totalByte / 1024 / 1024 / 1024 + "G");
        // 并且 ArrayList的占用是 19m LinkedList占用38m，LinkedList占用和下面测试的DTO占用差不多

        System.out.println("----------test map-------------");
        /**
         * 测试20万个数字的map占用内存空间
         */
        Map<String, String> map = Maps.newHashMap();
        for (int i = 0; i < 200000; i++) {
            map.put(String.valueOf(i), "品牌" + i);
        }
        Long mapTotalByte = GraphLayout.parseInstance(map).totalSize();
        System.out.println( mapTotalByte + "Byte" );
        System.out.println(mapTotalByte / 1024 / 1024 + "M");
        System.out.println(mapTotalByte / 1024 / 1024 / 1024 + "G");

        System.out.println("----------test array-------------");
        /**
         * 测试10亿个数字的array占用内存空间
         */
        int[] arr = new int[10000];
        for (int i = 0; i < 10000; i++) {
            arr[i] = i;
        }
        Long arrTotalByte = GraphLayout.parseInstance(arr).totalSize();
        System.out.println( arrTotalByte + "Byte" );
        System.out.println(100000 * arrTotalByte / 1024 / 1024 / 1024 + "G");

        System.out.println("----------test DTO-------------");
        List<TestDTO> dtoList = Lists.newArrayList();
        for (int i = 0; i < 1000000; i++) {
            dtoList.add(TestDTO.builder()
                    .mtlyid(1)
                    .predictSettlementMoney(BigDecimal.ZERO)
                    .smgscyid(1)
                    .urid(1)
                    .build()
            );
        }

        Long dtoTotalByte = GraphLayout.parseInstance(dtoList).totalSize();
        System.out.println(1000000 + "DTO大小" + dtoTotalByte + "Byte" );
        System.out.println(1000000 + "DTO大小" + dtoTotalByte / 1024 / 1024 + "M");
//        System.out.println("查看对象内部信息");
//        System.out.println(ClassLayout.parseInstance(dtoList).toPrintable());
//        System.out.println("查看对象外部信息");
//        System.out.println(GraphLayout.parseInstance(dtoList).toPrintable());

        System.out.println("-------------------------------------------");
        /**
         * 测试10亿个字符串的list占用内存空间
         */
        List<String> stringList = Lists.newArrayList();
        for (int i = 0; i < 1000000; i++) {
            stringList.add("私域招商订单透出字段私域招商订单透出字段私域招商订单透出字段私域招商订单透出字段私域招商订单透出字段");
        }

        Long strTotalByte = GraphLayout.parseInstance(stringList).totalSize();
        System.out.println("1000000个字符串占用空间" + strTotalByte + "Byte" );
        System.out.println("1000000个字符串占用空间" + totalByte / 1024 / 1024 + "m" );

        // 测试orderDetail占用空间
//        JolTest jolTest = new JolTest();
//        Long orderDrtailTotalByte = GraphLayout.parseInstance(jolTest.getOrderList(600000)).totalSize();
//        System.out.println("orderDetail list占用空间" + orderDrtailTotalByte + "Byte" );
//        System.out.println("orderDetail list占用空间" + orderDrtailTotalByte / 1024 / 1024 + "m" );

        // 测试orderDetail占用空间
        JolTest jolTest = new JolTest();
//        Long orderDrtailTotalByte = GraphLayout.parseInstance(jolTest.getOpOrderList(600000)).totalSize();
//        System.out.println("OpenmallOrderListChild list占用空间" + orderDrtailTotalByte + "Byte" );
//        System.out.println("OpenmallOrderListChild list占用空间" + orderDrtailTotalByte / 1024 / 1024 + "m" );

        // 测试orderDetail占用空间
        System.out.println("-------------------------------------------");
        List<KpiOrderDto> kpiList = jolTest.getKpiList(1000000);
        Long kpiTotalByte = GraphLayout.parseInstance(kpiList).totalSize();
        System.out.println("kpi list占用空间" + kpiTotalByte + "Byte" );
        System.out.println("kpi list占用空间" + kpiTotalByte / 1024 / 1024 + "m" );

//        System.out.println("查看对象内部信息");
//        System.out.println(ClassLayout.parseInstance(kpiList).toPrintable());
//        System.out.println("查看对象外部信息");
//        System.out.println(GraphLayout.parseInstance(kpiList).toPrintable());
    }

    private List<DwdOrderDetailDi> getOrderList(int size){
        List<DwdOrderDetailDi> orderDetailDiList = Lists.newArrayList();
        for (int i = 0; i < size; i++) {
            DwdOrderDetailDi di = new DwdOrderDetailDi();
            di.setRunNum("111111111111");
            di.setOrderStatus("111111111111");
            di.setRealOrderStatus("111111111111");
            di.setParentRunNum("111111111111");
            di.setMallId("111111111111");
            di.setStoreName("111111111111");
            di.setTotalMoney(0);
            di.setSettlementMoney(0);
            di.setOrderMoney(0);
            di.setDepositMoney(0);
            di.setPredictServeRate(0);
            di.setPredictSettlementMoney(0);
            di.setRealServiceFee(0);
            di.setPublisherCommission(0);
            di.setGroupId("111111111111");
            di.setGroupName("111111111111");
            di.setRealRate(new BigDecimal("0"));
            di.setCommissionRate(new BigDecimal("0"));
            di.setCommission(new BigDecimal("0"));
            di.setServiceRate(new BigDecimal("0"));
            di.setGoodsNum(0);
            di.setPrice(0);
            di.setOrderTime(new Date());
            di.setSettlementTime(new Date());
            di.setCompleteTime(new Date());
            di.setClickTime(new Date());
            di.setIsRiskManagement("111111111111");
            di.setAndtid(0);
            di.setRestPayTime(new Date());
            di.setActiveId("111111111111");
            di.setActiveName("111111111111");
            di.setShortId("111111111111");
            di.setKolNickname("111111111111");
            di.setGoodsName("111111111111");
            di.setGoodsId("111111111111");
            di.setSpuid("111111111111");
            di.setSkuid("111111111111");
            di.setGoodsImage("111111111111");
            di.setStoreId("111111111111");
            di.setOdsOrderId(0);
            di.setPlatformFlag("111111111111");
            di.setAccountType(0);
            di.setSaleafterNum(0);
            di.setRefundNum(0);
            di.setSmgscyid(0);
            di.setSmgscyid2(0);
            di.setStoreSmgscyid(0);
            di.setStoreSmgscyid2(0);
            di.setDimPlatformId(0);
            di.setDimMerchantId(0);
            di.setDimDateId("111111111111");
            di.setDimChannelId(0);
            di.setDimMerchantAdminId(0);
            di.setDimSmzdmCategoryId(0);
            di.setWangwang("111111111111");
            di.setGroupCommission(0);
            di.setPublisherName("111111111111");
            di.setPublisherId("111111111111");
            di.setPlatform("111111111111");
            di.setChannelFlag(0);
            di.setCreateTime(new Date());
            di.setUpdateTime(new Date());
            di.setDeleteTime(new Date());
            di.setError("111111111111");
            di.setIfValid(0);
            di.setDimMerchantUserId(0);
            di.setPayTime(new Date());
            di.setPayTaobaoTime(new Date());
            di.setPayMoney(new BigDecimal("0"));
            di.setPubId("111111111111");
            di.setPubNickName("111111111111");
            di.setTkPaidTime(new Date());
            di.setModifiedTime(new Date());
            di.setSpreadId("111111111111");
            di.setJdId("111111111111");
            di.setOrderStatusNum("111111111111");
            di.setGuaranteePrice(new BigDecimal("0"));
            di.setUnionRole("111111111111");

            orderDetailDiList.add(di);
        }
        return orderDetailDiList;
    }

    private List<OpenmallOrderListChild> getOpOrderList(int size){
        List<OpenmallOrderListChild> orderDetailDiList = Lists.newArrayList();
        for (int i = 0; i < size; i++) {
            OpenmallOrderListChild di = new OpenmallOrderListChild();
            di.setOlorltcdid(0);
            di.setAllianceInfoAuthorAccount("dasdasd");
            di.setAuthorId("dasdasd");
            di.setCode("dasdasd");
            di.setCreateTime(LocalDateTime.now());
            di.setFinalStatus(0);
            di.setProductId("dasdasd");
            di.setProductName("dasdasd");
            di.setTotalAmount(new BigDecimal("0"));

            orderDetailDiList.add(di);
        }
        return orderDetailDiList;
    }

    private List<KpiOrderDto> getKpiList(int size){
        List<KpiOrderDto> kpiOrderDtos = Lists.newArrayList();
        KpiOrderDto kpiOrderDto;


        for (int i = 0; i < size; i++) {
            kpiOrderDto = new KpiOrderDto();
            kpiOrderDto.setUrid(0);
            kpiOrderDto.setPredictSettlementMoney(1000.0);
            kpiOrderDto.setMtlyid(1);
            kpiOrderDto.setSmgscyid(0);
            kpiOrderDto.setPlatformFlag("值得买");

            kpiOrderDtos.add(kpiOrderDto);
        }
        return kpiOrderDtos;
    }
}
