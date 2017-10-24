package com.fvc.yien.service.impl;

import com.fvc.yien.dataobject.FVCAccount;
import com.fvc.yien.service.FVCService;

/**
 * Created by Administrator on 2017/10/24 0024.
 */
public class FVCServiceImpl implements FVCService {
    /**手续费率.*/
    private static final double CHARGE_RATE = 0.1;
    /**回购比例.*/
    private static final double RETURN_RATE = 0.3;
    /**美元对人民币汇率.*/
    private static final double DOLLARS_EXCHANGE_RMB_RATE = 6.5;

    @Override
    public FVCAccount split(FVCAccount fvcAccount) {
        fvcAccount.setFvc(fvcAccount.getFvc() * 2);
        fvcAccount.setCurrent_split_num(fvcAccount.getCurrent_split_num() + 1);
        return fvcAccount;
    }

    @Override
    public FVCAccount profile(FVCAccount fvcAccount, double profile_fvc) {
        fvcAccount.setProfile(fvcAccount.getProfile() + profile_fvc * (1 - CHARGE_RATE) * (1 - RETURN_RATE));
        fvcAccount.setFvc(fvcAccount.getFvc() - profile_fvc + profile_fvc * (1 - CHARGE_RATE ) * RETURN_RATE);
        return fvcAccount;
    }
}
