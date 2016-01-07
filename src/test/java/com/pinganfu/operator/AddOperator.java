package com.pinganfu.operator;

import com.ql.util.express.Operator;

/**
 * Created by HUANGZHIJIANG416 on 2016/1/6.
 */
public class AddOperator  extends Operator{
    @Override
    public Object executeInner(Object[] list) throws Exception {
        int res = 0;
        System.out.println("listlength:" + list.length );
        System.out.println("listContent:" );
        for (int i = 0; i < list.length; i++){
            System.out.println(list[i]);
            res = res + (Integer)list[i];
        }
        return res;
    }
}
