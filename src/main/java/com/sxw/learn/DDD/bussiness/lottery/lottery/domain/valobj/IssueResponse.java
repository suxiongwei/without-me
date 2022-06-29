
package com.sxw.learn.DDD.bussiness.lottery.lottery.domain.valobj;

import com.sxw.learn.DDD.bussiness.lottery.domain.PrizeInfo;

/**
 * <b>描述：</b> <br/>
 *
 */
public class IssueResponse {
    public static final int OK = 200;
    private int code;
    private PrizeInfo pirzeInfo;

    public int getCode() {
        return code;
    }

    public PrizeInfo getPirzeInfo() {
        return pirzeInfo;
    }
}