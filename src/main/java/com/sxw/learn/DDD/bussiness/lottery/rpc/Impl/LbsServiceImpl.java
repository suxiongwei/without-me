
package com.sxw.learn.DDD.bussiness.lottery.rpc.Impl;

import com.sxw.learn.DDD.bussiness.lottery.rpc.LbsReq;
import com.sxw.learn.DDD.bussiness.lottery.rpc.LbsResponse;
import com.sxw.learn.DDD.bussiness.lottery.rpc.LbsService;
import org.springframework.stereotype.Service;

/**
 * <b>描述：RPC服务实现 获取城市信息</b> <br/>
 *
 */
@Service("lbsService")
public class LbsServiceImpl implements LbsService {
    @Override
    public LbsResponse getLbsCityInfo(LbsReq lbsReq) {
        return null;
    }
}