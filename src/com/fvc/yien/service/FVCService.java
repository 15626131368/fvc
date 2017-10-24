package com.fvc.yien.service;

import com.fvc.yien.dataobject.FVCAccount;

/**
 * Created by Administrator on 2017/10/24 0024.
 */
public interface FVCService {
    /**拆分.*/
    FVCAccount split(FVCAccount fvcAccount);
    /**收益.*/
    FVCAccount profile(FVCAccount fvcAccount , double profile_fvc);
}
