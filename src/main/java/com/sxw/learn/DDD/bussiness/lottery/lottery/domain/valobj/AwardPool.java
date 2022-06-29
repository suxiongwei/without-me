
package com.sxw.learn.DDD.bussiness.lottery.lottery.domain.valobj;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * <b>描述：奖池 value object</b> <br/>
 *
 */
public class AwardPool {

    private String cityIds;
    private String scores;
    private int userGroupType;
    private List<Award> awards;

    public boolean matchedCity(String cityId) {
        return true;
    }

    public boolean matchedScore(String gameScore) {
        return false;
    }

    /**
     * 根据随机值选择奖项
     * @return
     */
    public Award randomGetAward() {
        int sumOfProbablity = 0;
        for (Award award : awards) {
            sumOfProbablity += award.getAwardProbablity();
        }

        int randomNumber = ThreadLocalRandom.current().nextInt(sumOfProbablity);
        int range = 0;
        for (Award award : awards) {
            range += award.getAwardProbablity();
            if (randomNumber<range) {
                return award;
            }
        }
        return null;
    }


}