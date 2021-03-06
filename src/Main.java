import com.fvc.yien.dataobject.FVCAccount;
import com.fvc.yien.service.FVCService;
import com.fvc.yien.service.impl.FVCServiceImpl;
import com.fvc.yien.service.impl.InvestmentServiceImpl;

import java.util.*;

public class Main {
    /**总拆分上限.*/
    private static final int SPLIT_NUM = 7;
    /**持有fvc最大值.*/
    private static final double MAX_OWN_FVC = 15000;
    /**累计兑换的fvc最大值.*/
    private static final double MAX_TOTAL_FVC = 25000;
    /**收益的拆分次数.*/
    private static final List<Integer> SPLIT_NUM_TO_PROFIT = Arrays.asList(3 , 5 , 6 , 7);

    private static FVCService fvcService = new FVCServiceImpl();

    private static final double PROFILE_FVC = 5000;

    public static void main(String[] args) {
//       System.out.println(fvcCommonSplit(new FVCAccount()));
//        System.out.println(fvcService.dynamicSplitType1(new FVCAccount()));
//        System.out.println(fvcService.dynamicSplitType2(new FVCAccount()));
//        fvcOutTest(new FVCAccount());

        InvestmentServiceImpl investmentService = new InvestmentServiceImpl();
        List<FVCAccount> fvcAccounts = new ArrayList<>();
        fvcAccounts.add(new FVCAccount(fvcAccounts.size() + 1));
        investmentService.setFvcAccounts(fvcAccounts);

        List<FVCAccount> eggs = null;
        try {
            eggs = investmentService.investmentType1(fvcAccounts);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        for(FVCAccount egg : eggs) {
            System.out.println(egg);
        }

        System.out.println("总的收入（RMB）："+investmentService.getInvestment_total_profile_rmb());
        System.out.println("总的收入（$）："+investmentService.getInvestment_total_profile_dollar());
        System.out.println("总投资天数（DAY）："+investmentService.getInvestmentTotalDays());
    }

//    第3拆账户：FVCAccount{current_split_num=3, fvc=4350.0, profile=3150.0, returnTotalFVC=5000.0}
//    超出账户持有fvc总额
//    第5拆账户：FVCAccount{current_split_num=5, fvc=11350.0, profile=6300.0, returnTotalFVC=10000.0}
//    超出账户持有fvc总额
//    第6拆账户：FVCAccount{current_split_num=6, fvc=11350.0, profile=9450.0, returnTotalFVC=15000.0}
//    超出账户持有fvc总额
//    第7拆账户：FVCAccount{current_split_num=7, fvc=7700.0, profile=15750.0, returnTotalFVC=25000.0}
//    FVCAccount{current_split_num=7, fvc=7700.0, profile=15750.0, returnTotalFVC=25000.0}
    public static FVCAccount fvcCommonSplit(FVCAccount fvcAccount) {

        //判断是否拆分卖出
        if(SPLIT_NUM_TO_PROFIT.contains(fvcAccount.getCurrent_split_num())) {
            //收益,以5000fvc收益计算
            if(fvcAccount.getCurrent_split_num() == 7) {
                return fvcService.profile(fvcAccount , PROFILE_FVC * 2);
            }else {
                fvcAccount = fvcService.profile(fvcAccount , PROFILE_FVC);
            }
        }

        //迭代进行拆分
        return fvcCommonSplit(fvcService.split(fvcAccount));
    }

    /**
     * 6拆出局尝试
     * @param fvcAccount
     * @return
     */
    public static void fvcOutTest(FVCAccount fvcAccount) {
        Map<Integer , Double> map = new HashMap<Integer , Double>(){{
            put(3 , 3000.0);
            put(4 , 7000.0);
            put(5 , 7000.0);
            put(6 , 8000.0);
        }};

        FVCAccount egg = new FVCAccount();
        egg.setFvc(8000);
        egg.setCurrent_split_num(3);

        for(Integer split_num : map.keySet()) {
            egg = fvcService.profile(egg , map.get(split_num));
            egg = fvcService.split(egg);
        }

        System.out.print(egg);
    }

}
