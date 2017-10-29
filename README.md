# fvc

# 单账号6拆出局收益情况，方案一 FVCServiceImpl.dynamicSplitType1
```
第3拆账户：FVCAccount{current_split_num=3, fvc=4350.0, profile=3150.0, returnTotalFVC=5000.0}
第4拆账户：FVCAccount{current_split_num=4, fvc=4539.0, profile=6741.0, returnTotalFVC=10700.0}
第5拆账户：FVCAccount{current_split_num=5, fvc=4641.0599999999995, profile=10570.14, returnTotalFVC=16778.0}
第6拆账户：FVCAccount{current_split_num=6, fvc=3280.059999999999, profile=15750.0, returnTotalFVC=25000.0}
在第6拆时完成出局！
FVCAccount{current_split_num=6, fvc=3280.059999999999, profile=15750.0, returnTotalFVC=25000.0}
```

# 单账号6拆出局收益情况，方案二 FVCServiceImpl.dynamicSplitType2
```
第3拆账户：FVCAccount{current_split_num=3, fvc=4350.0, profile=3150.0, returnTotalFVC=5000.0}
第4拆账户：FVCAccount{current_split_num=4, fvc=5050.0, profile=6300.0, returnTotalFVC=10000.0}
第5拆账户：FVCAccount{current_split_num=5, fvc=6450.0, profile=9450.0, returnTotalFVC=15000.0}
第6拆账户：FVCAccount{current_split_num=6, fvc=5600.0, profile=15750.0, returnTotalFVC=25000.0}
在第6拆时完成出局！
FVCAccount{current_split_num=6, fvc=5600.0, profile=15750.0, returnTotalFVC=25000.0}
```

