
package com.sxw.learn.DDD.bussiness.lottery.riskcontrol.service.impl;

import com.sxw.learn.DDD.bussiness.lottery.riskcontrol.domain.vo.RiskAccessToken;
import com.sxw.learn.DDD.bussiness.lottery.riskcontrol.domain.vo.RiskRequest;
import com.sxw.learn.DDD.bussiness.lottery.riskcontrol.service.LotteryRiskService;
import org.springframework.stereotype.Service;

/**
 * <b>描述：风险控制服务实现</b> <br/>
 *
 */
@Service("lotteryRiskService")
public class LotteryRiskServiceImpl implements LotteryRiskService {
    @Override
    public RiskAccessToken accquire(RiskRequest req) {
        return null;
    }
}