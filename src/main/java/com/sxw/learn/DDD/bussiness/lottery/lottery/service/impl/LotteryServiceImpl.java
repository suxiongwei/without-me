
package com.sxw.learn.DDD.bussiness.lottery.lottery.service.impl;


import com.sxw.learn.DDD.bussiness.lottery.counter.facade.AwardCountFacade;
import com.sxw.learn.DDD.bussiness.lottery.lottery.domain.aggregate.DrawLottery;
import com.sxw.learn.DDD.bussiness.lottery.lottery.domain.entity.MtCity;
import com.sxw.learn.DDD.bussiness.lottery.lottery.domain.valobj.Award;
import com.sxw.learn.DDD.bussiness.lottery.lottery.domain.valobj.AwardPool;
import com.sxw.learn.DDD.bussiness.lottery.lottery.domain.valobj.DrawLotteryContext;
import com.sxw.learn.DDD.bussiness.lottery.lottery.domain.valobj.IssueResponse;
import com.sxw.learn.DDD.bussiness.lottery.lottery.facade.UserCityInfoFacade;
import com.sxw.learn.DDD.bussiness.lottery.lottery.repo.repository.DrawLotteryRepository;
import com.sxw.learn.DDD.bussiness.lottery.lottery.service.AwardSendResponse;
import com.sxw.learn.DDD.bussiness.lottery.lottery.service.AwardSendService;
import com.sxw.learn.DDD.bussiness.lottery.lottery.service.LotteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <b>描述：抽奖领域服务实现</b> <br/>
 *
 */
@Service("lotteryService")
public class LotteryServiceImpl implements LotteryService {

    @Autowired
    private DrawLotteryRepository repository;
    @Autowired
    private UserCityInfoFacade userCityInfoFacade;
    @Autowired
    private AwardSendService awardSendService;
    @Autowired
    private AwardCountFacade awardCountFacade;

    @Override
    public IssueResponse issueLottery(DrawLotteryContext context) {
        DrawLottery lottery = repository.getDrawLotteryById(context.getLotteryId());
        awardCountFacade.incrTryCount(context);
        MtCity mtCityInfo = userCityInfoFacade.getMtCityInfo(context);
        context.setMtCityInfo(mtCityInfo);
        AwardPool awardPool = lottery.chooseAwardPool(context);
        Award award = awardPool.randomGetAward();
        return buildIssueResponse(awardSendService.sendAward(award, context));
    }

    private IssueResponse buildIssueResponse(AwardSendResponse awardSendResponse) {
        IssueResponse issueResponse = new IssueResponse();
        return null;
    }
}