#11拆出局方案 InVestmentServiceImpl.investmentType1 回购发生在卖股阶段
```
【复投信息】账户1复投产生新账户2
【收益信息】第3拆，账户1：FVCAccount{current_split_num=3, fvc=4350.0, profile=9450.0, returnTotalFVC=5000.0, isOut=false, accountId=1, recastDOLLAR=5000.0}
【复投信息】账户1复投产生新账户3
【收益信息】第4拆，账户1：FVCAccount{current_split_num=4, fvc=5050.0, profile=18900.0, returnTotalFVC=10000.0, isOut=false, accountId=1, recastDOLLAR=10000.0}
【复投信息】账户1复投产生新账户4
【收益信息】第5拆，账户1：FVCAccount{current_split_num=5, fvc=6450.0, profile=28350.0, returnTotalFVC=15000.0, isOut=false, accountId=1, recastDOLLAR=15000.0}
【复投信息】账户1复投产生新账户5
【复投信息】账户1复投产生新账户6
【复投信息】账户1复投产生新账户7
【收益信息】第6拆，账户1：FVCAccount{current_split_num=6, fvc=5600.0, profile=47250.0, returnTotalFVC=25000.0, isOut=true, accountId=1, recastDOLLAR=30000.0}
账户1在第6拆时完成出局！
【复投信息】账户2复投产生新账户8
【收益信息】第3拆，账户2：FVCAccount{current_split_num=3, fvc=4350.0, profile=9450.0, returnTotalFVC=5000.0, isOut=false, accountId=2, recastDOLLAR=5000.0}
【收益信息】第4拆，账户2：FVCAccount{current_split_num=4, fvc=5050.0, profile=18900.0, returnTotalFVC=10000.0, isOut=false, accountId=2, recastDOLLAR=5000.0}
【收益信息】第3拆，账户3：FVCAccount{current_split_num=3, fvc=4350.0, profile=9450.0, returnTotalFVC=5000.0, isOut=false, accountId=3, recastDOLLAR=0.0}
【收益信息】第5拆，账户2：FVCAccount{current_split_num=5, fvc=6450.0, profile=28350.0, returnTotalFVC=15000.0, isOut=false, accountId=2, recastDOLLAR=5000.0}
【收益信息】第4拆，账户3：FVCAccount{current_split_num=4, fvc=5050.0, profile=18900.0, returnTotalFVC=10000.0, isOut=false, accountId=3, recastDOLLAR=0.0}
【收益信息】第3拆，账户4：FVCAccount{current_split_num=3, fvc=4350.0, profile=9450.0, returnTotalFVC=5000.0, isOut=false, accountId=4, recastDOLLAR=0.0}
【收益信息】第6拆，账户2：FVCAccount{current_split_num=6, fvc=5600.0, profile=47250.0, returnTotalFVC=25000.0, isOut=true, accountId=2, recastDOLLAR=5000.0}
账户2在第6拆时完成出局！
【收益信息】第5拆，账户3：FVCAccount{current_split_num=5, fvc=6450.0, profile=28350.0, returnTotalFVC=15000.0, isOut=false, accountId=3, recastDOLLAR=0.0}
【收益信息】第4拆，账户4：FVCAccount{current_split_num=4, fvc=5050.0, profile=18900.0, returnTotalFVC=10000.0, isOut=false, accountId=4, recastDOLLAR=0.0}
【收益信息】第3拆，账户5：FVCAccount{current_split_num=3, fvc=4350.0, profile=9450.0, returnTotalFVC=5000.0, isOut=false, accountId=5, recastDOLLAR=0.0}
【收益信息】第3拆，账户6：FVCAccount{current_split_num=3, fvc=4350.0, profile=9450.0, returnTotalFVC=5000.0, isOut=false, accountId=6, recastDOLLAR=0.0}
【收益信息】第3拆，账户7：FVCAccount{current_split_num=3, fvc=4350.0, profile=9450.0, returnTotalFVC=5000.0, isOut=false, accountId=7, recastDOLLAR=0.0}
【收益信息】第6拆，账户3：FVCAccount{current_split_num=6, fvc=5600.0, profile=47250.0, returnTotalFVC=25000.0, isOut=true, accountId=3, recastDOLLAR=0.0}
账户3在第6拆时完成出局！
【收益信息】第5拆，账户4：FVCAccount{current_split_num=5, fvc=6450.0, profile=28350.0, returnTotalFVC=15000.0, isOut=false, accountId=4, recastDOLLAR=0.0}
【收益信息】第4拆，账户5：FVCAccount{current_split_num=4, fvc=5050.0, profile=18900.0, returnTotalFVC=10000.0, isOut=false, accountId=5, recastDOLLAR=0.0}
【收益信息】第4拆，账户6：FVCAccount{current_split_num=4, fvc=5050.0, profile=18900.0, returnTotalFVC=10000.0, isOut=false, accountId=6, recastDOLLAR=0.0}
【收益信息】第4拆，账户7：FVCAccount{current_split_num=4, fvc=5050.0, profile=18900.0, returnTotalFVC=10000.0, isOut=false, accountId=7, recastDOLLAR=0.0}
【收益信息】第3拆，账户8：FVCAccount{current_split_num=3, fvc=4350.0, profile=9450.0, returnTotalFVC=5000.0, isOut=false, accountId=8, recastDOLLAR=0.0}
【收益信息】第6拆，账户4：FVCAccount{current_split_num=6, fvc=5600.0, profile=47250.0, returnTotalFVC=25000.0, isOut=true, accountId=4, recastDOLLAR=0.0}
账户4在第6拆时完成出局！
【收益信息】第5拆，账户5：FVCAccount{current_split_num=5, fvc=6450.0, profile=28350.0, returnTotalFVC=15000.0, isOut=false, accountId=5, recastDOLLAR=0.0}
【收益信息】第5拆，账户6：FVCAccount{current_split_num=5, fvc=6450.0, profile=28350.0, returnTotalFVC=15000.0, isOut=false, accountId=6, recastDOLLAR=0.0}
【收益信息】第5拆，账户7：FVCAccount{current_split_num=5, fvc=6450.0, profile=28350.0, returnTotalFVC=15000.0, isOut=false, accountId=7, recastDOLLAR=0.0}
【收益信息】第4拆，账户8：FVCAccount{current_split_num=4, fvc=5050.0, profile=18900.0, returnTotalFVC=10000.0, isOut=false, accountId=8, recastDOLLAR=0.0}
【收益信息】第6拆，账户5：FVCAccount{current_split_num=6, fvc=5600.0, profile=47250.0, returnTotalFVC=25000.0, isOut=true, accountId=5, recastDOLLAR=0.0}
账户5在第6拆时完成出局！
【收益信息】第6拆，账户6：FVCAccount{current_split_num=6, fvc=5600.0, profile=47250.0, returnTotalFVC=25000.0, isOut=true, accountId=6, recastDOLLAR=0.0}
账户6在第6拆时完成出局！
【收益信息】第6拆，账户7：FVCAccount{current_split_num=6, fvc=5600.0, profile=47250.0, returnTotalFVC=25000.0, isOut=true, accountId=7, recastDOLLAR=0.0}
账户7在第6拆时完成出局！
【收益信息】第5拆，账户8：FVCAccount{current_split_num=5, fvc=6450.0, profile=28350.0, returnTotalFVC=15000.0, isOut=false, accountId=8, recastDOLLAR=0.0}
【收益信息】第6拆，账户8：FVCAccount{current_split_num=6, fvc=5600.0, profile=47250.0, returnTotalFVC=25000.0, isOut=true, accountId=8, recastDOLLAR=0.0}
账户8在第6拆时完成出局！
FVCAccount{current_split_num=6, fvc=5600.0, profile=47250.0, returnTotalFVC=25000.0, isOut=true, accountId=1, recastDOLLAR=30000.0}
FVCAccount{current_split_num=6, fvc=5600.0, profile=47250.0, returnTotalFVC=25000.0, isOut=true, accountId=2, recastDOLLAR=5000.0}
FVCAccount{current_split_num=6, fvc=5600.0, profile=47250.0, returnTotalFVC=25000.0, isOut=true, accountId=3, recastDOLLAR=0.0}
FVCAccount{current_split_num=6, fvc=5600.0, profile=47250.0, returnTotalFVC=25000.0, isOut=true, accountId=4, recastDOLLAR=0.0}
FVCAccount{current_split_num=6, fvc=5600.0, profile=47250.0, returnTotalFVC=25000.0, isOut=true, accountId=5, recastDOLLAR=0.0}
FVCAccount{current_split_num=6, fvc=5600.0, profile=47250.0, returnTotalFVC=25000.0, isOut=true, accountId=6, recastDOLLAR=0.0}
FVCAccount{current_split_num=6, fvc=5600.0, profile=47250.0, returnTotalFVC=25000.0, isOut=true, accountId=7, recastDOLLAR=0.0}
FVCAccount{current_split_num=6, fvc=5600.0, profile=47250.0, returnTotalFVC=25000.0, isOut=true, accountId=8, recastDOLLAR=0.0}
总的收入（RMB）：17836000
总的收入（$）：2744000
总投资天数（DAY）：590
```

