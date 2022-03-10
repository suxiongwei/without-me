package com.sxw.learn.java.jol;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class KpiOrderDto {

//    private Integer urid;
//    private Integer smgscyid;
////    private String orderTime;
//    private LocalDateTime orderTime1;
//    private BigDecimal fee;
//    private BigDecimal gmv;
    private int urid;
    private double predictSettlementMoney;
    private int mtlyid;
    private int smgscyid;
    private String platformFlag;
}
