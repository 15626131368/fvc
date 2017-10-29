package com.fvc.yien.utils;

import com.fvc.yien.dataobject.FVCAccount;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/29 0029.
 */
public class FVCUtils {

    private static Map<Integer,Integer> SPLIT_NUMS_MAP_TO_INVESTMENT_DAYS =
            new HashMap<Integer,Integer>(){{
                put(1 , 35);
                put(2 , 35);
                put(3 , 35);
                put(4 , 45);
                put(5 , 45);
                put(6 , 45);
                put(7 , 45);
            }};

    /**
     * 对应拆分次数需要的天数
     * @param split_nums
     * @return
     */
    public static Integer FVCUtils(Integer split_nums){
        return SPLIT_NUMS_MAP_TO_INVESTMENT_DAYS.get(split_nums);
    }

    /**
     * 判断是否能生蛋
     * @param restChargedFvc
     * @param initFvc
     * @return
     */
    public static Boolean isLegEgg(double restChargedFvc , double initFvc) {
        return restChargedFvc - initFvc > 0.01;
    }

    public static void copyProperties(FVCAccount source , FVCAccount target) {
        target.setOut(source.getOut());
        target.setRecastFVC(source.getRecastFVC());
        target.setFvc(source.getFvc());
        target.setCurrent_split_num(source.getCurrent_split_num());
        target.setProfile(source.getProfile());
        target.setReturnTotalFVC(source.getReturnTotalFVC());
    }

}