#11拆出局方案 InVestmentServiceImpl.investmentType1 回购发生在提现阶段
```
【复投信息】账户1复投产生新账户2
【收益信息】第3拆，账户1：FVCAccount{current_split_num=3, fvc=5486.0, profile=5669.999999999999, returnTotalFVC=3000.0, isOut=false, accountId=1, recastDOLLAR=5000.0}
【复投信息】账户1复投产生新账户3
【复投信息】账户1复投产生新账户4
【收益信息】第4拆，账户1：FVCAccount{current_split_num=4, fvc=5106.0, profile=18900.0, returnTotalFVC=10000.0, isOut=false, accountId=1, recastDOLLAR=15000.0}
【复投信息】账户1复投产生新账户5
【复投信息】账户1复投产生新账户6
【收益信息】第5拆，账户1：FVCAccount{current_split_num=5, fvc=4346.0, profile=32130.0, returnTotalFVC=17000.0, isOut=false, accountId=1, recastDOLLAR=25000.0}
【复投信息】账户1复投产生新账户7
【复投信息】账户1复投产生新账户8
【收益信息】第6拆，账户1：FVCAccount{current_split_num=6, fvc=1988.0, profile=47250.0, returnTotalFVC=25000.0, isOut=true, accountId=1, recastDOLLAR=35000.0}
账户1在第6拆时完成出局！
【收益信息】第3拆，账户2：FVCAccount{current_split_num=3, fvc=5486.0, profile=5669.999999999999, returnTotalFVC=3000.0, isOut=false, accountId=2, recastDOLLAR=0.0}
【收益信息】第4拆，账户2：FVCAccount{current_split_num=4, fvc=5106.0, profile=18900.0, returnTotalFVC=10000.0, isOut=false, accountId=2, recastDOLLAR=0.0}
【收益信息】第3拆，账户3：FVCAccount{current_split_num=3, fvc=5486.0, profile=5669.999999999999, returnTotalFVC=3000.0, isOut=false, accountId=3, recastDOLLAR=0.0}
【收益信息】第3拆，账户4：FVCAccount{current_split_num=3, fvc=5486.0, profile=5669.999999999999, returnTotalFVC=3000.0, isOut=false, accountId=4, recastDOLLAR=0.0}
【收益信息】第5拆，账户2：FVCAccount{current_split_num=5, fvc=4346.0, profile=32130.0, returnTotalFVC=17000.0, isOut=false, accountId=2, recastDOLLAR=0.0}
【收益信息】第4拆，账户3：FVCAccount{current_split_num=4, fvc=5106.0, profile=18900.0, returnTotalFVC=10000.0, isOut=false, accountId=3, recastDOLLAR=0.0}
【收益信息】第4拆，账户4：FVCAccount{current_split_num=4, fvc=5106.0, profile=18900.0, returnTotalFVC=10000.0, isOut=false, accountId=4, recastDOLLAR=0.0}
【收益信息】第3拆，账户5：FVCAccount{current_split_num=3, fvc=5486.0, profile=5669.999999999999, returnTotalFVC=3000.0, isOut=false, accountId=5, recastDOLLAR=0.0}
【收益信息】第3拆，账户6：FVCAccount{current_split_num=3, fvc=5486.0, profile=5669.999999999999, returnTotalFVC=3000.0, isOut=false, accountId=6, recastDOLLAR=0.0}
【收益信息】第6拆，账户2：FVCAccount{current_split_num=6, fvc=1988.0, profile=47250.0, returnTotalFVC=25000.0, isOut=true, accountId=2, recastDOLLAR=0.0}
账户2在第6拆时完成出局！
【收益信息】第5拆，账户3：FVCAccount{current_split_num=5, fvc=4346.0, profile=32130.0, returnTotalFVC=17000.0, isOut=false, accountId=3, recastDOLLAR=0.0}
【收益信息】第5拆，账户4：FVCAccount{current_split_num=5, fvc=4346.0, profile=32130.0, returnTotalFVC=17000.0, isOut=false, accountId=4, recastDOLLAR=0.0}
【收益信息】第4拆，账户5：FVCAccount{current_split_num=4, fvc=5106.0, profile=18900.0, returnTotalFVC=10000.0, isOut=false, accountId=5, recastDOLLAR=0.0}
【收益信息】第4拆，账户6：FVCAccount{current_split_num=4, fvc=5106.0, profile=18900.0, returnTotalFVC=10000.0, isOut=false, accountId=6, recastDOLLAR=0.0}
【收益信息】第3拆，账户7：FVCAccount{current_split_num=3, fvc=5486.0, profile=5669.999999999999, returnTotalFVC=3000.0, isOut=false, accountId=7, recastDOLLAR=0.0}
【收益信息】第3拆，账户8：FVCAccount{current_split_num=3, fvc=5486.0, profile=5669.999999999999, returnTotalFVC=3000.0, isOut=false, accountId=8, recastDOLLAR=0.0}
【收益信息】第6拆，账户3：FVCAccount{current_split_num=6, fvc=1988.0, profile=47250.0, returnTotalFVC=25000.0, isOut=true, accountId=3, recastDOLLAR=0.0}
账户3在第6拆时完成出局！
【收益信息】第6拆，账户4：FVCAccount{current_split_num=6, fvc=1988.0, profile=47250.0, returnTotalFVC=25000.0, isOut=true, accountId=4, recastDOLLAR=0.0}
账户4在第6拆时完成出局！
【收益信息】第5拆，账户5：FVCAccount{current_split_num=5, fvc=4346.0, profile=32130.0, returnTotalFVC=17000.0, isOut=false, accountId=5, recastDOLLAR=0.0}
【收益信息】第5拆，账户6：FVCAccount{current_split_num=5, fvc=4346.0, profile=32130.0, returnTotalFVC=17000.0, isOut=false, accountId=6, recastDOLLAR=0.0}
【收益信息】第4拆，账户7：FVCAccount{current_split_num=4, fvc=5106.0, profile=18900.0, returnTotalFVC=10000.0, isOut=false, accountId=7, recastDOLLAR=0.0}
【收益信息】第4拆，账户8：FVCAccount{current_split_num=4, fvc=5106.0, profile=18900.0, returnTotalFVC=10000.0, isOut=false, accountId=8, recastDOLLAR=0.0}
【收益信息】第6拆，账户5：FVCAccount{current_split_num=6, fvc=1988.0, profile=47250.0, returnTotalFVC=25000.0, isOut=true, accountId=5, recastDOLLAR=0.0}
账户5在第6拆时完成出局！
【收益信息】第6拆，账户6：FVCAccount{current_split_num=6, fvc=1988.0, profile=47250.0, returnTotalFVC=25000.0, isOut=true, accountId=6, recastDOLLAR=0.0}
账户6在第6拆时完成出局！
【收益信息】第5拆，账户7：FVCAccount{current_split_num=5, fvc=4346.0, profile=32130.0, returnTotalFVC=17000.0, isOut=false, accountId=7, recastDOLLAR=0.0}
【收益信息】第5拆，账户8：FVCAccount{current_split_num=5, fvc=4346.0, profile=32130.0, returnTotalFVC=17000.0, isOut=false, accountId=8, recastDOLLAR=0.0}
【收益信息】第6拆，账户7：FVCAccount{current_split_num=6, fvc=1988.0, profile=47250.0, returnTotalFVC=25000.0, isOut=true, accountId=7, recastDOLLAR=0.0}
账户7在第6拆时完成出局！
【收益信息】第6拆，账户8：FVCAccount{current_split_num=6, fvc=1988.0, profile=47250.0, returnTotalFVC=25000.0, isOut=true, accountId=8, recastDOLLAR=0.0}
账户8在第6拆时完成出局！
FVCAccount{current_split_num=6, fvc=1988.0, profile=47250.0, returnTotalFVC=25000.0, isOut=true, accountId=1, recastDOLLAR=35000.0}
FVCAccount{current_split_num=6, fvc=1988.0, profile=47250.0, returnTotalFVC=25000.0, isOut=true, accountId=2, recastDOLLAR=0.0}
FVCAccount{current_split_num=6, fvc=1988.0, profile=47250.0, returnTotalFVC=25000.0, isOut=true, accountId=3, recastDOLLAR=0.0}
FVCAccount{current_split_num=6, fvc=1988.0, profile=47250.0, returnTotalFVC=25000.0, isOut=true, accountId=4, recastDOLLAR=0.0}
FVCAccount{current_split_num=6, fvc=1988.0, profile=47250.0, returnTotalFVC=25000.0, isOut=true, accountId=5, recastDOLLAR=0.0}
FVCAccount{current_split_num=6, fvc=1988.0, profile=47250.0, returnTotalFVC=25000.0, isOut=true, accountId=6, recastDOLLAR=0.0}
FVCAccount{current_split_num=6, fvc=1988.0, profile=47250.0, returnTotalFVC=25000.0, isOut=true, accountId=7, recastDOLLAR=0.0}
FVCAccount{current_split_num=6, fvc=1988.0, profile=47250.0, returnTotalFVC=25000.0, isOut=true, accountId=8, recastDOLLAR=0.0}
总的收入（RMB）：17836000
总的收入（$）：2744000
总投资天数（DAY）：545
```

