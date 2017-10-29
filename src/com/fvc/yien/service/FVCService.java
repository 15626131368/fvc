package com.fvc.yien.service;

import com.fvc.yien.dataobject.FVCAccount;

/**
 * Created by Administrator on 2017/10/24 0024.
 */
public interface FVCService {
    /**拆分.*/
    FVCAccount split(FVCAccount fvcAccount);
    /**收益.*/
    FVCAccount profile(FVCAccount fvcAccount , double profile_fvc);

    /**收益.
     * 1.动态计算收益的金额，如果fvc币值超过5000则剩下3000其余部分全部提现
     * 2.计算何时可出局
     */
    FVCAccount dynamicSplitType1(FVCAccount fvcAccount);

    /**
     * 收益
     * 1.如果账户fvc币值超过5000，收益5000
     * 2.如果账户fvc币+已收益fvc币达到25000则全部提现，并出局
     * @param fvcAccount
     * @return
     */
    FVCAccount dynamicSplitType2(FVCAccount fvcAccount);
}
