package com.pinganfu.express.beans;

/**
 * Created by HUANGZHIJIANG416 on 2016/1/7.
 */
public class ServiceMethod {
    private  Object aServiceObject;
    private  String aFunctionName;
    private Class<?>[] aParameterClassTypes;
    private String errorInfo;

    public ServiceMethod() {
    }

    public ServiceMethod(Object aServiceObject, String aFunctionName, Class<?>[] aParameterClassTypes, String errorInfo) {
        this.aServiceObject = aServiceObject;
        this.aFunctionName = aFunctionName;
        this.aParameterClassTypes = aParameterClassTypes;
        this.errorInfo = errorInfo;
    }

    public Object getaServiceObject() {
        return aServiceObject;
    }

    public void setaServiceObject(Object aServiceObject) {
        this.aServiceObject = aServiceObject;
    }

    public String getaFunctionName() {
        return aFunctionName;
    }

    public void setaFunctionName(String aFunctionName) {
        this.aFunctionName = aFunctionName;
    }

    public Class<?>[] getaParameterClassTypes() {
        return aParameterClassTypes;
    }

    public void setaParameterClassTypes(Class<?>[] aParameterClassTypes) {
        this.aParameterClassTypes = aParameterClassTypes;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }
}
