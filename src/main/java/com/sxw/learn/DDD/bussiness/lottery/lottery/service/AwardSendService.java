
package com.sxw.learn.DDD.bussiness.lottery.lottery.service;


import com.sxw.learn.DDD.bussiness.lottery.lottery.domain.valobj.Award;
import com.sxw.learn.DDD.bussiness.lottery.lottery.domain.valobj.DrawLotteryContext;

/**
 * <b>描述：发奖服务</b> <br/>
 *
 */
public interface AwardSendService {

    AwardSendResponse sendAward(Award award, DrawLotteryContext context);
}