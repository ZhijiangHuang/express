package com.pinganfu.express.beans;

/**
 * Created by HUANGZHIJIANG416 on 2016/1/7.
 */
public class ClassMethod {
    String aClassName;
    String aFunctionName;
    Class<?>[] aParameterClassTypes;
    String errorInfo;
    public ClassMethod(){}
    public ClassMethod( String aClassName, String aFunctionName, Class<?>[] aParameterClassTypes, String errorInfo) {
        this.aClassName = aClassName;
        this.aFunctionName = aFunctionName;
        this.aParameterClassTypes = aParameterClassTypes;
        this.errorInfo = errorInfo;
    }

    public String getaClassName() {
        return aClassName;
    }

    public void setaClassName(String aClassName) {
        this.aClassName = aClassName;
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
