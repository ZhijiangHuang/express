package com.pinganfu.operator;

import com.ql.util.express.Operator;

/**
 * Created by HUANGZHIJIANG416 on 2016/1/6.
 */
public class AddTwiceOperter extends Operator{

    @Override
    public Object executeInner(Object[] list) throws Exception {
        int a = (Integer)list[0];
        int b = (Integer)list[1];
        return a+b+b;
    }
}
