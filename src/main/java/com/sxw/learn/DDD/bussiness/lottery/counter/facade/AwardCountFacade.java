
package com.sxw.learn.DDD.bussiness.lottery.counter.facade;

import java.util.concurrent.atomic.AtomicLong;

import com.sxw.learn.DDD.bussiness.lottery.lottery.domain.valobj.DrawLotteryContext;
import org.springframework.stereotype.Service;

/**
 * <b>描述：计数上下文防腐层</b> <br/>
 *
 */
@Service("awardCountFacade")
public class AwardCountFacade {
    private static final AtomicLong count = new AtomicLong(0);
    public void incrTryCount(DrawLotteryContext context) {
        count.incrementAndGet();
    }
}