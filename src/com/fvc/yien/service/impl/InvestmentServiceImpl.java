package com.fvc.yien.service.impl;

import com.fvc.yien.dataobject.FVCAccount;
import com.fvc.yien.service.InvestmentService;
import com.fvc.yien.utils.FVCUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    /**fvc对应美元汇率.*/
    private static final double FVC_EXCHANGE_DOLLAR_RATE = 3;
    /**累计兑换的fvc最大值.*/
    private static final double MAX_TOTAL_FVC = 25000;
    /**总共的鸡蛋数量.*/
    private static final Integer TOTAL_EGGS = 8;
    /**每次收益的fvc币.*/
    private static final double RETURN_FVC = 5000;
    /**账户初始投资fvc.*/
    private static final double ACCOUNT_INIT_DOLLAR = 5000;
    /**投资方案总收益RMB.*/
    private BigDecimal investment_total_profile_rmb = new BigDecimal(0);
    /**投资方案总收益$.*/
    private BigDecimal investment_total_profile_dollar = new BigDecimal(0);
    /**11拆每次拆分提现fvc*/
    private static final Map<Integer , Double> SPLIT_NUM_MAP_PROFILE_FVC = new HashMap<Integer , Double>(){{
        put(3 , 3000.0);
        put(4 , 7000.0);
        put(5 , 7000.0);
        put(6 , 8000.0);
    }};

    /**美元和电子分的汇率.*/
    private static final double DOLLARS_EXCHANGE_ELECTRONIC_CURRENCY_RATE = 0.6;



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

    public BigDecimal getInvestment_total_profile_rmb() {
        return investment_total_profile_rmb;
    }

    public void setInvestment_total_profile_rmb(BigDecimal investment_total_profile_rmb) {
        this.investment_total_profile_rmb = investment_total_profile_rmb;
    }

    public BigDecimal getInvestment_total_profile_dollar() {
        return investment_total_profile_dollar;
    }

    public void setInvestment_total_profile_dollar(BigDecimal investment_total_profile_dollar) {
        this.investment_total_profile_dollar = investment_total_profile_dollar;
    }

    @Override
    public List<FVCAccount> investmentType1(List<FVCAccount> fvcAccounts) throws CloneNotSupportedException {

        //1.更新投资总的天数
        updateInvestmentDays(fvcAccounts);

        //2.克隆
       List<FVCAccount> eggs = clone(fvcAccounts);
       boolean isExit = true;

       for(FVCAccount egg : eggs) {
           //3.判断是否出局
           if(!egg.getOut()) {
               //3.还有账号没有出局，继续迭代
               egg = dynamicSplitType2(egg);
               isExit = false;
           }
       }

       if(isExit) {
           //所有账号都完成出局，投资完成
           //1.计算总的收入
           calculateInvestmentProfile(fvcAccounts);
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
        //判断收益的fvc是否超出账户持有fvc总额
        if(fvcAccount.getFvc() >= profile_fvc) {
            //计算除去手续费、回购剩余的收益fvc
            double restProfileCharged = profile_fvc * (1 - CHARGE_RATE) * (1 - RETURN_RATE) * FVC_EXCHANGE_DOLLAR_RATE;
            //1.更新收益的总fvc
            fvcAccount.setReturnTotalFVC(fvcAccount.getReturnTotalFVC() + profile_fvc);
            //2.更新账户余额
            fvcAccount.setFvc(fvcAccount.getFvc() - profile_fvc
                    + profile_fvc * (1 - CHARGE_RATE ) * RETURN_RATE * DOLLARS_EXCHANGE_ELECTRONIC_CURRENCY_RATE);
            //3.更新账户总收益
            fvcAccount.setProfile(fvcAccount.getProfile() + restProfileCharged);
            //4.判断是否需要复投
            int restEggs = TOTAL_EGGS - fvcAccounts.size();
            //5.进行复投判断
            while (restEggs > 0 && FVCUtils.isLegEgg(restProfileCharged , ACCOUNT_INIT_DOLLAR)) {
                //6.满足生蛋要求，进行生蛋
                //7.投资方案所需鸡蛋数-1
                restEggs --;
                //8.剩余收益减少复投金额
                restProfileCharged -= ACCOUNT_INIT_DOLLAR;
                //9.更新账号复投金额
                fvcAccount.setRecastDOLLAR(fvcAccount.getRecastDOLLAR() + ACCOUNT_INIT_DOLLAR);
                //10.生蛋
                FVCAccount egg = new FVCAccount(fvcAccounts.size() + 1);
                fvcAccounts.add(egg);
                System.out.println("【复投信息】账户"+fvcAccount.getAccountId()+"复投产生新账户"+egg.getAccountId());
            }

            //打印账户收益信息
            System.out.println("【收益信息】第"+fvcAccount.getCurrent_split_num()+"拆，账户"+fvcAccount.getAccountId()+"："+fvcAccount);
        }else {
            System.err.println("卖出fvc数量超过账户"+fvcAccount.getAccountId()+"持有的fvc总额");
        }
        return fvcAccount;
    }

    @Override
    public FVCAccount dynamicSplitType2(FVCAccount fvcAccount) {
        //1.如果账户fvc+已收益的fvc >= 25000，则全部提现就行出局
        fvcAccount = IsSuccess(fvcAccount);
        if(fvcAccount.getOut()) {
            return fvcAccount;
        }
//        //2.如果账户fvc超过5000则，提现5000
//        if(fvcAccount.getFvc() > 5000) {
//            fvcAccount = profile(fvcAccount , RETURN_FVC);
//        }
        //2.判断是否进行收益的拆分
        if(SPLIT_NUM_MAP_PROFILE_FVC.keySet().contains(fvcAccount.getCurrent_split_num())) {
            fvcAccount = profile(fvcAccount , SPLIT_NUM_MAP_PROFILE_FVC.get(fvcAccount.getCurrent_split_num()));
        }
        //3.继续拆分
        return split(fvcAccount);
    }

    @Override
    public FVCAccount IsSuccess(FVCAccount fvcAccount) {
        if(fvcAccount.getFvc() + fvcAccount.getReturnTotalFVC() >= MAX_TOTAL_FVC) {
            fvcAccount.setOut(true); //标志为出局
            fvcAccount = profile(fvcAccount , MAX_TOTAL_FVC - fvcAccount.getReturnTotalFVC());
            System.out.println("账户"+fvcAccount.getAccountId()+"在第"+fvcAccount.getCurrent_split_num()+"拆时完成出局！");
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

    @Override
    public void updateInvestmentDays(List<FVCAccount> fvcAccounts) {
        //1.循环遍历，取出拆分次数对应最大的平均天数，作为当前轮拆分需要的时间
        Integer tmp_investment_days = 0;
        for(FVCAccount egg : fvcAccounts) {
            if(!egg.getOut() && tmp_investment_days < FVCUtils.getInvestmentDays(egg.getCurrent_split_num())) {
                tmp_investment_days = FVCUtils.getInvestmentDays(egg.getCurrent_split_num());
            }
        }
        //2.更新投资天数
        this.setInvestmentTotalDays(this.getInvestmentTotalDays() + tmp_investment_days);
    }

    @Override
    public void calculateInvestmentProfile(List<FVCAccount> fvcAccounts) {
       //1.循环遍历，最终收益为，回收的fvc总币-复投的fvc总币
        Double tmp_profile = 0.0;
        for(FVCAccount egg : fvcAccounts) {
            tmp_profile = egg.getProfile() - egg.getRecastDOLLAR();
            //2.更新美元总收入
            this.setInvestment_total_profile_dollar(this.getInvestment_total_profile_dollar().add(new BigDecimal(tmp_profile * TOTAL_EGGS)));
            //3.更新人民币总收入
            this.setInvestment_total_profile_rmb(this.getInvestment_total_profile_rmb().add(new BigDecimal(tmp_profile * DOLLARS_EXCHANGE_RMB_RATE * TOTAL_EGGS)));
        }
    }
}
