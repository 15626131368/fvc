package com.fvc.yien.service;

import com.fvc.yien.dataobject.FVCAccount;

import java.util.List;

/**
 * Created by Administrator on 2017/10/29 0029.
 * FVC投资方案
 */
public interface InvestmentService {

    /**
     * 11拆出局方案
     */
    List<FVCAccount> investmentType1(List<FVCAccount> fvcAccounts) throws CloneNotSupportedException;

    /**拆分.*/
    FVCAccount split(FVCAccount fvcAccount);
    /**收益.*/
    FVCAccount profile(FVCAccount fvcAccount , double profile_fvc);

    /**
     * 收益
     * 1.如果账户fvc币值超过5000，收益5000
     * 2.如果账户fvc币+已收益fvc币达到25000则全部提现，并出局
     * @param fvcAccount
     * @return
     */
    FVCAccount dynamicSplitType2(FVCAccount fvcAccount);

    /**
     * 完成出局
     * @param fvcAccount
     * @return
     */
    FVCAccount IsSuccess(FVCAccount fvcAccount);

    /**
     * 克隆
     * @param fvcAccounts
     * @return
     * @throws CloneNotSupportedException
     */
    List<FVCAccount> clone(List<FVCAccount> fvcAccounts) throws CloneNotSupportedException;

    /**
     * 赋值
     * @param fvcAccounts
     */
    void assignment(List<FVCAccount> fvcAccounts) throws CloneNotSupportedException;

    /**
     * 计算总的投资天数
     * @param fvcAccounts
     */
    void updateInvestmentDays(List<FVCAccount> fvcAccounts);

    /**
     * 计算投资方案总的收益
     * @param fvcAccounts
     * @return
     */
    void calculateInvestmentProfile(List<FVCAccount> fvcAccounts);
}
