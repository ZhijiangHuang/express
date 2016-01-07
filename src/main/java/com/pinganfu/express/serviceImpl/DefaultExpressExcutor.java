package com.pinganfu.express.serviceImpl;

import com.pinganfu.express.beans.ClassMethod;
import com.pinganfu.express.beans.ServiceMethod;
import com.pinganfu.express.service.ExpressExecuor;
import com.ql.util.express.ExpressRunner;
import com.ql.util.express.IExpressContext;
import com.ql.util.express.Operator;

import javax.xml.ws.Service;
import java.util.List;
import java.util.Map;

/**
 * Created by HUANGZHIJIANG416 on 2016/1/7.
 */
public class DefaultExpressExcutor implements ExpressExecuor {

    private Map<String,Operator> operaters;
    private Map<String,String> operaterAlis;
    private Map<String,ClassMethod> classMethodMap;
    private Map<String,ServiceMethod> serviceMethodMap;


    private  ExpressRunner runner;


    public DefaultExpressExcutor() {
        runner = new ExpressRunner();
    }

    @Override
    public void addOperator(String name, Operator op) throws Exception {
        runner.addOperator(name, op);
    }

    @Override
    public void addOperatorWithAlias(String keyWordName, String realKeyWordName) throws Exception {
        runner.addOperatorWithAlias(keyWordName,realKeyWordName,null);

    }

    @Override
    public void addFunctionOfClassMethod(String name, String aClassName, String aFunctionName, Class<?>[] aParameterClassTypes, String errorInfo) throws Exception {
        runner.addFunctionOfClassMethod(name,aClassName,aFunctionName,aParameterClassTypes,errorInfo);
    }
    @Override

    public void addFunctionOfServiceMethod(String name, Object aServiceObject, String aFunctionName, Class<?>[] aParameterClassTypes, String errorInfo) throws Exception {
        runner.addFunctionOfServiceMethod(name,aServiceObject,aFunctionName,aParameterClassTypes,errorInfo);
    }
    @Override

    public Object execute(String expressString, IExpressContext<String, Object> context, List<String> errorList, boolean isCache, boolean isTrace) throws Exception {
        return runner.execute(expressString,context,errorList,isCache,isTrace);
    }
    @Override
    public void init() throws Exception {
        if (operaters != null){
            for (Map.Entry<String,Operator> entry: operaters.entrySet()){
                addOperator(entry.getKey(),entry.getValue());
            }
        }
        if (operaterAlis != null){
            for (Map.Entry<String,String> entry: operaterAlis.entrySet() ){
                addOperatorWithAlias(entry.getKey(),entry.getValue());
            }
        }
        if (classMethodMap != null){
            ClassMethod classMethod;
            for (Map.Entry<String,ClassMethod> entry : classMethodMap.entrySet()){
                classMethod = entry.getValue();
                this.addFunctionOfClassMethod(entry.getKey(),classMethod.getaClassName(),classMethod.getaFunctionName(),classMethod.getaParameterClassTypes(),classMethod.getErrorInfo());

            }
        }

        if (serviceMethodMap != null){
            ServiceMethod serviceMethod;
            for (Map.Entry<String,ServiceMethod> entry : serviceMethodMap.entrySet()){
                serviceMethod = entry.getValue();
                addFunctionOfServiceMethod(entry.getKey(),serviceMethod.getaServiceObject(),serviceMethod.getaFunctionName(),serviceMethod.getaParameterClassTypes(),serviceMethod.getErrorInfo());
            }
        }

    }


    public Map<String, Operator> getOperaters() {
        return operaters;
    }

    public void setOperaters(Map<String, Operator> operaters) {
        this.operaters = operaters;
    }

    public Map<String, String> getOperaterAlis() {
        return operaterAlis;
    }

    public void setOperaterAlis(Map<String, String> operaterAlis) {
        this.operaterAlis = operaterAlis;
    }

    public Map<String, ClassMethod> getClassMethodMap() {
        return classMethodMap;
    }

    public void setClassMethodMap(Map<String, ClassMethod> classMethodMap) {
        this.classMethodMap = classMethodMap;
    }

    public Map<String, ServiceMethod> getServiceMethodMap() {
        return serviceMethodMap;
    }

    public void setServiceMethodMap(Map<String, ServiceMethod> serviceMethodMap) {
        this.serviceMethodMap = serviceMethodMap;
    }

    public ExpressRunner getRunner() {
        return runner;
    }

    public void setRunner(ExpressRunner runner) {
        this.runner = runner;
    }

}
