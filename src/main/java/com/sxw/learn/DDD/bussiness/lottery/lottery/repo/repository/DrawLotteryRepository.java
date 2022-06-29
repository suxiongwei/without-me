
package com.sxw.learn.DDD.bussiness.lottery.lottery.repo.repository;

import com.sxw.learn.DDD.bussiness.lottery.lottery.domain.aggregate.DrawLottery;
import com.sxw.learn.DDD.bussiness.lottery.lottery.repo.cache.DrawLotteryCacheAccessObj;
import com.sxw.learn.DDD.bussiness.lottery.lottery.repo.dao.AwardDao;
import com.sxw.learn.DDD.bussiness.lottery.lottery.repo.dao.AwardPoolDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * <b>描述：抽奖资源库</b> <br/>
 * 对外提供统一的资源方案，聚合资源库信息 承担存储逻辑
 *
 */
@Repository
public class DrawLotteryRepository {

    @Autowired
    private AwardDao awardDao;
    @Autowired
    private AwardPoolDao awardPoolDao;
    @Autowired
    private DrawLotteryCacheAccessObj drawLotteryCacheAccessObj;

    public DrawLottery getDrawLotteryById(Integer lotteryId) {
        DrawLottery drawLottery = drawLotteryCacheAccessObj.get(lotteryId);
        if (drawLottery != null) {
            return drawLottery;
        }
        drawLottery = getDrawLotteryFromDB(lotteryId);
        drawLotteryCacheAccessObj.add(lotteryId, drawLottery);
        return drawLottery;
    }

    private DrawLottery getDrawLotteryFromDB(Integer lotteryId) {
        return null;
    }

}