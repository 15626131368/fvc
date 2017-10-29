package com.fvc.yien.dataobject;

/**
 * Created by Administrator on 2017/10/24 0024.
 * FVC会员账户
 */
public class FVCAccount {
    /**当前拆分次数.*/
    private int current_split_num = 0;
    /**当前拥有fvc币.*/
    private double fvc = 1000;
    /**该账户的总收益.*/
    private double profile = 0.0;
    /**总提现fvc币.*/
    private double returnTotalFVC = 0.0;
    /**持有fvc最大值.*/
    private static final double MAX_OWN_FVC = 15000;

    public FVCAccount(double fvc) {
        this.fvc = fvc;
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

    @Override
    public String toString() {
        return "FVCAccount{" +
                "current_split_num=" + current_split_num +
                ", fvc=" + fvc +
                ", profile=" + profile +
                ", returnTotalFVC=" + returnTotalFVC +
                '}';
    }
}
