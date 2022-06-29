
package com.sxw.learn.DDD.bussiness.lottery.condition.service;


import com.sxw.learn.DDD.bussiness.lottery.condition.domain.vo.LotteryConditionResult;

/**
 * <b>描述：抽奖条件限制服务</b> <br/>
 *
 */
public interface LotteryConditionService {
    LotteryConditionResult checkLotteryCondition(Integer lotteryId, Long userId);
}