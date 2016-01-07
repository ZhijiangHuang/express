package com.pinganfu.express.serviceImpl;

import com.pinganfu.express.service.ExpressContext;
import com.ql.util.express.IExpressContext;
import org.springframework.context.ApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by HUANGZHIJIANG416 on 2016/1/7.
 */
public class ExpressContextUtil extends HashMap<String,Object> implements ExpressContext, IExpressContext<String, Object> {
    private ApplicationContext context;

    public ExpressContextUtil(ApplicationContext aContext) {
        this.context = aContext;
    }

    public ExpressContextUtil(Map<String, Object> aProperties,
                              ApplicationContext aContext) {
        super(aProperties);
        this.context = aContext;
    }

    /**
     * 抽象方法：根据名称从属性列表中提取属性值
     */
    public Object get(Object name) {
        Object result = null;
        result = super.get(name);
        try {
            if (result == null && this.context != null
                    && this.context.containsBean((String) name)) {
                // 如果在Spring容器中包含bean，则返回String的Bean
                result = this.context.getBean((String) name);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
