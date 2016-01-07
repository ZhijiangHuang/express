package com.pinganfu.operator;

import com.ql.util.express.ExpressRunner;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by HUANGZHIJIANG416 on 2016/1/7.
 */
public class Demo {
    @Test
    public void testDemo() throws Exception {
        String express = "10*10 + 1 + 2*3 + 5*2";
        ExpressRunner runner = new ExpressRunner(false,true);//显示执行编译过程
        Object r = runner.execute(express,null,null,false,true);//显示指令执行过程
        Assert.assertTrue("表达式计算", r.toString().equalsIgnoreCase("117"));
        System.out.println("表达式计算：" + express + " = " + r);
    }
}
