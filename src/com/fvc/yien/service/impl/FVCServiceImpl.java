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
    /**总拆分上限.*/
    private static final int SPLIT_NUM = 7;
    /**累计兑换的fvc最大值.*/
    private static final double MAX_TOTAL_FVC = 25000;

    @Override
    public FVCAccount split(FVCAccount fvcAccount) {
        fvcAccount.setFvc(fvcAccount.getFvc() * 2);
        fvcAccount.setCurrent_split_num(fvcAccount.getCurrent_split_num() + 1);
        return fvcAccount;
    }

    @Override
    public FVCAccount profile(FVCAccount fvcAccount, double profile_fvc) {
        fvcAccount.setReturnTotalFVC(fvcAccount.getReturnTotalFVC() + profile_fvc);
        fvcAccount.setProfile(fvcAccount.getProfile() + profile_fvc * (1 - CHARGE_RATE) * (1 - RETURN_RATE));
        fvcAccount.setFvc(fvcAccount.getFvc() - profile_fvc + profile_fvc * (1 - CHARGE_RATE ) * RETURN_RATE);
        System.out.println("第"+fvcAccount.getCurrent_split_num()+"拆账户："+fvcAccount);
        return fvcAccount;
    }

//    第3拆账户：FVCAccount{current_split_num=3, fvc=4350.0, profile=3150.0, returnTotalFVC=5000.0}
//    第4拆账户：FVCAccount{current_split_num=4, fvc=4539.0, profile=6741.0, returnTotalFVC=10700.0}
//    第5拆账户：FVCAccount{current_split_num=5, fvc=4641.0599999999995, profile=10570.14, returnTotalFVC=16778.0}
//    第6拆账户：FVCAccount{current_split_num=6, fvc=3280.059999999999, profile=15750.0, returnTotalFVC=25000.0}
//    在第6拆时完成出局！
//    FVCAccount{current_split_num=6, fvc=3280.059999999999, profile=15750.0, returnTotalFVC=25000.0}
    @Override
    public FVCAccount dynamicSplitType1(FVCAccount fvcAccount) {
        if(fvcAccount.getFvc() + fvcAccount.getReturnTotalFVC() >= MAX_TOTAL_FVC) {
            fvcAccount = profile(fvcAccount , MAX_TOTAL_FVC - fvcAccount.getReturnTotalFVC());
            System.out.println("在第"+fvcAccount.getCurrent_split_num()+"拆时完成出局！");
            return fvcAccount;
        }
        //1.判断账户fvc是否超过5000
        if(fvcAccount.getFvc() > 5000) {
            //2.如果是保留账户余额3000，其余的进行收益cc
            fvcAccount = profile(fvcAccount , fvcAccount.getFvc() - 3000);
        }
        //3.如果没有超过5000则，继续拆分
        //4.如果总收益没有达到25000，则继续迭代
        return dynamicSplitType1(split(fvcAccount));
    }

//    第3拆账户：FVCAccount{current_split_num=3, fvc=4350.0, profile=3150.0, returnTotalFVC=5000.0}
//    第4拆账户：FVCAccount{current_split_num=4, fvc=5050.0, profile=6300.0, returnTotalFVC=10000.0}
//    第5拆账户：FVCAccount{current_split_num=5, fvc=6450.0, profile=9450.0, returnTotalFVC=15000.0}
//    第6拆账户：FVCAccount{current_split_num=6, fvc=5600.0, profile=15750.0, returnTotalFVC=25000.0}
//    在第6拆时完成出局！
//    FVCAccount{current_split_num=6, fvc=5600.0, profile=15750.0, returnTotalFVC=25000.0}
    @Override
    public FVCAccount dynamicSplitType2(FVCAccount fvcAccount) {
        //1.如果账户fvc+已收益的fvc >= 25000，则全部提现就行出局
        if(fvcAccount.getFvc() + fvcAccount.getReturnTotalFVC() >= MAX_TOTAL_FVC) {
            fvcAccount = profile(fvcAccount , MAX_TOTAL_FVC - fvcAccount.getReturnTotalFVC());
            System.out.println("在第"+fvcAccount.getCurrent_split_num()+"拆时完成出局！");
            return fvcAccount;
        }
        //2.如果账户fvc超过5000则，提现5000
        if(fvcAccount.getFvc() > 5000) {
            fvcAccount = profile(fvcAccount , 5000);
        }
        //3.继续拆分
        return dynamicSplitType2(split(fvcAccount));
    }
}
