package com.sxw.learn.util;
import java.io.File;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import lombok.SneakyThrows;

public class Test {
    @SneakyThrows
    public static void main(String[] args) {
        List<TktOrderToolmaker> toolmakerList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            TktOrderToolmaker dto = new TktOrderToolmaker();
            dto.set_id(i + 1);
            dto.setQd("16");
            dto.setActualPrice(new BigDecimal("206.47"));
            dto.setCid1(1316);
            dto.setCid2(1381);
            dto.setCid3(1389);
            dto.setCommissionRatio(new BigDecimal("2.00"));
            dto.setOrderId(25674909416781L + i);
            dto.setSkuId(3087293L + i % 100);
            dto.setSkuName("芙丽芳丝(freeplus)洗面奶 氨基酸洁面乳100g深层清洁 温和不紧绷 敏感肌 男女适用 日本..." + i);
            dto.setSkuNum(3);
            dto.setOrderType(1);
            dto.setValidCode(17);
            LocalDateTime localDateTime = LocalDateTime.parse("2022-11-11 14:05:11", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            dto.setOrderTime(localDateTime);
            dto.setUpdateTime("2022-11-15 15:59:58");
            dto.setActualFee(new BigDecimal("4.13"));
            dto.setEstimatePrice(new BigDecimal("230.00"));
            dto.setEstimateFee(new BigDecimal("4.60"));
            dto.setRid(0);
            dto.setGmtCreateTime(LocalDateTime.now());
            dto.setGmtUpdateTime(LocalDateTime.now());

            toolmakerList.add(dto);
        }

        String fileName = "/Users/smzdm/Desktop/newFile.txt";

        File file = new File(fileName);

        String json = JSON.toJSON(toolmakerList).toString();
        // 返回true表示文件成功
        // false 表示文件已经存在
        if (file.createNewFile()) {
            System.out.println("创建文件成功！");
        } else {
            System.out.println("文件已经存在不需要重复创建");
        }
        // 使用FileWriter写文件
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(json);
        }
    }
}
