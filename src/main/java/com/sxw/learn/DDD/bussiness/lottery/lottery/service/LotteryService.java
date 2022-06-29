
package com.sxw.learn.DDD.bussiness.lottery.lottery.service;

import com.sxw.learn.DDD.bussiness.lottery.lottery.domain.valobj.DrawLotteryContext;
import com.sxw.learn.DDD.bussiness.lottery.lottery.domain.valobj.IssueResponse;

/**
 * <b>描述：抽奖领域服务</b> <br/>
 *
 */
public interface LotteryService {
    IssueResponse issueLottery(DrawLotteryContext context);
}