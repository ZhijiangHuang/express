package com.pinganfu.operator;

import com.ql.util.express.Operator;

/**
 * Created by HUANGZHIJIANG416 on 2016/1/7.
 */
public class ApproveOperator extends Operator{
    int operator = 0;

    public ApproveOperator(int operator) {
        this.operator = operator;
    }

    @Override
    public Object executeInner(Object[] list) throws Exception {
        if(this.operator == 1){
            System.out.println(list[0] + "审批:金额:" + list[1]);
            if(((Integer)list[1]) > 6000)
                return false;
        }
        else if(this.operator == 2)
            System.out.println("报销入卡:金额:"+list[0]);
        else
            System.out.println("重填:申请人:"+list[0]);
        return true;
    }
}
