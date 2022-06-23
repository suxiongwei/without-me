package com.sxw.learn.jol;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * <p>
 * 订单事实表
 * </p>
 *
 * @author suxiongwei
 * @since 2021-05-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DwdOrderDetailDi implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单id
     * 淘宝：runNum
     *
     */
    private String runNum;

    /**
     * 订单状态
     */
    private String orderStatus;

    /**
     * 订单状态
     */
    private String realOrderStatus;

    /**
     * 父订单号
     */
    private String parentRunNum;

    /**
     * 快手商家ID
     */
    private String mallId;

    /**
     * 店铺名称
     */
    private String storeName;

    /**
     * 付款金额 单位：分
     */
    private Integer totalMoney;

    /**
     * 实际金额 单位：分
     */
    private Integer settlementMoney;

    /**
     * 订单金额 单位：分
     */
    private Integer orderMoney;

    /**
     * 定金金额 单位：分
     */
    private Integer depositMoney;

    /**
     * 预估服务费 单位：分
     */
    private Integer predictServeRate;

    /**
     * 实际服务费 同淘宝订单预估结算服务费 单位：分
     */
    private Integer predictSettlementMoney;

    /**
     * 实际服务费收入 单位：分
     */
    private Integer realServiceFee;

    /**
     * 招商佣金
     */
    private Integer publisherCommission;

    /**
     * 招商duoid
     */
    private String groupId;

    /**
     * 招商团长昵称
     */
    private String groupName;

    /**
     * 实际分成比例
     */
    private BigDecimal realRate;

    /**
     * 佣金比率
     */
    private BigDecimal commissionRate;

    /**
     * 佣金
     */
    private BigDecimal commission;

    /**
     * 服务费率
     */
    private BigDecimal serviceRate;

    /**
     * 商品数量
     */
    private Integer goodsNum;

    /**
     * 商品价格 单位：分
     */
    private Integer price;

    /**
     * 下单时间
     */
    private Date orderTime;

    /**
     * 结算时间
     */
    private Date settlementTime;

    /**
     * 完成时间
     */
    private Date completeTime;

    /**
     * 点击时间
     */
    private Date clickTime;

    /**
     * 是否风控订单
     */
    private String isRiskManagement;

    /**
     * 部门id
     */
    private Integer andtid;

    /**
     * 尾款时间
     */
    private Date restPayTime;

    /**
     * 活动ID
     */
    private String activeId;

    /**
     * 团名称
     */
    private String activeName;

    /**
     * 带货达人抖音&火山号
     */
    private String shortId;

    /**
     * 带货达人昵称
     */
    private String kolNickname;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品ID
     */
    private String goodsId;

    /**
     * 商品spuid
     */
    private String spuid;

    /**
     * 商品skuid
     */
    private String skuid;

    /**
     * 商品图片
     */
    private String goodsImage;

    /**
     * 店铺ID
     */
    private String storeId;

    /**
     * 操作数据-原始数据表主键
     */
    private Integer odsOrderId;

    /**
     * 平台标记  如:值得买
     */
    private String platformFlag;

    /**
     * 账号类型   1-合资账号  2-自营账号
     */
    private Integer accountType;

    /**
     * 售后商品数量
     */
    private Integer saleafterNum;

    /**
     * 退款商品数量
     */
    private Integer refundNum;

    /**
     * SMZDM一级分类ID
     */
    private Integer smgscyid;

    /**
     * SMZDM二级分类ID
     */
    private Integer smgscyid2;

    /**
     * 店铺一级分类ID
     */
    private Integer storeSmgscyid;

    /**
     * 店铺二级分类ID
     */
    private Integer storeSmgscyid2;

    /**
     * 平台维度ID
     */
    private Integer dimPlatformId;

    /**
     * 商家维度ID
     */
    private Integer dimMerchantId;

    /**
     * 时间维度ID
     */
    private String dimDateId;

    /**
     * 渠道维度ID
     */
    private Integer dimChannelId;

    /**
     * 招商负责人维度ID
     */
    private Integer dimMerchantAdminId;

    /**
     * @deprecated 类目维度ID 暂时废弃 因为有多个类目，暂时使用 smgscyid smgscyid2
     */
    @Deprecated
    private Integer dimSmzdmCategoryId;

    /**
     * 掌柜旺旺
     */
    private String wangwang;

    /**
     * 推手佣金
     */
    private Integer groupCommission;

    /**
     * 推手昵称
     */
    private String publisherName;

    /**
     * 推手ID
     */
    private String publisherId;

    /**
     * 平台
     */
    private String platform;

    /**
     * 渠道任务标识 0:否 1:是
     */
    private Integer channelFlag;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 删除时间
     */
    private Date deleteTime;

    /**
     * 错误信息
     */
    private String error;

    /**
     * 是否为有效订单，1为是，0为否
     */
    private Integer ifValid;

    /**
     * 人员ID，对应urid
     */
    private Integer dimMerchantUserId;

    /**
     * 定金付款时间
     */
    private Date payTime;

    /**
     * 定金淘宝付款时间
     */
    private Date payTaobaoTime;

    /**
     * 定金付款金额
     */
    private BigDecimal payMoney;

    /**
     * 推广者ID 私域招商订单透出字段
     */
    private String pubId;

    /**
     * 推广者昵称 私域招商订单透出字段
     */
    private String pubNickName;

    /**
     * 付款时间
     */
    private Date tkPaidTime;

    /**
     * 订单更新时间
     */
    private Date modifiedTime;

    /**
     * 推广位ID
     */
    private String spreadId;

    /**
     * 京东返回的ID(订单的唯一标示),对应京东的ID
     */
    private String jdId;

    /**
     * 京东返回的订单状态ID
     */
    private String orderStatusNum;

    /**
     * 价保金额
     */
    private BigDecimal guaranteePrice;

    /**
     * 站长角色：1 推客 2 团长 3内容服务商
     */
    private String unionRole;

    public void setRunNum(String runNum) {
        this.runNum = Objects.isNull(runNum) ? StringUtils.EMPTY : runNum;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = Objects.isNull(orderStatus) ? StringUtils.EMPTY : orderStatus;
    }

    public void setRealOrderStatus(String realOrderStatus) {
        this.realOrderStatus = Objects.isNull(realOrderStatus) ? StringUtils.EMPTY : realOrderStatus;
    }

    public void setParentRunNum(String parentRunNum) {
        this.parentRunNum = Objects.isNull(parentRunNum) ? StringUtils.EMPTY : parentRunNum;
    }

    public void setMallId(String mallId) {
        this.mallId = Objects.isNull(mallId) ? StringUtils.EMPTY : mallId;
    }

    public void setStoreName(String storeName) {
        this.storeName = Objects.isNull(storeName) ? StringUtils.EMPTY : storeName;
    }

    public void setTotalMoney(Integer totalMoney) {
        this.totalMoney = Objects.isNull(totalMoney) ? 0 : totalMoney;
    }

    public void setSettlementMoney(Integer settlementMoney) {
        this.settlementMoney = Objects.isNull(settlementMoney) ? 0 : settlementMoney;
    }

    public void setOrderMoney(Integer orderMoney) {
        this.orderMoney = Objects.isNull(orderMoney) ? 0 : orderMoney;
    }

    public void setDepositMoney(Integer depositMoney) {
        this.depositMoney = Objects.isNull(depositMoney) ? 0 : depositMoney;
    }

    public void setPredictServeRate(Integer predictServeRate) {
        this.predictServeRate = Objects.isNull(predictServeRate) ? 0 : predictServeRate;
    }

    public void setPredictSettlementMoney(Integer predictSettlementMoney) {
        this.predictSettlementMoney = Objects.isNull(predictSettlementMoney) ? 0 : predictSettlementMoney;
    }

    public void setRealServiceFee(Integer realServiceFee) {
        this.realServiceFee = Objects.isNull(realServiceFee) ? 0 : realServiceFee;
    }

    public void setPublisherCommission(Integer publisherCommission) {
        this.publisherCommission = Objects.isNull(publisherCommission) ? 0 : publisherCommission;
    }

    public void setGroupId(String groupId) {
        this.groupId = Objects.isNull(groupId) ? StringUtils.EMPTY : groupId;
    }

    public void setGroupName(String groupName) {
        this.groupName = Objects.isNull(groupName) ? StringUtils.EMPTY : groupName;
    }

    public void setRealRate(BigDecimal realRate) {
        this.realRate = Objects.isNull(realRate) ? BigDecimal.ZERO : realRate;
    }

    public void setCommissionRate(BigDecimal commissionRate) {
        this.commissionRate = Objects.isNull(commissionRate) ? BigDecimal.ZERO : commissionRate;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = Objects.isNull(commission) ? BigDecimal.ZERO : commission;
    }

    public void setServiceRate(BigDecimal serviceRate) {
        this.serviceRate = Objects.isNull(serviceRate) ? BigDecimal.ZERO : serviceRate;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = Objects.isNull(goodsNum) ? 0 : goodsNum;
    }

    public void setPrice(Integer price) {
        this.price = Objects.isNull(price) ? 0 : price;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public void setSettlementTime(Date settlementTime) {
        this.settlementTime = settlementTime;
    }

    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }

    public void setClickTime(Date clickTime) {
        this.clickTime = clickTime;
    }

    public void setIsRiskManagement(String isRiskManagement) {
        this.isRiskManagement = Objects.isNull(isRiskManagement) ? StringUtils.EMPTY : isRiskManagement;
    }

    public void setAndtid(Integer andtid) {
        this.andtid = Objects.isNull(andtid) ? 0 : andtid;
    }

    public void setRestPayTime(Date restPayTime) {
        this.restPayTime = restPayTime;
    }

    public void setActiveId(String activeId) {
        this.activeId = Objects.isNull(activeId) ? StringUtils.EMPTY : activeId;
    }

    public void setActiveName(String activeName) {
        this.activeName = Objects.isNull(activeName) ? StringUtils.EMPTY : activeName;
    }

    public void setShortId(String shortId) {
        this.shortId = Objects.isNull(shortId) ? StringUtils.EMPTY : shortId;
    }

    public void setKolNickname(String kolNickname) {
        this.kolNickname = Objects.isNull(kolNickname) ? StringUtils.EMPTY : kolNickname;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = Objects.isNull(goodsName) ? StringUtils.EMPTY : goodsName;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = Objects.isNull(goodsId) ? StringUtils.EMPTY : goodsId;
    }

    public void setSpuid(String spuid) {
        this.spuid = Objects.isNull(spuid) ? StringUtils.EMPTY : spuid;
    }

    public void setSkuid(String skuid) {
        this.skuid = Objects.isNull(skuid) ? StringUtils.EMPTY : skuid;
    }

    public void setGoodsImage(String goodsImage) {
        this.goodsImage = Objects.isNull(goodsImage) ? StringUtils.EMPTY : goodsImage;
    }

    public void setStoreId(String storeId) {
        this.storeId = Objects.isNull(storeId) ? StringUtils.EMPTY : storeId;
    }

    public void setOdsOrderId(Integer odsOrderId) {
        this.odsOrderId = Objects.isNull(odsOrderId) ? 0 : odsOrderId;
    }

    public void setPlatformFlag(String platformFlag) {
        this.platformFlag = Objects.isNull(platformFlag) ? StringUtils.EMPTY : platformFlag;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = Objects.isNull(accountType) ? 0 : accountType;
    }

    public void setSaleafterNum(Integer saleafterNum) {
        this.saleafterNum = Objects.isNull(saleafterNum) ? 0 : saleafterNum;
    }

    public void setRefundNum(Integer refundNum) {
        this.refundNum = Objects.isNull(refundNum) ? 0 : refundNum;
    }

    public void setSmgscyid(Integer smgscyid) {
        this.smgscyid = Objects.isNull(smgscyid) ? 0 : smgscyid;
    }

    public void setSmgscyid2(Integer smgscyid2) {
        this.smgscyid2 = Objects.isNull(smgscyid2) ? 0 : smgscyid2;
    }

    public void setStoreSmgscyid(Integer storeSmgscyid) {
        this.storeSmgscyid = Objects.isNull(storeSmgscyid) ? 0 : storeSmgscyid;
    }

    public void setStoreSmgscyid2(Integer storeSmgscyid2) {
        this.storeSmgscyid2 = Objects.isNull(storeSmgscyid2) ? 0 : storeSmgscyid2;
    }

    public void setDimPlatformId(Integer dimPlatformId) {
        this.dimPlatformId = Objects.isNull(dimPlatformId) ? 0 : dimPlatformId;
    }

    public void setDimMerchantId(Integer dimMerchantId) {
        this.dimMerchantId = Objects.isNull(dimMerchantId) ? 0 : dimMerchantId;
    }

    public void setDimDateId(String dimDateId) {
        this.dimDateId = Objects.isNull(dimDateId) ? StringUtils.EMPTY : dimDateId;
    }

    public void setDimChannelId(Integer dimChannelId) {
        this.dimChannelId = Objects.isNull(dimChannelId) ? 0 : dimChannelId;
    }

    public void setDimMerchantAdminId(Integer dimMerchantAdminId) {
        this.dimMerchantAdminId = Objects.isNull(dimMerchantAdminId) ? 0 : dimMerchantAdminId;
    }

    public void setDimSmzdmCategoryId(Integer dimSmzdmCategoryId) {
        this.dimSmzdmCategoryId = Objects.isNull(dimSmzdmCategoryId) ? 0 : dimSmzdmCategoryId;
    }

    public void setWangwang(String wangwang) {
        this.wangwang = Objects.isNull(wangwang) ? StringUtils.EMPTY : wangwang;
    }

    public void setGroupCommission(Integer groupCommission) {
        this.groupCommission = Objects.isNull(groupCommission) ? 0 : groupCommission;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = Objects.isNull(publisherName) ? StringUtils.EMPTY : publisherName;
    }

    public void setPublisherId(String publisherId) {
        this.publisherId = Objects.isNull(publisherId) ? StringUtils.EMPTY : publisherId;
    }

    public void setPlatform(String platform) {
        this.platform = Objects.isNull(platform) ? StringUtils.EMPTY : platform;
    }

    public void setChannelFlag(Integer channelFlag) {
        this.channelFlag = Objects.isNull(channelFlag) ? 0 : channelFlag;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    public void setError(String error) {
        this.error = Objects.isNull(error) ? StringUtils.EMPTY : error;
    }

    public void setIfValid(Integer ifValid) {
        this.ifValid = Objects.isNull(ifValid) ? 0 : ifValid;
    }

    public void setDimMerchantUserId(Integer dimMerchantUserId) {
        this.dimMerchantUserId = Objects.isNull(dimMerchantUserId) ? 0 : dimMerchantUserId;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public void setPayTaobaoTime(Date payTaobaoTime) {
        this.payTaobaoTime = payTaobaoTime;
    }

    public void setPayMoney(BigDecimal payMoney) {
        this.payMoney = Objects.isNull(payMoney) ? BigDecimal.ZERO : payMoney;
    }

    public void setPubId(String pubId) {
        this.pubId = Objects.isNull(pubId) ? StringUtils.EMPTY : pubId;
    }

    public void setPubNickName(String pubNickName) {
        this.pubNickName = Objects.isNull(pubNickName) ? StringUtils.EMPTY : pubNickName;
    }

    public void setTkPaidTime(Date tkPaidTime) {
        this.tkPaidTime = tkPaidTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public void setSpreadId(String spreadId) {
        this.spreadId = Objects.isNull(spreadId) ? StringUtils.EMPTY : spreadId;
    }

    public void setJdId(String jdId) {
        this.jdId = Objects.isNull(jdId) ? StringUtils.EMPTY : jdId;
    }

    public void setOrderStatusNum(String orderStatusNum) {
        this.orderStatusNum = Objects.isNull(orderStatusNum) ? StringUtils.EMPTY : orderStatusNum;
    }

    public void setGuaranteePrice(BigDecimal guaranteePrice) {
        this.guaranteePrice = Objects.isNull(guaranteePrice) ? BigDecimal.ZERO : guaranteePrice;
    }

    public void setUnionRole(String unionRole) {
        this.unionRole = Objects.isNull(unionRole) ? StringUtils.EMPTY : unionRole;
    }
}
