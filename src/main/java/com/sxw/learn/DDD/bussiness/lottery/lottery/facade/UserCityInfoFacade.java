
package com.sxw.learn.DDD.bussiness.lottery.lottery.facade;

import com.sxw.learn.DDD.bussiness.lottery.lottery.domain.entity.MtCity;
import com.sxw.learn.DDD.bussiness.lottery.lottery.domain.valobj.DrawLotteryContext;
import com.sxw.learn.DDD.bussiness.lottery.rpc.LbsReq;
import com.sxw.learn.DDD.bussiness.lottery.rpc.LbsResponse;
import com.sxw.learn.DDD.bussiness.lottery.rpc.LbsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <b>描述：用户城市信息 防腐层</b> <br/>
 * 访问外部信息 增加一层处理
 *
 */
@Component
public class UserCityInfoFacade {
    @Autowired
    private LbsService lbsService;

    public MtCity getMtCityInfo(DrawLotteryContext context) {
        LbsReq lbsReq = new LbsReq();
        lbsReq.setLan(context.getLan());
        lbsReq.setLat(context.getLat());
        LbsResponse lbsResponse = lbsService.getLbsCityInfo(lbsReq);
        return buildMtCityInfo(lbsResponse);
    }

    private MtCity buildMtCityInfo(LbsResponse lbsResponse) {
        // 增加一层处理转换
        return null;
    }
}