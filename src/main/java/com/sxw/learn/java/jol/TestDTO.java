package com.sxw.learn.java.jol;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class TestDTO {
    private Integer urid;
    private BigDecimal predictSettlementMoney;
    private Integer mtlyid;
    private Integer smgscyid;
}
