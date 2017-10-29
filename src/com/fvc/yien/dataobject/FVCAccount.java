package com.fvc.yien.dataobject;

/**
 * Created by Administrator on 2017/10/24 0024.
 * FVC会员账户
 */
public class FVCAccount implements Cloneable{

    /**持有fvc最大值.*/
    private static final double MAX_OWN_FVC = 15000;

    /**当前拆分次数.*/
    private int current_split_num = 0;
    /**当前拥有fvc币.*/
    private double fvc = 1000;
    /**该账户的总收益.*/
    private double profile = 0.0;
    /**总提现fvc币.*/
    private double returnTotalFVC = 0.0;
    /**是否已经出局.*/
    private Boolean isOut = false;
    /**账户id.*/
    private Integer accountId;
    /**复投的fvc.*/
    private double recastDOLLAR = 0.0;

    public FVCAccount(Integer accountId) {
        this.accountId = accountId;
    }

    public FVCAccount() {
    }

    public int getCurrent_split_num() {
        return current_split_num;
    }

    public void setCurrent_split_num(int current_split_num) {
        this.current_split_num = current_split_num;
    }

    public double getFvc() {
        return fvc;
    }

    public void setFvc(double fvc) {
        if(fvc >= MAX_OWN_FVC) {
            System.out.println("超出账户持有fvc总额");
            fvc = MAX_OWN_FVC;
        }
        this.fvc = fvc;
    }

    public double getProfile() {
        return profile;
    }

    public void setProfile(double profile) {
        this.profile = profile;
    }

    public double getReturnTotalFVC() {
        return returnTotalFVC;
    }

    public void setReturnTotalFVC(double returnTotalFVC) {
        this.returnTotalFVC = returnTotalFVC;
    }

    public Boolean getOut() {
        return isOut;
    }

    public void setOut(Boolean out) {
        isOut = out;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public static double getMaxOwnFvc() {
        return MAX_OWN_FVC;
    }

    public double getRecastDOLLAR() {
        return recastDOLLAR;
    }

    public void setRecastDOLLAR(double recastDOLLAR) {
        this.recastDOLLAR = recastDOLLAR;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        FVCAccount egg = (FVCAccount)super.clone();
        return egg;
    }

    @Override
    public String toString() {
        return "FVCAccount{" +
                "current_split_num=" + current_split_num +
                ", fvc=" + fvc +
                ", profile=" + profile +
                ", returnTotalFVC=" + returnTotalFVC +
                ", isOut=" + isOut +
                ", accountId=" + accountId +
                ", recastDOLLAR=" + recastDOLLAR +
                '}';
    }
}
