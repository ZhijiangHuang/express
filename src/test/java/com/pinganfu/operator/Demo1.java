package com.pinganfu.operator;
import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import com.ql.util.express.IExpressContext;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by HUANGZHIJIANG416 on 2016/1/6.
 */
public class Demo1 {
    ExpressRunner runner;
    String str;
//    @Before
//    public void init(){
//        ExpressRunner runner = new ExpressRunner(false,true);
//    }

    @Test
    public void testDemo() throws Exception {
        String express = "10*10 + 1 + 2*3 + 5*2";
        ExpressRunner runner = new ExpressRunner(false,true);//显示执行编译过程
        Object r = runner.execute(express,null,null,false,true);//显示指令执行过程
        Assert.assertTrue("表达式计算",r.toString().equalsIgnoreCase("117"));
        System.out.println("表达式计算：" + express + " = " + r);
    }

    @Test
    public void performanceTest() throws Exception {
        ExpressRunner runner = new ExpressRunner();
        String express = "10 * 10 + 1 + 2 * 3 + 5 * 2";
        int num = 100000;
        runner.execute(express,null, null, true,false);
        long start = System.currentTimeMillis();
        for(int i = 0;i< num;i++){
            runner.execute(express,null, null, false,false);
        }
        System.out.println("执行" + num +"次\""+ express +"\" 耗时："
                + (System.currentTimeMillis() - start));
    }

    @Test
    public void ifTest() throws Exception {
        ExpressRunner runner = new ExpressRunner(false,true);
        runner.addOperatorWithAlias("如果","if",null);
        runner.addOperatorWithAlias("则","then",null);
        runner.addOperatorWithAlias("否则","else",null);
        String express = "如果 1==2 则 4 否则 3";
        Object r = runner.execute(express,null,null,false,true);
        System.out.println(r);
    }

    @Test
    public void operatorTest() throws Exception {
        ExpressRunner runner = new ExpressRunner(false,true);
        runner.addOperator("add",new AddOperator());
//        runner.addOperator("add","in",new AddOperator());
//        runner.addOperatorWithAlias("add","-",null);
//        str = "1 add (1,2,3)";
        str = "1 add 2 add 1";
        Object o = runner.execute(str, null, null, false, true);
        System.out.println("result:" + o);
    }

    @Test
    public void operatorWithParamsTest() throws Exception {
        str = "i add j add n";
        IExpressContext<String,Object> expressContext = new DefaultContext<String, Object>();
        expressContext.put("i",Integer.valueOf(1));
        expressContext.put("j",Integer.valueOf(22));
        expressContext.put("n",Integer.valueOf(2));
        ExpressRunner runner = new ExpressRunner(false,true);
        runner.addOperator("add", new AddTwiceOperter());
        int res = (Integer)runner.execute(str,expressContext,null,false,true);
        System.out.println(res);
    }


}
