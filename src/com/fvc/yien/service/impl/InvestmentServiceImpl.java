package com.fvc.yien.service.impl;

import com.fvc.yien.dataobject.FVCAccount;
import com.fvc.yien.service.InvestmentService;
import com.fvc.yien.utils.FVCUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/29 0029.
 */
public class InvestmentServiceImpl implements InvestmentService {

    /**fvc账户集.*/
    private List<FVCAccount>  fvcAccounts = new ArrayList<>();
    /**投资总天数.*/
    private Integer investmentTotalDays = 0;
    /**手续费率.*/
    private static final double CHARGE_RATE = 0.1;
    /**回购比例.*/
    private static final double RETURN_RATE = 0.3;
    /**美元对人民币汇率.*/
    private static final double DOLLARS_EXCHANGE_RMB_RATE = 6.5;
    /**累计兑换的fvc最大值.*/
    private static final double MAX_TOTAL_FVC = 25000;
    /**总共的鸡蛋数量.*/
    private static final Integer TOTAL_EGGS = 8;
    /**每次收益的fvc币.*/
    private static final double RETURN_FVC = 5000;
    /**账户初始投资fvc.*/
    private static final double ACCOUNT_INIT_FVC = 1000;
    /**投资方案总收益RMB.*/
    private static final double investment_total_profile_rmb = 0.0;
    /**投资方案总收益$.*/
    private static final double investment_total_profile_dollar = 0.0;

    public static double getInvestment_total_profile_rmb() {
        return investment_total_profile_rmb;
    }

    public static double getInvestment_total_profile_dollar() {
        return investment_total_profile_dollar;
    }

    public List<FVCAccount> getFvcAccounts() {
        return fvcAccounts;
    }

    public void setFvcAccounts(List<FVCAccount> fvcAccounts) {
        this.fvcAccounts = fvcAccounts;
    }

    public Integer getInvestmentTotalDays() {
        return investmentTotalDays;
    }

    public void setInvestmentTotalDays(Integer investmentTotalDays) {
        this.investmentTotalDays = investmentTotalDays;
    }


    @Override
    public List<FVCAccount> investmentType1(List<FVCAccount> fvcAccounts) throws CloneNotSupportedException {
        //1.克隆
       List<FVCAccount> eggs = clone(fvcAccounts);
       boolean isExit = true;

       for(FVCAccount egg : eggs) {
           //2.判断是否出局
           if(!egg.getOut()) {
               //3.还有账号没有出局，继续迭代
               egg = dynamicSplitType2(egg);
               isExit = false;
           }
       }

       if(isExit) {
           //所有账号都完成出局，投资完成
           return fvcAccounts;
       }

       //4.更新账户信息
       assignment(eggs);
       //5.迭代
       return investmentType1(this.getFvcAccounts());
    }

    @Override
    public FVCAccount split(FVCAccount fvcAccount) {
        fvcAccount.setFvc(fvcAccount.getFvc() * 2);
        fvcAccount.setCurrent_split_num(fvcAccount.getCurrent_split_num() + 1);
        return fvcAccount;
    }

    /**
     * 11拆出局方案，已最快方案复投产生点位
     * @param fvcAccount
     * @param profile_fvc
     * @return
     */
    @Override
    public FVCAccount profile(FVCAccount fvcAccount, double profile_fvc) {

        //计算除去手续费、回购剩余的收益fvc
        double restProfileCharged = profile_fvc * (1 - CHARGE_RATE) * (1 - RETURN_RATE);
        //1.更新收益的总fvc
        fvcAccount.setReturnTotalFVC(fvcAccount.getReturnTotalFVC() + profile_fvc);
        //2.更新账户余额
        fvcAccount.setFvc(fvcAccount.getFvc() - profile_fvc + profile_fvc * (1 - CHARGE_RATE ) * RETURN_RATE);
        //3.更新账户总收益
        fvcAccount.setProfile(fvcAccount.getProfile() + restProfileCharged);
        //4.判断是否需要复投
        int restEggs = TOTAL_EGGS - fvcAccounts.size();
        //5.进行复投判断
        while (restEggs > 0 && FVCUtils.isLegEgg(restProfileCharged , ACCOUNT_INIT_FVC)) {
            //6.满足生蛋要求，进行生蛋
            //7.投资方案所需鸡蛋数-1
            restEggs --;
            //8.剩余收益减少复投金额
            restProfileCharged -= ACCOUNT_INIT_FVC;
            //9.更新账号复投金额
            fvcAccount.setRecastFVC(fvcAccount.getRecastFVC() + ACCOUNT_INIT_FVC);
            //10.生蛋
            FVCAccount egg = new FVCAccount(fvcAccounts.size() + 1);
            fvcAccounts.add(egg);
            System.out.println("【复投信息】账户"+fvcAccount.getAccountId()+"复投产生新账户"+egg.getAccountId());
        }

        //打印账户收益信息
        System.out.println("【收益信息】第"+fvcAccount.getCurrent_split_num()+"拆，账户"+fvcAccount.getAccountId()+"："+fvcAccount);
        return fvcAccount;
    }

    @Override
    public FVCAccount dynamicSplitType2(FVCAccount fvcAccount) {
        //1.如果账户fvc+已收益的fvc >= 25000，则全部提现就行出局
        fvcAccount = IsSuccess(fvcAccount);
        if(fvcAccount.getOut()) {
            return fvcAccount;
        }
        //2.如果账户fvc超过5000则，提现5000
        if(fvcAccount.getFvc() > 5000) {
            fvcAccount = profile(fvcAccount , RETURN_FVC);
        }
        //3.继续拆分
        return split(fvcAccount);
    }

    @Override
    public FVCAccount IsSuccess(FVCAccount fvcAccount) {
        if(fvcAccount.getFvc() + fvcAccount.getReturnTotalFVC() >= MAX_TOTAL_FVC) {
            fvcAccount.setOut(true); //标志为出局
            fvcAccount = profile(fvcAccount , MAX_TOTAL_FVC - fvcAccount.getReturnTotalFVC());
            System.out.println("在第"+fvcAccount.getCurrent_split_num()+"拆时完成出局！");
        }
        return fvcAccount;
    }

    @Override
    public List<FVCAccount> clone(List<FVCAccount> fvcAccounts) throws CloneNotSupportedException {
        List<FVCAccount> eggs = new ArrayList<>();
        for(FVCAccount egg : fvcAccounts) {
            eggs.add((FVCAccount)egg.clone());
        }
        return eggs;
    }

    @Override
    public void assignment(List<FVCAccount> fvcAccounts) throws CloneNotSupportedException {
        for(FVCAccount egg : fvcAccounts) {
            FVCUtils.copyProperties(egg , this.getFvcAccounts().get(egg.getAccountId() - 1));
        }
    }
}
