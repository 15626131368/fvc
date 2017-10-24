import com.fvc.yien.dataobject.FVCAccount;
import com.fvc.yien.service.FVCService;
import com.fvc.yien.service.impl.FVCServiceImpl;

import java.util.Arrays;
import java.util.List;

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
       System.out.println(fvc_split(new FVCAccount()));
    }

    public static FVCAccount fvc_split(FVCAccount fvcAccount) {

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
        return fvc_split(fvcService.split(fvcAccount));
    }

}
