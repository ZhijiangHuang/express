package com.pinganfu.express.serviceImpl;

import com.pinganfu.express.service.ExpressExecuor;
import org.springframework.context.ApplicationContext;

import java.util.HashMap;

/**
 * Created by HUANGZHIJIANG416 on 2016/1/7.
 */
public class ExpressUtil {
    private ExpressExecuor execuor;
    private ApplicationContext applicationContext;

    public Object execute(String express,HashMap<String,Object> aContext) throws Exception {
        ExpressContextUtil context = new ExpressContextUtil(aContext,applicationContext);
        return execuor.execute(express,context,null,false,false);
    }
}
