
package com.sxw.learn.DDD.bussiness.lottery.rpc;

/**
 * <b>描述：外部RPC服务：获取城市信息</b> <br/>
 *
 */
public interface LbsService {

    LbsResponse getLbsCityInfo(LbsReq lbsReq);
}