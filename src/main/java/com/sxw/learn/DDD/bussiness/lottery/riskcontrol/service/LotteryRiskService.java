
package com.sxw.learn.DDD.bussiness.lottery.riskcontrol.service;


import com.sxw.learn.DDD.bussiness.lottery.riskcontrol.domain.vo.RiskAccessToken;
import com.sxw.learn.DDD.bussiness.lottery.riskcontrol.domain.vo.RiskRequest;

/**
 * <b>描述：风险控制领域服务</b> <br/>
 *
 */
public interface LotteryRiskService {
    RiskAccessToken accquire(RiskRequest req);
}