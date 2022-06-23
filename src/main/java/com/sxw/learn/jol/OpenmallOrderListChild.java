package com.sxw.learn.jol;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OpenmallOrderListChild implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer olorltcdid;

    /**
     * 商品ID
     */
    private String productId;

    /**
     * 订单实付金额（不包含运费）
     */
    private BigDecimal totalAmount;

    /**
     * 带货达人ID。若为0，则表示达人ID为空
     */
    private String authorId;

    /**
     * 作者账号(抖音/火山作者)
     */
    private String allianceInfoAuthorAccount;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 该子订单购买的商品的编码 code
     */
    private String code;

    /**
     * 子订单状态 1在线支付订单待支付；货到付款订单待确认2备货中（只有此状态下，才可发货）3已发货4已取消：1.用户未支付时取消订单；2.用户超时未支付，系统自动取消订单；3.货到付款订单，用户拒收5已完成：1.在线支付订单，商家发货后，用户收货、拒收或者15天无物流更新；2.货到付款订单，用户确认收货6退货中-用户申请7退货中-商家同意退货8 退货中-客服仲裁9 已关闭-退货失败10 退货中-客服同意11 退货中-用户已填物流12 退货成功-商户同意13 退货中-再次客服仲裁14 退货中-客同意退款15 退货-用户取消16 退款中-用户申请(备货中)否17 退款中-商家同意(备货中)否21 退款成功-订单退款（备货中，用户申请退款，最终退款成功）否22 退款成功-订单退款 (已发货时，用户申请退货，最终退货退款成功)24 退货成功-商户已退款 (特指货到付款订单，已发货时，用户申请退货，最终退货退款成功)否25 退款中-用户取消(备货中)否26 退款中-商家拒绝（备货中）否27 退货中-等待买家处理（已发货，商家拒绝用户退货申请）28 退货失败（已发货，商家拒绝用户退货申请，客服仲裁支持商家）29 退货中-等待买家处理（已发货，用户填写退货物流，商家拒绝）30 退款中-退款申请（已发货，用户申请仅退款）31 退款申请取消（已发货，用户申请仅退款时，取消申请）32 退款中-商家同意（已发货，用户申请仅退款，商家同意申请）33 退款中-商家拒绝（已发货，户申请仅退款，商家拒绝申请）34 退款中-客服仲裁（已发货，用户申请仅退款，商家拒绝申请，买家申请客服仲裁）35 退款中-客服同意（已发货，用户申请仅退款，商家拒绝申请，客服仲裁支持买家）36 退款中-支持商家（已发货，用户申请仅退款，商家拒绝申请，客服仲裁支持商家）37 已关闭-退款失败（已发货，用户申请仅退款时，退款关闭）38 退款成功-售后退款（特指货到付款订单，已发货，用户申请仅退款时，最终退款成功）39 退款成功-订单退款（已发货，用户申请仅退款时，最终退款成功
     */
    private Integer finalStatus;

    /**
     * 订单创建时间
     */
    private LocalDateTime createTime;
}
