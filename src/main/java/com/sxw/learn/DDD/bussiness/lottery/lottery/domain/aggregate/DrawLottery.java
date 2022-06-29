
package com.sxw.learn.DDD.bussiness.lottery.lottery.domain.aggregate;

import com.sxw.learn.DDD.bussiness.lottery.lottery.domain.entity.MtCity;
import com.sxw.learn.DDD.bussiness.lottery.lottery.domain.valobj.AwardPool;
import com.sxw.learn.DDD.bussiness.lottery.lottery.domain.valobj.DrawLotteryContext;

import java.util.List;

/**
 * <b>描述：抽奖聚合根</b> <br/>
 *
 */
public class DrawLottery {
    /**
     *  抽奖ID
     */
    private Integer lotteryId;
    /**
     * 奖池列表
     */
    private List<AwardPool> awardPoolList;

    /**
     * setter
     * @param lotteryId
     */
    public void setLotteryId(Integer lotteryId) {
        if (lotteryId == null || lotteryId <= 0) {
            throw new IllegalArgumentException("非法的抽奖ID");
        }
        this.lotteryId = lotteryId;
    }

    /**
     * 选择奖项池
     * @param drawLotteryContext
     * @return
     */
   public AwardPool chooseAwardPool(DrawLotteryContext drawLotteryContext) {
        if (drawLotteryContext.getMtCityInfo() != null) {
            return chooseAwardPoolByCityInfo(awardPoolList, drawLotteryContext.getMtCityInfo());
        } else {
            return chooseAwardPoolByScore(awardPoolList, drawLotteryContext.getGameScore());
        }
   }

    private AwardPool chooseAwardPoolByScore(List<AwardPool> awardPoolList, String gameScore) {
        for (AwardPool awardPool : awardPoolList) {
            if (awardPool.matchedScore(gameScore)) {
                return awardPool;
            }
        }
        return null;
    }

    private AwardPool chooseAwardPoolByCityInfo(List<AwardPool> awardPoolList, MtCity mtCityInfo) {
        for (AwardPool awardPool : awardPoolList) {
            if (awardPool.matchedCity(mtCityInfo.getCityId())) {
                return awardPool;
            }
        }
        return null;
    }

}