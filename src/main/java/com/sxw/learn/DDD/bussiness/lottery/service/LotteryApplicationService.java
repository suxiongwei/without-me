
package com.sxw.learn.DDD.bussiness.lottery.service;


import com.sxw.learn.DDD.bussiness.lottery.condition.domain.vo.LotteryConditionResult;
import com.sxw.learn.DDD.bussiness.lottery.condition.service.LotteryConditionService;
import com.sxw.learn.DDD.bussiness.lottery.domain.*;
import com.sxw.learn.DDD.bussiness.lottery.lottery.domain.valobj.DrawLotteryContext;
import com.sxw.learn.DDD.bussiness.lottery.lottery.domain.valobj.IssueResponse;
import com.sxw.learn.DDD.bussiness.lottery.lottery.service.LotteryService;
import com.sxw.learn.DDD.bussiness.lottery.riskcontrol.domain.vo.RiskAccessToken;
import com.sxw.learn.DDD.bussiness.lottery.riskcontrol.domain.vo.RiskRequest;
import com.sxw.learn.DDD.bussiness.lottery.riskcontrol.service.LotteryRiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <b>描述：抽奖应用服务</b> <br/>
 *
 */
@Service("lotteryApplicationService")
public class LotteryApplicationService {

    @Autowired
    private LotteryService lotteryService;
    @Autowired
    private LotteryConditionService conditionService;
    @Autowired
    private LotteryRiskService riskService;

    public Response<PrizeInfo, ErrorData> participateLottery(DrawLotteryContext lotteryContext) {
        //登录验证
        validLoginInfo(lotteryContext);
        //风险控制验证
        RiskAccessToken riskAccessToken = riskService.accquire(buildRiskReq(lotteryContext));
        //抽奖条件检查
        LotteryConditionResult lotteryConditionResult = conditionService
                .checkLotteryCondition(lotteryContext.getLotteryId(), lotteryContext.getUserId());
        //抽奖
        IssueResponse issueResponse = lotteryService.issueLottery(lotteryContext);
        if (issueResponse != null && issueResponse.getCode() == IssueResponse.OK) {
            return buildSuccessResponse(issueResponse.getPirzeInfo());
        } else {
            return buildErrorResponse(ResponseCode.ISSUE_LOTTERY_FAIL, ResponseMsg.ISSUE_LOTTERY_FAIL);
        }
    }

    private Response<PrizeInfo, ErrorData> buildErrorResponse(int issueLotteryFail, String issueLotteryFail1) {
        return null;
    }

    private Response<PrizeInfo, ErrorData> buildSuccessResponse(PrizeInfo pirzeInfo) {
        return null;
    }

    private RiskRequest buildRiskReq(DrawLotteryContext lotteryContext) {
        return null;
    }

    private void validLoginInfo(DrawLotteryContext lotteryContext) {

    }

}