package com.sxw.learn.util;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class TktOrderToolmaker implements Serializable {


    /**
     * 自增主键
     */
    private Integer id;

    /**
     * 数据唯一ID
     */
    private Integer _id;

    /**
     * 渠道
     */
    private String qd;

    /**
     * 实付款
     */
    private BigDecimal actualPrice;

    /**
     *     一级类目id
     */
    private Integer cid1;

    /**
     *     二级类目id
     */
    private Integer cid2;

    /**
     *     三级类目id
     */
    private Integer cid3;

    /**
     * 佣金比例
     */
    private BigDecimal commissionRatio;

    /**
     * 订单编号
     */
    private Long orderId;

    /**
     * skuid
     */
    private Long skuId;

    /**
     * 商品名
     */
    private String skuName;

    /**
     * 商品数量
     */
    private Integer skuNum;

    /**
     * 订单类型：渠道/团长
     */
    private Integer orderType;

    /**
     * 订单有效值
     */
    private Integer validCode;

    /**
     * 下单时间
     */
    private LocalDateTime orderTime;

    /**
     * 更新时间
     */
    private String updateTime;

    /**
     * 实际佣金
     */
    private BigDecimal actualFee;

    /**
     * 预估付款
     */
    private BigDecimal estimatePrice;

    /**
     * 预估佣金
     */
    private BigDecimal estimateFee;

    /**
     * 团长rid
     */
    private Integer rid;

    /**
     * 数据创建时间
     */
    private LocalDateTime gmtCreateTime;

    /**
     * 数据更新时间
     */
    private LocalDateTime gmtUpdateTime;
}
